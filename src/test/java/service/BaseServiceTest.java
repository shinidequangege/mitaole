package service;

import cc.xpress.mitaole.user.dao.IBaseDAO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.user.service.IBaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 17:53
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class BaseServiceTest {
    @Autowired
    IBaseService baseService;
    @Test
    public void getEntityByIdTest(){
        ModelTbDTO modelTbDTO = new ModelTbDTO();
        modelTbDTO.setModelId(1);
        ModelTbDTO entityById = (ModelTbDTO)baseService.getEntityById( modelTbDTO);
        System.out.println(entityById.getModelName());
    }
}
