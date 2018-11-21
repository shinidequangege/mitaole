package cc.xpress.mitaole.user.dao.impl;

import cc.xpress.mitaole.user.dao.IProductDAO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 16:05
 * @modified By:
 */
@Repository("productDAOImpl")
public class ProductDAOImpl extends BaseDAOImpl<ModelTbDTO> implements IProductDAO {
    @Autowired
    SessionFactory sessionFactory;
}
