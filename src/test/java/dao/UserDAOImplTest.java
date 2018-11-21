package dao;

import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.AccountTbDTO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-26 9:12
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class UserDAOImplTest{
    @Autowired
    IUserDAO userDAO;
    @Test
    @Transactional
    public void getUserByIdTest(){
        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserId(1);
        UserTbDTO userById = (UserTbDTO)userDAO.getEntityById(UserTbDTO.class,1);
        System.out.println(userById);
    }
    @Test
    @Transactional
    public void getUserByLoginAccountTest(){
/*        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserLoginAccount("hufan000@qq.com");
        UserTbDTO userByLoginAccount = userDAO.getUserByLoginAccount(userTbDTO);
        System.out.println(userByLoginAccount.getUserIcon()+userByLoginAccount.getAccountTbDTO().getAccountFreeze());*/
    }
    @Test
    @Transactional
    public void getUserByAccountAndPsdTest(){
/*        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserLoginAccount("hufan000@qq.com");
        userTbDTO.setUserLoginPwd("d849ca835e1f315813da52ca07139bd1");
        UserTbDTO userByLoginAccount = userDAO.getUserByAccountAndPsd(userTbDTO);
        System.out.println(userByLoginAccount.getUserIcon()+userByLoginAccount.getAccountTbDTO().getAccountFreeze());*/
    }
    @Test
    @Transactional
    public void savaUserTbDTOTest(){
        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserLoginPwd("11111111111111111111111111111111");
        userTbDTO.setUserLoginAccount("1115440210@qq.com");
        userTbDTO.setUserIcon(Config.DEFAULT_USER_ICON);
        userTbDTO.setUserSalt("111");
        userTbDTO.setAccountTbDTO(new AccountTbDTO());
        userDAO.saveEntity(userTbDTO);
    }
    @Test
    @Transactional
    public void getUserListByPageNoTest(){
/*        List<UserTbDTO> userList = userDAO.pagedQuery(UserTbDTO.class,2,Config.PAGE_SIZE);
        for(UserTbDTO userTbDTO:userList){
            System.out.println(userTbDTO.getUserLoginAccount()+"---"+userTbDTO.getAccountTbDTO().getAccountId());
        }*/
    }
    @Test
    @Transactional
    public void getAllUserCountTest(){
/*        long allUserCount = userDAO.countQuery(UserTbDTO.class);
        System.out.println(allUserCount);*/
    }
}
