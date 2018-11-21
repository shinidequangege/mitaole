package dao;

import cc.xpress.mitaole.user.bean.Node;
import cc.xpress.mitaole.user.dao.IBaseDAO;
import cc.xpress.mitaole.user.dto.BrandTbDTO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IProductService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.google.gson.Gson;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-08 15:42
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class BaseDAOTest {
    @Autowired
    @Qualifier("baseDAOImpl")
    IBaseDAO baseDAO;
    @Autowired
    IProductService productService;
    @Transactional
    @Test
    public void countQueryTest(){
        Gson gson = new Gson();
        List<Model> from = baseDAO.query("from", ModelTbDTO.class, 0, 0, new Node<String, Object>("brandTbDTO.brandId", 1)).list();
        System.out.println(JSON.toJSON(from));
    }
}
