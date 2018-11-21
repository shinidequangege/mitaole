package cc.xpress.mitaole.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 17:02
 * @modified By:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityId {
}
