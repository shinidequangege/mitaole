package cc.xpress.mitaole.user.listener;
import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.RoleTbDTO;
import cc.xpress.mitaole.user.dto.UserTbDTO;
import cc.xpress.mitaole.user.service.IUserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.ServletContextEvent;
import java.lang.reflect.Type;
import java.util.List;
/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-02 15:46
 * @modified By:
 */
public class MongoCacheLoadListener extends ContextLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        Gson gson = new Gson();
        WebApplicationContext webApplicationContext = this.initWebApplicationContext(event.getServletContext());
        MongoTemplate mongoTemplate = webApplicationContext.getBean(MongoTemplate.class);
        SessionFactory sessionFactory = (SessionFactory)webApplicationContext.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        List<RoleTbDTO>  roles= session.createQuery("from RoleTbDTO ").list();
        Type type = new TypeToken<List<RoleTbDTO>>() {
        }.getType();
        String jRoles = gson.toJson(roles,type);
        System.out.println(jRoles);
        MongoCollection<Document> roleList = mongoTemplate.getCollection("mitaole");
        roleList.deleteOne(Filters.eq("role_id",1));
        roleList.insertOne(new Document("role_id",1).append("role",jRoles));
        session.close();
    }
}