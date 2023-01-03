package com.example.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        //InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**") //拦截所有请求，包括静态资源文件
                .excludePathPatterns("/", "/judge", "/login", "/index.html", "/user/login", "/css/**", "/images/**", "/js/**", "/fonts/**"); //放行登录页，登陆操作，静态资源
    }
}
