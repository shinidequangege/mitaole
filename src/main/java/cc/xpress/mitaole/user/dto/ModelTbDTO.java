package cc.xpress.mitaole.user.dto;

import cc.xpress.mitaole.annotation.EntityId;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class ModelTbDTO  implements Serializable{
    @EntityId
    private int modelId;
    private String modelName;
    private String modelImg;
    private Integer modelPrice;
    @JSONField(serialize = false)
    private BrandTbDTO brandTbDTO;
    @JSONField(serialize = false)
    private Set<ModelConfigTbDTO> modelConfigTbDTOSet;
    public BrandTbDTO getBrandTbDTO() {
        return brandTbDTO;
    }

    public void setBrandTbDTO(BrandTbDTO brandTbDTO) {
        this.brandTbDTO = brandTbDTO;
    }

    public ModelTbDTO() {
    }

    public Set<ModelConfigTbDTO> getModelConfigTbDTOSet() {
        return modelConfigTbDTOSet;
    }

    public void setModelConfigTbDTOSet(Set<ModelConfigTbDTO> modelConfigTbDTOSet) {
        this.modelConfigTbDTOSet = modelConfigTbDTOSet;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelImg() {
        return modelImg;
    }

    public void setModelImg(String modelImg) {
        this.modelImg = modelImg;
    }

    public Integer getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(Integer modelPrice) {
        this.modelPrice = modelPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelTbDTO that = (ModelTbDTO) o;

        if (modelId != that.modelId) return false;
        if (modelName != null ? !modelName.equals(that.modelName) : that.modelName != null) return false;
        if (modelImg != null ? !modelImg.equals(that.modelImg) : that.modelImg != null) return false;
        if (modelPrice != null ? !modelPrice.equals(that.modelPrice) : that.modelPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = modelId;
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (modelImg != null ? modelImg.hashCode() : 0);
        result = 31 * result + (modelPrice != null ? modelPrice.hashCode() : 0);
        return result;
    }
}
