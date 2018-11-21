package cc.xpress.mitaole.user.interceptor;
import cc.xpress.mitaole.config.Config;
import cc.xpress.mitaole.config.NoticeMessage;
import cc.xpress.mitaole.utils.ResponseUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-10-27 20:59
 * @modified By:
 */
public class RegexInterceptor implements HandlerInterceptor{
    /**
     * 如果参数有邮箱和密码，则对邮箱和密码进行正则表达式验证
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String userLoginAccount = httpServletRequest.getParameter("userLoginAccount");
        String userLoginPwd=httpServletRequest.getParameter("userLoginPwd");
        if(userLoginAccount!=null){
            boolean matches = Pattern.matches(Config.LOGIN_MAIL_REGEX, userLoginAccount);
            if(!matches){
                ResponseUtils.interceptedResponse(NoticeMessage.ACCOUNT_FORMAT_ERROR,httpServletResponse);
                return  false;
            }
        }
        if(userLoginPwd!=null){
            boolean matches = Pattern.matches(cc.xpress.mitaole.config.Config.LOGIN_PSD_REGEX, userLoginPwd);
            if(!matches){
                ResponseUtils.interceptedResponse(NoticeMessage.PSD_FORMAT_ERROR,httpServletResponse);
                return  false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
