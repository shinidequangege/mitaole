package cc.xpress.mitaole.config;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-27 22:00
 * @modified By:
 */
public class Config {
    /**
     * 默认用户头像
     */
    public static final String DEFAULT_USER_ICON="user_default.png";
    /**
     * 邮箱正则表达式验证
     */
    public static final String LOGIN_MAIL_REGEX="^([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
    /**
     * 密码正则表达验证
     */
    public static final String LOGIN_PSD_REGEX="^[0-9a-zA-Z.]{6,16}$";
    /**
     *保存登陆userBean名称（key）
     */
    public static final String LOGIN_STATUS="userBean";
    /**
     * 错误属性的名称(key)
     */
    public static final String ERROR="error";
    /**
     * 消息属性的名称(key)
     */
    public static final String MESSAGE="message";
    /**
     * email Code length
     */
    public static final int CODE_LENGTH=6;
    /**
     * 验证码属性名称（key）
     */
    public static final String CODE="code";
    /**
     * 定义错误页面名称
     */
    public static final String ERROR_PAGE="error";
    /**
     * 页面显示数据条数
     */
    public static final int PAGE_SIZE=10;
    /**
     * 创建用户默认角色
     */
    public static final int DEFAULT_ROLE=3;
}
