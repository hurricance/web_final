package com.example.test.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前session
        HttpSession session = request.getSession();
        // 根据session获取登录用户
        String user = (String) session.getAttribute("user");
        // 没登录，重定向到登录页面
        if (null == user) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        // 已经登录
        return true;
    }
}