package cc.xpress.mitaole.user.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-28 12:29
 * @modified By:
 */
public class UserTbDTO  implements Serializable{
    private long userId;
    private String userLoginAccount;
    private String userLoginPwd;
    private String userIcon;
    private String userLevel;
    private String userSalt;
    private Integer userCore;
    private Set<RoleTbDTO> roleTbDTOList;
    private AccountTbDTO accountTbDTO;
    public UserTbDTO() {
    }

    public Set<RoleTbDTO> getRoleTbDTOList() {
        return roleTbDTOList;
    }

    public void setRoleTbDTOList(Set<RoleTbDTO> roleTbDTOList) {
        this.roleTbDTOList = roleTbDTOList;
    }

    public AccountTbDTO getAccountTbDTO() {
        return accountTbDTO;
    }

    public void setAccountTbDTO(AccountTbDTO accountTbDTO) {
        this.accountTbDTO = accountTbDTO;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserLoginAccount() {
        return userLoginAccount;
    }

    public void setUserLoginAccount(String userLoginAccount) {
        this.userLoginAccount = userLoginAccount;
    }

    public String getUserLoginPwd() {
        return userLoginPwd;
    }

    public void setUserLoginPwd(String userLoginPwd) {
        this.userLoginPwd = userLoginPwd;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public Integer getUserCore() {
        return userCore;
    }

    public void setUserCore(Integer userCore) {
        this.userCore = userCore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTbDTO userTbDTO = (UserTbDTO) o;

        if (userId != userTbDTO.userId) return false;
        if (userLoginAccount != null ? !userLoginAccount.equals(userTbDTO.userLoginAccount) : userTbDTO.userLoginAccount != null)
            return false;
        if (userLoginPwd != null ? !userLoginPwd.equals(userTbDTO.userLoginPwd) : userTbDTO.userLoginPwd != null)
            return false;
        if (userIcon != null ? !userIcon.equals(userTbDTO.userIcon) : userTbDTO.userIcon != null) return false;
        if (userLevel != null ? !userLevel.equals(userTbDTO.userLevel) : userTbDTO.userLevel != null) return false;
        if (userSalt != null ? !userSalt.equals(userTbDTO.userSalt) : userTbDTO.userSalt != null) return false;
        if (userCore != null ? !userCore.equals(userTbDTO.userCore) : userTbDTO.userCore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (userLoginAccount != null ? userLoginAccount.hashCode() : 0);
        result = 31 * result + (userLoginPwd != null ? userLoginPwd.hashCode() : 0);
        result = 31 * result + (userIcon != null ? userIcon.hashCode() : 0);
        result = 31 * result + (userLevel != null ? userLevel.hashCode() : 0);
        result = 31 * result + (userSalt != null ? userSalt.hashCode() : 0);
        result = 31 * result + (userCore != null ? userCore.hashCode() : 0);
        return result;
    }
}
