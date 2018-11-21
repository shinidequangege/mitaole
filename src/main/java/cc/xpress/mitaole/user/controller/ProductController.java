package cc.xpress.mitaole.user.controller;

import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.user.bean.PageBean;
import cc.xpress.mitaole.user.dto.ModelTbDTO;
import cc.xpress.mitaole.user.service.IProductService;
import com.alibaba.fastjson.*;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 *
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-05 10:44
 * @modified By:
 */
@Controller
@RequestMapping("/goods")
public class ProductController {
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    @Autowired
    IProductService productService;
    @RequestMapping(path = "/{brandId}/{pageNo}.html")
    public String getProductListByPageNo(@PathVariable String brandId,@PathVariable String pageNo, Model model){

        PageBean<ModelTbDTO> pageBean = null;
        try {
            productService.getPageBean(pageNo, brandId,model);
            return "product";
        } catch (IllegalArgumentException e) {
            return "redirect:/goods/all/1.html";
        }
    }
    @RequestMapping("/info/{modelId}.html")
    public String getProductById(ModelTbDTO modelTbDTO,Model model){
        try {
            productService.getProductInfoById(modelTbDTO,model);
        } catch (NullPointerException e) {
            model.addAttribute(Config.ERROR,e.getMessage());
            return "error";
        }
        return "info";
    }
    @RequestMapping(path="/price")
    public String getPrice(String configIds,ModelTbDTO modelTbDTO,Model model){
        try {
            ModelTbDTO product = productService.getPrice(configIds, modelTbDTO);
            logger.info(String.valueOf(product.getModelPrice()));
            model.addAttribute("product",product);
            return "price";
        } catch (IllegalArgumentException e) {
            productService.getProductInfoById(modelTbDTO,model);
            return "info";
        } catch (NullPointerException e) {
            productService.getProductInfoById(modelTbDTO,model);
            return "info";
        }
    }
    @RequestMapping(path = "ajax/{brandId}/{pageNo}",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getProductList(@PathVariable String brandId,@PathVariable String pageNo, Model model){
        PageBean<ModelTbDTO> pageBean = productService.getPageBean(pageNo, brandId, model);
        String jsonString = JSON.toJSONString(pageBean);
        return jsonString;
    }
}
