package cc.xpress.mitaole.user.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class BrandTbDTO  implements Serializable{
    private int brandId;
    private String brandName;
    private String brandImg;
    @JSONField(serialize = false)
    private Set<ModelTbDTO> modelTbDTOSet;

    public BrandTbDTO() {
    }

    public Set<ModelTbDTO> getModelTbDTOSet() {
        return modelTbDTOSet;
    }

    public void setModelTbDTOSet(Set<ModelTbDTO> modelTbDTOSet) {
        this.modelTbDTOSet = modelTbDTOSet;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandTbDTO that = (BrandTbDTO) o;

        if (brandId != that.brandId) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (brandImg != null ? !brandImg.equals(that.brandImg) : that.brandImg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brandId;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (brandImg != null ? brandImg.hashCode() : 0);
        return result;
    }
}
