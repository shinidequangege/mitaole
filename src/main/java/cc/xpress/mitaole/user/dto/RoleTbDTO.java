package cc.xpress.mitaole.user.dto;

import java.io.Serializable;
import java.util.Set;
/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-30 0:52
 * @modified By:
 */
public class RoleTbDTO  implements Serializable{
    private int roleId;
    private String roleName;
    public RoleTbDTO(){};
    private Set<PermissionTbDTO>  permissionTbDTOSet;

    public Set<PermissionTbDTO> getPermissionTbDTOSet() {
        return permissionTbDTOSet;
    }

    public void setPermissionTbDTOSet(Set<PermissionTbDTO> permissionTbDTOSet) {
        this.permissionTbDTOSet = permissionTbDTOSet;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleTbDTO)) return false;

        RoleTbDTO roleTbDTO = (RoleTbDTO) o;

        if (getRoleId() != roleTbDTO.getRoleId()) return false;
        if (getRoleName() != null ? !getRoleName().equals(roleTbDTO.getRoleName()) : roleTbDTO.getRoleName() != null)
            return false;
        return getPermissionTbDTOSet() != null ? getPermissionTbDTOSet().equals(roleTbDTO.getPermissionTbDTOSet()) : roleTbDTO.getPermissionTbDTOSet() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoleId();
        result = 31 * result + (getRoleName() != null ? getRoleName().hashCode() : 0);
        result = 31 * result + (getPermissionTbDTOSet() != null ? getPermissionTbDTOSet().hashCode() : 0);
        return result;
    }
}
