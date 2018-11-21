package utils;

import cc.xpress.mitaole.annotation.EntityId;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.utils.CommonUtils;
import org.junit.Test;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 21:01
 * @modified By:
 */
public class CommonUtilsTest {
    /**
     * 判断是否能装换成数字
     */
    @Test
    public void isConvertedToNumberTest(){
        System.out.println(CommonUtils.isConvertedToNumber("1542 "));
    }

    /**
     * 获取注解变量的值
     */
    @Test
    public void  getEntityIdTest(){
        ModelTbDTO modelTbDTO = new ModelTbDTO();
        modelTbDTO.setModelId(111);
        Object entityValue = CommonUtils.getEntityValue(modelTbDTO, EntityId.class);
        System.out.println(entityValue instanceof Integer);
        System.out.println();
    }
}
