package cc.xpress.mitaole.user.service;

import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import com.mchange.util.DuplicateElementException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-26 23:52
 * @modified By:
 */
public interface IUserService extends IBaseService<UserTbDTO> {
    /**
     * 注册用户
     * @param userTbDTO
     * @param session
     * @param registerCode
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    UserTbDTO userRegister(UserTbDTO userTbDTO,HttpSession session,String registerCode) throws NullPointerException,IllegalArgumentException;
    /**
     * 发送邮件
     * @param userTbDTO
     * @param session
     * @throws MessagingException
     */
    boolean emailSend(UserTbDTO userTbDTO,HttpSession session) throws MessagingException;
    /**
     * 检查登陆账户是否重复
     * @param ajaxValue
     * @return
     */
    int loginAccountRepeatCheck(String ajaxValue);
    /**
     * 根据id查询账户信息
     * @param userTbDTO
     * @return
     */
    UserTbDTO getUserByAccount(UserTbDTO userTbDTO);
}
