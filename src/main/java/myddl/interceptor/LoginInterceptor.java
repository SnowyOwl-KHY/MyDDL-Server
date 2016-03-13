package myddl.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 * Created by SB on 15/7/28.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String authorizationBase64 = request.getHeader("Authorization");
//        if(StringUtils.isBlank(authorizationBase64)) {
//            response.setStatus(401);
//            response.setHeader("WWW-authenticate","Basic realm=\"对不起你没有权限!!\"");
//            logger.error("authorization=null");
//            return false;
//        }
//        String authorization = new String(new BASE64Decoder().decodeBuffer(authorizationBase64));
//        String[] tokenAndUserId = StringUtils.split(authorization,":");
//
//        if(tokenAndUserId.length != 2){
//            response.setStatus(401);
//            response.setHeader("WWW-authenticate","Basic realm=\"对不起你没有权限!!\"");
//            logger.error("valid register token error,authorization=" + authorization);
//            return false;
//        }
//
//        String clientToken = tokenAndUserId[0];
//        String userIdStr = tokenAndUserId[1];
//        long userId = Long.parseLong(userIdStr);
//        if(StringUtils.isBlank(clientToken) || StringUtils.isBlank(userIdStr) || userId<=0) {
//            response.setStatus(401);
//            response.setHeader("WWW-authenticate","Basic realm=\"对不起你没有权限!!\"");
//            logger.error("valid register token error,clientToken=" + clientToken + ",userId=" + userIdStr);
//            return false;
//        }
//
//        //后面需要用到userId
//        request.setAttribute("userId",userId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
