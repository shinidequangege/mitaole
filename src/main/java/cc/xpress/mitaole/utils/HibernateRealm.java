package cc.xpress.mitaole.utils;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.PermissionTbDTO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-31 19:33
 * @modified By:
 */
public class HibernateRealm extends AuthorizingRealm{
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IUserService userService;
    @Autowired
    private MongoTemplate mongoTemplate;
    private static Gson gson = new Gson();
    /**
     * 给当前realm指定一个名字，必须唯一
     * @return
     */
    @Override
    public String getName(){
        return "hibernate_realm";
    }
    /**
     * 权限验证方法
     * （自动执行）
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        List<String> roleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        Set<RoleTbDTO> userRoles=principals.asSet();
        MongoCollection<Document> mitaole = mongoTemplate.getCollection("mitaole");
        String jRoles = (String)mitaole.find(Filters.eq("role_id", 1)).iterator().tryNext().get("role");
        Type type = new TypeToken<List<RoleTbDTO>>() {
        }.getType();
        List<RoleTbDTO> roles= gson.fromJson(jRoles,type);
        Iterator<RoleTbDTO> ite1 = userRoles.iterator();
        while (ite1.hasNext()){
            RoleTbDTO userRole = ite1.next();
            for(RoleTbDTO role:roles){
                if(role.getRoleName().equals(userRole.getRoleName())){
                    roleList.add(userRole.getRoleName());
                    Iterator<PermissionTbDTO> iterator2 = userRole.getPermissionTbDTOSet().iterator();
                    while(iterator2.hasNext()){
                        PermissionTbDTO userPermission = iterator2.next();
                        permissionList.add(userPermission.getPmsValue());
                    }
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    /**
     * 登陆认证的方法
     * （自动执行）
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        char[] credentials = (char[]) token.getCredentials();
        /*用户输入的账户和密码*/
        String password = new String(credentials);
        String username = token.getPrincipal().toString();
        UserTbDTO user = new UserTbDTO();
        user.setUserLoginAccount(username);
        user.setUserLoginPwd(password);
        /*根据用户输入的账户名称查询用户*/
        UserTbDTO userTbDTO = userService.getUserByAccount(user);
        if (userTbDTO==null){
            throw new NullPointerException(NoticeMessage.ACCOUNT_NOT_EXISTS);
        }
        String encryptPassword=EncryptUtils.encryptPassword(password,userTbDTO.getUserSalt());
        if (userTbDTO.getUserLoginPwd().equals(encryptPassword)){
/*            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute(Config.LOGIN_STATUS,"userTbDTO");*/
            return new SimpleAuthenticationInfo(userTbDTO.getRoleTbDTOList(),password,getName());
        }else {
            throw new AuthenticationException("用户名和密码验证失败");
        }
    }
}
