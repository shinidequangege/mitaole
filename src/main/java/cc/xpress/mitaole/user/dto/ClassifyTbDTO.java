package cc.xpress.mitaole.user.dto;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class ClassifyTbDTO {
    private int classifyId;
    private String classifyName;

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassifyTbDTO that = (ClassifyTbDTO) o;

        if (classifyId != that.classifyId) return false;
        if (classifyName != null ? !classifyName.equals(that.classifyName) : that.classifyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classifyId;
        result = 31 * result + (classifyName != null ? classifyName.hashCode() : 0);
        return result;
    }
}
