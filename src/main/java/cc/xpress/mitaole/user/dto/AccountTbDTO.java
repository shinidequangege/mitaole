package cc.xpress.mitaole.user.dto;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-28 12:29
 * @modified By:
 */
public class AccountTbDTO {
    private long accountId;
    private int accountTotal;
    private int accountFreeze;
    private int accountBalance;
    private UserTbDTO userTbDTO;

    public UserTbDTO getUserTbDTO() {
        return userTbDTO;
    }

    public void setUserTbDTO(UserTbDTO userTbDTO) {
        this.userTbDTO = userTbDTO;
    }

    public AccountTbDTO() {
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(int accountTotal) {
        this.accountTotal = accountTotal;
    }

    public int getAccountFreeze() {
        return accountFreeze;
    }

    public void setAccountFreeze(int accountFreeze) {
        this.accountFreeze = accountFreeze;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTbDTO that = (AccountTbDTO) o;

        if (accountId != that.accountId) return false;
        if (accountTotal != that.accountTotal) return false;
        if (accountFreeze != that.accountFreeze) return false;
        if (accountBalance != that.accountBalance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + accountTotal;
        result = 31 * result + accountFreeze;
        result = 31 * result + accountBalance;
        return result;
    }
}
