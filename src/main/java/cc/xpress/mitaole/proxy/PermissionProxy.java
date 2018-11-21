package cc.xpress.mitaole.proxy;

import cc.xpress.mitaole.annotation.Permission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-08 8:09
 * @modified By:
 */
@Aspect
@Component
public class PermissionProxy {
    @Before(value="@annotation(permission)")
    public void  permissionValidation(JoinPoint joinPoint,Permission permission){
        System.out.println(permission.role());
        System.out.println("权限验证切面");
    }
}
