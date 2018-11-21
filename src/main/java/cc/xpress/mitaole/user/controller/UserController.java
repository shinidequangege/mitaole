package cc.xpress.mitaole.user.controller;
import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IUserService;
import com.mchange.util.DuplicateElementException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-26 20:26
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private  Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private IUserService userService;
    /**
     * 用户注册
     * @param userTbDTO
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String userRegister(UserTbDTO userTbDTO,String registerCode,Model model, HttpSession session){
        try{
            UserTbDTO user = userService.userRegister(userTbDTO, session, registerCode);
            session.setAttribute(Config.LOGIN_STATUS,user);
            return "/user_center";
        }catch (NullPointerException e){
            model.addAttribute(Config.ERROR,e.getMessage());
            logger.error(e.getMessage());
        }catch (IllegalArgumentException e){
            model.addAttribute(Config.ERROR,e.getMessage());
            logger.error(e.getMessage());
        }catch (DuplicateElementException e){
            model.addAttribute(Config.ERROR,e.getMessage());
            logger.error(e.getMessage());
        }
        return  Config.ERROR_PAGE;
    }
    /**
     * 用户登陆
     * @param userTbDTO
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(UserTbDTO userTbDTO){
        try {
            /*判断userTbDTO是否为空*/
            if (userTbDTO==null||userTbDTO.getUserLoginAccount()==null||userTbDTO.getUserLoginPwd()==null){
                throw new NullPointerException(NoticeMessage.NULL_PARAMS);
            }
            /*生成认证Token*/
            UsernamePasswordToken token = new UsernamePasswordToken(userTbDTO.getUserLoginAccount(),userTbDTO.getUserLoginPwd());
            Subject subject = SecurityUtils.getSubject();
            /*登陆*/
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("userBean",userService.getUserByAccount(userTbDTO));
            return "user_center";
        } catch (NullPointerException e) {
            logger.error(e.getMessage());
        }catch (AuthenticationException e) {
            logger.error(e.getMessage());
        }
        return "login";
    }
    /**
     * 发送邮件
     * @param userTbDTO
     * @param session
     * @return
     */
    @RequestMapping(path="/code",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public String getCode(UserTbDTO userTbDTO,HttpSession session){
        try {
            if(!userService.emailSend(userTbDTO,session)){
                return "fail";
            }return "success";
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
        return "fail";
    }
    /**
     * 验证邮箱是否重复
     * @param ajaxValue
     * @return
     */
    @RequestMapping(path="/check",produces = MediaType.ALL_VALUE)
    @ResponseBody
    public String repeatCheck(String ajaxValue){
        return Integer.toString(userService.loginAccountRepeatCheck(ajaxValue));
    }
    /**
     * 查看用户列表
     * @param pageNo
     * @param model
     * @return
     */
    @RequiresRoles(value = {"super","admin"},logical = Logical.OR)
    @RequestMapping("user_list/{pageNo}.html")
    public String userList(@PathVariable String pageNo, Model model,HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        PageBean<UserTbDTO> pageBean = null;
        try {
            pageBean = userService.getPageBean("from", UserTbDTO.class, pageNo, Config.PAGE_SIZE);
            model.addAttribute("pageBean", pageBean);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            pageBean = userService.getPageBean("from", UserTbDTO.class, "1", Config.PAGE_SIZE);
            model.addAttribute("pageBean", pageBean);
        }
        return "user_list";
    }
}