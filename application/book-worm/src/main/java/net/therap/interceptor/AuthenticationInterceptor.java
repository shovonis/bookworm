package net.therap.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author rifatul.islam
 * @since 6/19/14.
 */


public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);

    private HttpSession session;
    private String requestedUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        session = request.getSession();
        requestedUri = request.getRequestURI();
        if ((session == null || session.getAttribute("user") == null) &&
                (requestedUri.contains("profile") || requestedUri.contains("logout") ||
                        requestedUri.contains("notification") || requestedUri.contains("addbook") ||
                        requestedUri.contains("reputation"))) {

            response.sendRedirect("/login");
            log.info("User attempts to login without authorization {} ", new Date());

            return false;
        } else if ((session != null && session.getAttribute("user") != null) && requestedUri.contains("login")) {

            log.info("User attempts to login in logged in mode");
            response.sendRedirect("/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
