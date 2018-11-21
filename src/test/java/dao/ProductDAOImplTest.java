package dao;

import cc.xpress.mitaole.config.ProductConfig;
import cc.xpress.mitaole.user.dao.IProductDAO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 16:47
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class ProductDAOImplTest {
    @Autowired
    IProductDAO productDAO;
    @Test
    public void getProductListByPageNoTest(){
/*        Iterator<ModelTbDTO> iterator = productDAO.pagedQuery(1, ProductConfig.PAGE_SIZE).iterator();
        while(iterator.hasNext()){
            ModelTbDTO next = iterator.next();
            System.out.println(next.getModelId()+next.getModelName()+next.getModelPrice());
        }*/
    }
}
