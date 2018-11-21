package cc.xpress.mitaole.user.dto;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-04 14:50
 * @modified By:
 */
public class TypeTbDTO {
    private int typeId;
    private String typeName;
    private int typeStep;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeStep() {
        return typeStep;
    }

    public void setTypeStep(int typeStep) {
        this.typeStep = typeStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeTbDTO typeTbDTO = (TypeTbDTO) o;

        if (typeId != typeTbDTO.typeId) return false;
        if (typeStep != typeTbDTO.typeStep) return false;
        if (typeName != null ? !typeName.equals(typeTbDTO.typeName) : typeTbDTO.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeId;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + typeStep;
        return result;
    }
}
