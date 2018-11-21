package utils;

import cc.xpress.mitaole.utils.EncryptUtils;
import org.junit.Test;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-28 9:54
 * @modified By:
 */
public class EncryptUtilsTest {
    @Test
    public void md5Test(){
        System.out.println(EncryptUtils.getPassword("1115440210@qq.com","123456"));
        System.out.println(EncryptUtils.encryptPassword("1115440210@qq.com","dFzbpIAaiQoLfjokRk32"));
    }
}
