package cc.xpress.mitaole.utils;

import cc.xpress.mitaole.annotation.EntityId;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-27 20:17
 * @modified By:
 */
public class CommonUtils {
    public static final String CHAR_BUCKET="0123456789ABCDEFHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    /**
     * 创建长度为length的随机数字字母字符串
     * @param length
     * @return
     */
    public static String getCode(int length){
        char[] chars = CHAR_BUCKET.toCharArray();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<length;i++){
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }

    /**
     * 判断是否能转换成是数字
     * @param string
     * @return
     */
    public static  boolean isConvertedToNumber(String string){
        if(string==null||string.equals("")){
            return false;
        }
        char[] chars = string.toCharArray();
        for(char ch:chars){
            if ((int)ch<48||(int)ch>57){
                return false;
            }
        }
        return true;
    }

    /**
     * 获取注解属性的值
     * @param entity
     * @param clazz
     * @return
     */
    public static Object getEntityValue(Object entity,Class clazz){
        Field[] declaredFields = entity.getClass().getDeclaredFields();
        for(Field field:declaredFields){
            Annotation annotation = field.getAnnotation(clazz);
            if(annotation!=null){
                try {
                    field.setAccessible(true);
                    return field.get(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public static String charFilter(String string,char ch){
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(char chs:chars){
            if(chs!=ch){
                stringBuilder.append(chs);
            }
        }
        return stringBuilder.toString();
    }
}
