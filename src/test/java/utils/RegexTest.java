package utils;

import cc.xpress.mitaole.config.Config;
import org.junit.Test;
import java.util.regex.Pattern;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-27 13:00
 * @modified By:
 */
public class RegexTest {
    /**
     * 正则表达式验证
     */
    @Test
    public void regexTest(){
        System.out.println(Pattern.matches(Config.LOGIN_MAIL_REGEX,"1115440210@qq.com"));
        System.out.println(Pattern.matches(Config.LOGIN_PSD_REGEX,"1115"));
    }
    @Test
    public void t1(){

    }
}
