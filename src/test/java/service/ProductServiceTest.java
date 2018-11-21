package service;

import cc.xpress.mitaole.user.dto.ConfigTbDTO;
import cc.xpress.mitaole.user.dto.ModelConfigTbDTO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.user.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.lang.Iterable;
import java.util.*;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-06 10:57
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class ProductServiceTest {
    @Autowired
    IProductService productService;
    @Test
    public void BeanFormatTest(){
        ModelTbDTO modelTbDTO = new ModelTbDTO();
        modelTbDTO.setModelId(1);
        ModelTbDTO entityById = productService.getEntityById(modelTbDTO);
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
        Iterator<String> iterator1 = step3.keySet().iterator();
        while(iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(next);
            Set<ModelConfigTbDTO> configTbDTO = step3.get(next);
            Iterator<ModelConfigTbDTO> iterator = configTbDTO.iterator();
            while(iterator.hasNext()){
                ModelConfigTbDTO next1 = iterator.next();
                System.out.println(next1.getConfigTbDTO().getConfigName());
            }
        }
    }
    public void addToSet(Map<String,Set<ModelConfigTbDTO>> step,ModelConfigTbDTO md,String typeName){
        Set<ModelConfigTbDTO> modelConfigSet = step.get(typeName);
        if (modelConfigSet==null){
            step.put(typeName,new TreeSet<>());
        }
        Set<ModelConfigTbDTO> modelConfigTbDTOS = step.get(typeName);
        modelConfigTbDTOS.add(md);
    }
}
/*        for (ModelConfigTbDTO md:modelConfigTbDTOSet){
            int typeId = md.getConfigTbDTO().getTypeTbDTO().getTypeId();
            Iterator<Integer> iterator=null;
            switch (md.getConfigTbDTO().getTypeTbDTO().getTypeStep()){
                case 1:
                    iterator = step1.keySet().iterator();
                    break;
                case 2:
                    iterator = step2.keySet().iterator();
                    break;
                case 3:
                    iterator = step3.keySet().iterator();
                    break;
            }
            while(iterator.hasNext()){
                Integer next = iterator.next();
                if(next==typeId){
                    Set<ModelConfigTbDTO> configTbDTO = step1.get(typeId);
                    configTbDTO.add(md);
                }
            }
        }*/
