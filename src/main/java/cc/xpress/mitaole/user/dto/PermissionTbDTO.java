package cc.xpress.mitaole.user.dto;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-30 0:52
 * @modified By:
 */
public class PermissionTbDTO {
    private int pmsId;
    private String pmsValue;
    private String pmsName;

    public int getPmsId() {
        return pmsId;
    }

    public void setPmsId(int pmsId) {
        this.pmsId = pmsId;
    }

    public String getPmsValue() {
        return pmsValue;
    }

    public void setPmsValue(String pmsValue) {
        this.pmsValue = pmsValue;
    }

    public String getPmsName() {
        return pmsName;
    }

    public void setPmsName(String pmsName) {
        this.pmsName = pmsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionTbDTO that = (PermissionTbDTO) o;

        if (pmsId != that.pmsId) return false;
        if (pmsValue != null ? !pmsValue.equals(that.pmsValue) : that.pmsValue != null) return false;
        if (pmsName != null ? !pmsName.equals(that.pmsName) : that.pmsName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pmsId;
        result = 31 * result + (pmsValue != null ? pmsValue.hashCode() : 0);
        result = 31 * result + (pmsName != null ? pmsName.hashCode() : 0);
        return result;
    }
}
