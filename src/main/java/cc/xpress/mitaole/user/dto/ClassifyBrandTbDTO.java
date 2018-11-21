package cc.xpress.mitaole.user.dto;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class ClassifyBrandTbDTO {
    private int cbId;

    public int getCbId() {
        return cbId;
    }

    public void setCbId(int cbId) {
        this.cbId = cbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassifyBrandTbDTO that = (ClassifyBrandTbDTO) o;

        if (cbId != that.cbId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cbId;
    }
}
