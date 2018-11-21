package springconfigtest;

import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-02 14:22
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class MongoConnTest {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    IUserDAO userDAO;
    @Test
    public void connTest() {
/*        Gson gson = new Gson();
        MongoCollection<Document> roleList = mongoTemplate.getCollection("mitaole");
        Iterator<RoleTbDTO> iterator = userDAO.getRoleList().iterator();
        List<Document> documents = new ArrayList<>();
        while(iterator.hasNext()){
            RoleTbDTO role = iterator.next();
            String permissions = gson.toJson(role);
            Document append = new Document(Integer.toString(role.getRoleId()), permissions);
            documents.add(append);
        }
        roleList.insertMany(documents);
        MongoCursor<Document> iterator1 = roleList.find().iterator();
        while (iterator1.hasNext()){
            Document next = iterator1.next();
            System.out.println(next.toJson());
        }
        roleList.deleteOne(Filters.eq(1));
    }*/
    }
}
