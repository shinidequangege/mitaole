package cc.xpress.mitaole.user.service;

import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.bean.PageBean;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 16:35
 * @modified By:
 */
public interface IBaseService<T> {
    /**
     * 根据实体id查询实体
     * @param entity
     * @return
     */
    T getEntityById(T entity);
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
    Query query(String baseHql, Class<T> clazz, int pageNo, int pageSize, Node<String,Object>... params);

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
    PageBean<T> getPageBean(String baseHql,Class<T> clazz, String pageNo, int pageSize,
                                   Node<String,Object>...params)throws IllegalArgumentException;
}
