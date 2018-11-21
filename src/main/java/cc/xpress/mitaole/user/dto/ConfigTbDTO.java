package cc.xpress.mitaole.user.dto;

import java.io.Serializable;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class ConfigTbDTO  implements Serializable{

    private int configId;
    private String configName;
    private TypeTbDTO typeTbDTO;

    public ConfigTbDTO() {
    }

    public TypeTbDTO getTypeTbDTO() {
        return typeTbDTO;
    }

    public void setTypeTbDTO(TypeTbDTO typeTbDTO) {
        this.typeTbDTO = typeTbDTO;
    }

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigTbDTO that = (ConfigTbDTO) o;

        if (configId != that.configId) return false;
        if (configName != null ? !configName.equals(that.configName) : that.configName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = configId;
        result = 31 * result + (configName != null ? configName.hashCode() : 0);
        return result;
    }
}
