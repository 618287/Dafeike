package com.bjpowernode.crm.settings.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/6
 */
@Component
public class InterceptorCookie implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            Cookie cookie = cookies[0];
            String name = cookie.getName();
            if ("dog".equals(name)) {
                request.getSession().setAttribute("dafei", "chishi");
                request.getRequestDispatcher("/workbench/index.do").forward(request, response);
                return true;
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
