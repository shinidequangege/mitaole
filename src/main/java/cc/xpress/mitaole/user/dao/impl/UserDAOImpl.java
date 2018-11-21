package cc.xpress.mitaole.user.dao.impl;

import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-25 21:33
 * @modified By:
 */
@Repository("userDAOImpl")
public class UserDAOImpl extends BaseDAOImpl<UserTbDTO> implements IUserDAO {
    @Autowired
    SessionFactory sessionFactory;
}
