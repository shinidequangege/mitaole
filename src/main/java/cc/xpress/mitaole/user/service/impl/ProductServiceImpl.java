package cc.xpress.mitaole.user.service.impl;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.config.ProductConfig;
import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dao.IProductDAO;
import cc.xpress.mitaole.user.dto.BrandTbDTO;
import cc.xpress.mitaole.user.dto.ModelConfigTbDTO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.user.service.IProductService;
import cc.xpress.mitaole.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 17:06
 * @modified By:
 */
@Service("productServiceImpl")
public class ProductServiceImpl extends BaseServiceImpl<ModelTbDTO> implements IProductService{
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    IProductDAO productDAO;
    /**
     * 获取手机回收信息
     * @param modelTbDTO
     * @param model
     */
    @Transactional
    @Override
    public void getProductInfoById(ModelTbDTO modelTbDTO, Model model) throws NullPointerException{
        long start = System.currentTimeMillis();
        ModelTbDTO entityById = getEntityById(modelTbDTO);
        List<Map<String,Set<ModelConfigTbDTO>>> info = new ArrayList<>();
        MongoCollection<Document> modelTable = mongoTemplate.getCollection("model_info");
        FindIterable<Document> documents = modelTable.find(Filters.eq("modelId", entityById.getModelId()));
        MongoCursor<Document> iterator = documents.iterator();
        if(iterator.hasNext()){
            String modelInfo= iterator.tryNext().getString("info");
            logger.info(modelInfo);
            Type type = new TypeReference<List<Map<String,TreeSet<ModelConfigTbDTO>>>>() {}.getType();
            info=(List<Map<String,Set<ModelConfigTbDTO>>>)JSON.parseObject(modelInfo, type);
        }else{
            Set<ModelConfigTbDTO> modelConfigTbDTOSet = entityById.getModelConfigTbDTOSet();
            Map<String,Set<ModelConfigTbDTO>> step1=new HashMap<>();
            Map<String,Set<ModelConfigTbDTO>> step2=new HashMap<>();
            Map<String,Set<ModelConfigTbDTO>> step3=new HashMap<>();
            for(ModelConfigTbDTO md:modelConfigTbDTOSet){
                String typeName = md.getConfigTbDTO().getTypeTbDTO().getTypeName();
                switch (md.getConfigTbDTO().getTypeTbDTO().getTypeStep()){
                    case 1:
                        addToSet(step1,md,typeName);
                        break;
                    case 2:
                        addToSet(step2,md,typeName);
                        break;
                    case 3:
                        addToSet(step3,md,typeName);
                        break;
                }
            }
            info.add(step1);
            info.add(step2);
            info.add(step3);
            String jsonInfo=JSON.toJSONString(info);
            logger.info(jsonInfo);
            MongoCollection<Document> modelInfo = mongoTemplate.getCollection("model_info");
            modelInfo.insertOne(new Document("modelId",entityById.getModelId()).append("info",jsonInfo));
        }
        model.addAttribute("info",info);
        model.addAttribute("product",entityById);
        long end = System.currentTimeMillis();
        System.out.println("-------------------------"+(end-start));
    }

    /**
     *分页查询
     * @param pageNo
     * @param param
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public PageBean<ModelTbDTO> getPageBean(String pageNo,String param,Model model) throws IllegalArgumentException{
        PageBean<ModelTbDTO> pageBean=null;
        if (!"all".equals(param)&&!CommonUtils.isConvertedToNumber(param)){
            throw new IllegalArgumentException(NoticeMessage.ILLEGAL_ARGUMENT);
        }
        if("all".equals(param)){
            pageBean = getPageBean("from", ModelTbDTO.class, pageNo, ProductConfig.PAGE_SIZE);
        }else{
            pageBean = getPageBean("from", ModelTbDTO.class, pageNo, ProductConfig.PAGE_SIZE, new Node<String, Object>("brandTbDTO.brandId", Integer.parseInt(param)));
        }
        List<BrandTbDTO> brands = baseDAO.query("from", BrandTbDTO.class, 0, 0).list();
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("brands",brands);
        return pageBean;
    }
    /**
     * 计算手机回收价格
     * @param configIds
     * @param modelTbDTO
     * @return
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    @Override
    @Transactional
    public ModelTbDTO getPrice(String configIds,ModelTbDTO modelTbDTO) throws IllegalArgumentException,NullPointerException{
        long start = System.currentTimeMillis();
        if(configIds==null||configIds.length()==0) {
            throw new NullPointerException(NoticeMessage.NULL_PARAMS);
        }
        String[] split = configIds.split(",");
        int[] ints = new int[split.length];
        /*把传入参数转换成int集合，如果有非法参数就抛异常*/
        for(int i=0;i<split.length;i++){
            if(!CommonUtils.isConvertedToNumber(split[i])){
                throw new IllegalArgumentException(NoticeMessage.ILLEGAL_ARGUMENT);
            }
            ints[i]=Integer.parseInt(split[i]);
        }
        /*计算价格*/
        ModelTbDTO entityById = getEntityById(modelTbDTO);
        Iterator<ModelConfigTbDTO> iterator = entityById.getModelConfigTbDTOSet().iterator();
        int reducePrice=0;
        while(iterator.hasNext()){
            ModelConfigTbDTO modelConfig = iterator.next();
            for(int mcId:ints){
                if(mcId==modelConfig.getMcId()){
                    reducePrice+=modelConfig.getMcPrice();
                }
            }
        }
        logger.info("根据条件折扣价格："+reducePrice+"ms");
        modelTbDTO.setModelPrice(entityById.getModelPrice()-reducePrice>5000?entityById.getModelPrice()-reducePrice:5000);
        modelTbDTO.setModelImg(entityById.getModelImg());
        modelTbDTO.setModelName(entityById.getModelName());
        long end = System.currentTimeMillis();
        logger.info("价格计算耗时："+(end-start)+"ms");
        return modelTbDTO;
    }

    /**
     *工具类
     * @param step
     * @param md
     * @param typeName
     */
    private void addToSet(Map<String,Set<ModelConfigTbDTO>> step,ModelConfigTbDTO md,String typeName){
        Set<ModelConfigTbDTO> modelConfigSet = step.get(typeName);
        if (modelConfigSet==null){
            step.put(typeName,new TreeSet<>());
        }
        Set<ModelConfigTbDTO> modelConfigTbDTOS = step.get(typeName);
        modelConfigTbDTOS.add(md);
    }
}