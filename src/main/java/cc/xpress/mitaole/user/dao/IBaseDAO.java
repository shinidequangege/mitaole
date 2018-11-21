package cc.xpress.mitaole.user.dao;
import cc.xpress.mitaole.user.bean.Node;
import org.hibernate.query.Query;
import java.io.Serializable;
/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 15:14
 * @modified By:
 */
public interface IBaseDAO<T> {
    /**
     *保存实体对象
     * @param entity
     * @return
     */
    Serializable saveEntity(T entity);
    /**
     * 删除实体
     * @param entity
     */
    void deleteEntity(T entity);
    /**
     * 根据id查询实体对象
     * @param id
     * @param clazz
     * @return
     */
    T getEntityById(Class<T> clazz,int id);

    /**
     * 多条件查询
     * @param baseHql
     * @param clazz
     * @param pageNo
     * @param pageSize
     * @param params
     * @return
     */
    Query query(String baseHql, Class<T> clazz, int pageNo, int pageSize,Node<String,Object>...params);
}
