package cc.xpress.mitaole.user.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class ModelConfigTbDTO  implements Serializable,Comparable{
    private int mcId;
    private String mcDescribe;
    private Integer mcPrice;
    private ConfigTbDTO configTbDTO;

    public String getMcDescribe() {
        return mcDescribe;
    }

    public void setMcDescribe(String mcDescribe) {
        this.mcDescribe = mcDescribe;
    }

    public Integer getMcPrice() {
        return mcPrice;
    }

    public void setMcPrice(Integer mcPrice) {
        this.mcPrice = mcPrice;
    }

    public ModelConfigTbDTO() {
    }

    public ConfigTbDTO getConfigTbDTO() {
        return configTbDTO;
    }

    public void setConfigTbDTO(ConfigTbDTO configTbDTO) {
        this.configTbDTO = configTbDTO;
    }

    public int getMcId() {
        return mcId;
    }

    public void setMcId(int mcId) {
        this.mcId = mcId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelConfigTbDTO)) return false;

        ModelConfigTbDTO that = (ModelConfigTbDTO) o;

        if (getMcId() != that.getMcId()) return false;
        if (!mcDescribe.equals(that.mcDescribe)) return false;
        return mcPrice.equals(that.mcPrice);
    }

    @Override
    public int hashCode() {
        int result = getMcId();
        result = 31 * result + (mcDescribe==null?0:mcDescribe.hashCode());
        result = 31 * result + mcPrice.hashCode();
        return result;
    }
    @Override
    public int compareTo(Object obj) {
        ModelConfigTbDTO config = (ModelConfigTbDTO) obj;
        return this.mcId-config.mcId;
    }
}
