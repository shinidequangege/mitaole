package cc.xpress.mitaole.user.service.impl;
import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.AccountTbDTO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IUserService;
import cc.xpress.mitaole.utils.EmailSend;
import cc.xpress.mitaole.utils.EncryptUtils;
import cc.xpress.mitaole.utils.CommonUtils;
import com.google.gson.Gson;
import com.mchange.util.DuplicateElementException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-26 23:54
 * @modified By:
 */
@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<UserTbDTO> implements IUserService {
    @Autowired
    private IUserDAO userDAO;
    Gson gson = new Gson();
    /**
     *创建用户
     * @param userTbDTO
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    @Override
    @Transactional
    public UserTbDTO userRegister(UserTbDTO userTbDTO, HttpSession session, String registerCode) throws NullPointerException,IllegalArgumentException,DuplicateElementException{
        String code = (String)session.getAttribute(Config.CODE);
        if(userTbDTO.getUserLoginAccount()==null||userTbDTO.getUserLoginPwd()==null||registerCode==null||code==null){
            throw new NullPointerException(NoticeMessage.NULL_PARAMS);
        }
        if (!code.equals(registerCode)){
            throw new IllegalArgumentException(NoticeMessage.WRONG_REGISTER_CODE);
        }
        if(loginAccountRepeatCheck(gson.toJson(userTbDTO,UserTbDTO.class))!=1){
            throw new DuplicateElementException(NoticeMessage.ACCOUNT_EXISTS);
        }
        String salt = CommonUtils.getCode(20);
        String password = EncryptUtils.encryptPassword(userTbDTO.getUserLoginPwd(),salt);
        userTbDTO.setUserSalt(salt);
        userTbDTO.setUserLoginPwd(password);
        userTbDTO.setUserIcon(Config.DEFAULT_USER_ICON);
        userTbDTO.setAccountTbDTO(new AccountTbDTO());
        RoleTbDTO entityById = (RoleTbDTO)baseDAO.getEntityById(RoleTbDTO.class, Config.DEFAULT_ROLE);
        /*userTbDTO.getRoleTbDTOList().add(entityById);*/
        //TODO   给账户添加默认角色
        Serializable serializable = userDAO.saveEntity(userTbDTO);
        userTbDTO.setUserId((Long)serializable);
        return userTbDTO;
    }
    /**
     * 发送邮件
     * @param userTbDTO
     * @param session
     * @throws MessagingException
     */
    @Override
    public boolean emailSend(UserTbDTO userTbDTO,HttpSession session) throws MessagingException {
        if(userTbDTO==null||userTbDTO.getUserLoginAccount()==null||"".equals(userTbDTO.getUserLoginAccount())){
            return false;
        }
        String code = EmailSend.emailSend(userTbDTO.getUserLoginAccount());
        session.setAttribute(Config.CODE,code);
        return true;
    }
    /**
     * 检查登陆账户是否重复
     * @param ajaxValue
     * @return
     */
    @Override
    @Transactional
    public int loginAccountRepeatCheck(String ajaxValue){
        if(ajaxValue==null||"".equals(ajaxValue)){
            return -1;
        }
        UserTbDTO userTbDTO = gson.fromJson(ajaxValue, UserTbDTO.class);
        if(userTbDTO==null||userTbDTO.getUserLoginAccount()==null||"".equals(userTbDTO.getUserLoginAccount())){
            return -1;
        }
        UserTbDTO userByLoginAccount = getUserByAccount(userTbDTO);
        if (userByLoginAccount!=null){
            return 0;
        }
        return 1;
    }
    /**
     * 根据账户查询用户信息
     * @param userTbDTO
     * @return
     */
    @Transactional
    @Override
    public UserTbDTO getUserByAccount(UserTbDTO userTbDTO){
        Query query = userDAO.query("from",UserTbDTO.class,0, 0,new Node<String,Object>("userLoginAccount",userTbDTO.getUserLoginAccount()));
        return (UserTbDTO)query.uniqueResult();
    }
}