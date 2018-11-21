package cc.xpress.mitaole.user.dao.impl;
import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.dao.IBaseDAO;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 15:06
 * @modified By:
 */
@Repository("baseDAOImpl")
public class BaseDAOImpl<T> implements IBaseDAO<T>{
    private  final  Logger LOGGER = Logger.getLogger(this.getClass());
    @Autowired
    SessionFactory sessionFactory;
    /**
     * 保存实体
     * @param entity
     * @return
     */
    @Override
    public Serializable saveEntity(T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    /**
     * 删除实体
     * @param entity
     */
    @Override
    public void deleteEntity(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    /**
     * 根据id查询实体
     * @param clazz
     * @param id
     * @return
     */
    @Override
    public T getEntityById(Class<T> clazz, int id) {
        return sessionFactory.getCurrentSession().get(clazz,id);
    }

    /**
     * hql多条件查询
     * @param baseHql
     * @param clazz
     * @param pageNo
     * @param pageSize
     * @param params
     * @return
     */
    @Override
    public Query query(String baseHql, Class<T> clazz, int pageNo, int pageSize, Node<String,Object>... params) {
        baseHql+=" "+clazz.getName();
        if(params.length!=0){
            for(int i=0;i<params.length;i++){
                if (i==0){
                    baseHql+=" where "+params[i].getKey()+"=?";
                }else{
                    baseHql+=" and "+params[i].getKey()+"=?";
                }
            }
        }
        LOGGER.info(baseHql);
        Query query = sessionFactory.getCurrentSession().createQuery(baseHql);
        for(int i=0;i<params.length;i++){
            query.setParameter(i,params[i].getValue());
        }
        if(pageNo!=0||pageSize!=0){
            query.setFirstResult(pageSize*(pageNo-1));
            query.setMaxResults(pageSize);
        }
        return query;
    }

    /**
     * hql多条件查询
     * @param baseHql
     * @param clazz
     * @param params
     * @return
     */
    public Query query(String baseHql, Class<T> clazz,Node...params){
        baseHql+=" "+clazz.getName();
        /*参数*/
        if(params.length!=0){
            for(int i=0;i<params.length;i++){
                if (i==0){
                    baseHql+=" "+"where"+" "+params[i].getKey()+"=?";
                }else{
                    baseHql+=" "+"and"+" "+params[i].getKey()+"=?";
                }
            }
        }
        LOGGER.info(baseHql);
        Query query = sessionFactory.getCurrentSession().createQuery(baseHql);
        for(int i=0;i<params.length;i++){
            query.setParameter(i,params[i].getValue());
        }
        return query;
    }

    /**
     * hql分页查询
     * @param query
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<T> pagedQuery(Query query,int pageNo, int pageSize){
        if(pageNo!=0||pageSize!=0){
            query.setFirstResult(pageSize*(pageNo-1));
            query.setMaxResults(pageSize);
        }
        return query.list();
    }
}
