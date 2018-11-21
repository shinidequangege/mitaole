package utils;

import cc.xpress.mitaole.user.dao.IProductDAO;
import cc.xpress.mitaole.user.dao.IUserDAO;
import cc.xpress.mitaole.user.dto.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.security.auth.Subject;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-25 21:24
 * @modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-servlet.xml")
public class DataSourceConn {
    @Autowired
    IUserDAO userDAO;
    @Autowired
    IProductDAO productDAO;
    @Autowired
    SessionFactory sessionFactory;
    @Test
    @Transactional
    public void Conn(){
        UserTbDTO userTbDTO = new UserTbDTO();
        userTbDTO.setUserId(1);
        UserTbDTO entityById = (UserTbDTO)userDAO.getEntityById(UserTbDTO.class, 1);
        Set<RoleTbDTO> roleTbDTOList = entityById.getRoleTbDTOList();
        for (RoleTbDTO roleTbDTO:roleTbDTOList){
            for(PermissionTbDTO permissionTbDTO:roleTbDTO.getPermissionTbDTOSet()){
                System.out.print(roleTbDTO.getRoleName()+":");
                System.out.println(permissionTbDTO.getPmsId()+"---"+permissionTbDTO.getPmsValue()+"---"+permissionTbDTO.getPmsName());
            }
        }
    }
    @Test
    public void t1(){
        UsernamePasswordToken token = new UsernamePasswordToken("1115440210@qq.com", "8f9e4358cf0a9b8cf7deb330f4480eab");
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        boolean permitted = subject.isPermitted("select_user_list");
        System.out.println(permitted);
    }
    @Test
    public void ModelConnTest(){
        ModelTbDTO modelTbDTO = sessionFactory.openSession().get(ModelTbDTO.class, 1);
        System.out.println(modelTbDTO.getModelId()+"--->>>----"+modelTbDTO.getModelName());
        Iterator<ModelConfigTbDTO> iterator = modelTbDTO.getModelConfigTbDTOSet().iterator();
        while(iterator.hasNext()){
            ModelConfigTbDTO next = iterator.next();
            System.out.println(next.getMcPrice()+"--->>>----"
                    +next.getConfigTbDTO().getConfigName()+"--->>>----"
                    +next.getConfigTbDTO().getTypeTbDTO().getTypeName()
            );
        }
    }
    @Test
    public void BrandConnTest(){
        BrandTbDTO brandTbDTO = sessionFactory.openSession().get(BrandTbDTO.class, 1);
        Iterator<ModelTbDTO> iterator = brandTbDTO.getModelTbDTOSet().iterator();
        while(iterator.hasNext()){
            ModelTbDTO next = iterator.next();
            System.out.println(next.getModelName());
        }
    }
    @Test
    public void hqlAddTest(){
        Session session = sessionFactory.openSession();
        ArrayList<String> paramsName = new ArrayList<>();
        String hql="from ModelTbDTO";
        paramsName.add("modelId");
        paramsName.add("modelName");
        ArrayList params= new ArrayList<>();
        params.add(1);
        params.add("华为P");
        for(int i=0;i<paramsName.size();i++){
            if (i==0){
                hql+=" where "+paramsName.get(i)+"=:"+paramsName.get(i);
            }else{
                hql+=" and "+paramsName.get(i)+"=:"+paramsName.get(i);
            }
        }
        Query query = session.createQuery(hql);
        for(int i=0;i<paramsName.size();i++){
            query.setParameter(paramsName.get(i),params.get(i));
        }
        List<ModelTbDTO> list = query.list();
        for(ModelTbDTO mode:list){
            System.out.println(mode.getModelName());
        }
        System.out.println(hql);
    }
    @Test
    @Transactional
    public void SelectTest(){
        ArrayList<String> paramName = new ArrayList<>();
        ArrayList param = new ArrayList();
        paramName.add("modelId");
        param.add(1);
        String hql="from ModelTbDTO where brandTbDTO.brandId=1";
        Iterator iterator = sessionFactory.openSession().createQuery(hql).list().iterator();
        while(iterator.hasNext()){
            ModelTbDTO next = (ModelTbDTO)iterator.next();
            System.out.println(next.getModelName());
        }

/*        List<ModelTbDTO> modelTbDTOS = productDAO.listQuery(ModelTbDTO.class, 1, 20, paramName, param);
        Iterator<ModelTbDTO> iterator = modelTbDTOS.iterator();
        while (iterator.hasNext()){
            ModelTbDTO next = iterator.next();
            System.out.println(next.getModelName());
        }*/
    }
    @Test
    @Transactional
    public void getModelByBrandTest(){
/*        List<String> paramName = new ArrayList<>();
        paramName.add("brandTbDTO.brandId");
        List  param = new ArrayList<>();
        param.add(1);
        Iterator<ModelTbDTO> iterator = productDAO.listQuery(ModelTbDTO.class, 2, 6, paramName, param).iterator();
        while (iterator.hasNext()){
            ModelTbDTO next = iterator.next();
            System.out.println(next.getModelName());
        }*/
    }
}
