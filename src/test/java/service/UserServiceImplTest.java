package service;

import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.user.dto.AccountTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IUserService;
import cc.xpress.mitaole.user.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-28 12:56
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class UserServiceImplTest {
    @Autowired
    IUserService userService;
    @Test
    public void registerTest(){
        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserLoginPwd("11111111111111111111111111111111");
        userTbDTO.setUserLoginAccount("hufan");
        userTbDTO.setUserIcon(Config.DEFAULT_USER_ICON);
        userTbDTO.setAccountTbDTO(new AccountTbDTO());
        userService.userRegister(userTbDTO,null,null);
    }
}
