package com.hsogoo.gamestorm.filter;

import com.hsogoo.gamestorm.constant.NormalConstant;
import com.hsogoo.gamestorm.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huangsaigang
 * @time 15-12-30 上午10:28
 */
public class SessionFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        SessionUtil.clear();
    }

    /**把HttpSession对象放入ThreadLocal*/
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest session_request = (HttpServletRequest) request;
        HttpSession session = session_request.getSession();
        SessionUtil.set(NormalConstant.USER_SESSION_KEY, session);
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
