package cc.xpress.mitaole.user.service.impl;

import cc.xpress.mitaole.annotation.EntityId;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dao.IBaseDAO;
import cc.xpress.mitaole.user.service.IBaseService;
import cc.xpress.mitaole.utils.CommonUtils;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 16:39
 * @modified By:
 */
@Service("baseServiceImpl")
public class BaseServiceImpl <T> implements IBaseService<T>{
    @Autowired
    @Qualifier("baseDAOImpl")
    IBaseDAO baseDAO;

    /**
     * 根据实体id查询实体
     */
    @Override
    public  T getEntityById(T entity) throws NullPointerException{
        if (entity==null){
            throw new NullPointerException(NoticeMessage.NULL_PARAMS);
        }
        Object entityValue = CommonUtils.getEntityValue(entity, EntityId.class);
        if (entityValue==null){
            throw new NullPointerException(NoticeMessage.NULL_PARAMS);
        }
        Class clazz=entity.getClass();
        if(entityValue instanceof Long){
            return (T) baseDAO.getEntityById(clazz,((Long) entityValue).intValue());
        }else{
            return (T)baseDAO.getEntityById(clazz,(int)entityValue);
        }
    }

    /**
     * 分页查询
     * @param baseHql
     * @param clazz
     * @param pageNo
     * @param pageSize
     * @param params
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public PageBean<T> getPageBean(String baseHql,Class<T> clazz, String pageNo, int pageSize,
                                   Node<String,Object>...params)throws IllegalArgumentException{
        /*判断是否能转换成数字*/
        if(!CommonUtils.isConvertedToNumber(pageNo)){
            throw new IllegalArgumentException(NoticeMessage.ILLEGAL_ARGUMENT);
        }
        int pageNum = Integer.parseInt(pageNo);
        /*判断pageNum页码是否合法*/
        if(pageNum<1){
            throw new IllegalArgumentException(NoticeMessage.ILLEGAL_ARGUMENT);
        }
        Long aLong = (Long) baseDAO.query("select count(*) from", clazz, 0, 0, params).uniqueResult();
        int entityCount=aLong.intValue();
        /*判断pageNum是否超界*/
        if((pageNum-1)*pageSize>entityCount){
            throw new IllegalArgumentException(NoticeMessage.ILLEGAL_ARGUMENT);
        }
        List<T> list = baseDAO.query(baseHql, clazz, pageNum, pageSize, params).list();
        int pageCount=entityCount%pageSize==0?entityCount/pageSize:entityCount/pageSize+1;
        return new PageBean<T>(pageNum,pageCount,entityCount,list);
    }

    /**
     * 条件查询
     * @param baseHql
     * @param clazz
     * @param pageNo
     * @param pageSize
     * @param params
     * @return
     */
    @Transactional
    @Override
    public Query query(String baseHql, Class<T> clazz, int pageNo, int pageSize, Node<String,Object>... params){
        return baseDAO.query(baseHql,clazz,pageNo,pageSize,params);
    }
}
