package cc.xpress.mitaole.user.service;

import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dao.IBaseDAO;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 17:05
 * @modified By:
 */
public interface IProductService extends IBaseService<ModelTbDTO> {
    /**
     * @param pageNo
     * @param param
     * @return
     * @throws IllegalArgumentException
     */
    PageBean<ModelTbDTO> getPageBean(String pageNo,String param,Model model)throws IllegalArgumentException;

    /**
     * 根据id查询产品详细详细
     * @param modelTbDTO
     * @return
     */
    void  getProductInfoById(ModelTbDTO modelTbDTO,Model model) throws NullPointerException;

    /**
     * 计算手机回收价格
     * @param configIds
     * @param modelTbDTO
     * @return
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    ModelTbDTO getPrice(String configIds,ModelTbDTO modelTbDTO) throws IllegalArgumentException,NullPointerException;
}
