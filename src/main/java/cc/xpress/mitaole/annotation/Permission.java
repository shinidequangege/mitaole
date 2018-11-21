package cc.xpress.mitaole.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-08 8:04
 * @modified By:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String role() default "";
    String pms() default "";
}
