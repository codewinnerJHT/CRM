package com.gxa.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截前的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o  返回true是放行    返回false不放行
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取session对象
        HttpSession session = httpServletRequest.getSession();
        //通过
        Object admin = session.getAttribute("admin");
        //如果admin为空表示，没有登录
        if (admin == null){
            //获取上下文
            String contextPath = httpServletRequest.getContextPath();
            //重定向到登录页面
            httpServletResponse.sendRedirect(contextPath+"/page/login");
            return false;
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
