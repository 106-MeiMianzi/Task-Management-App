package com.t21.taskmanagement.config;

import com.t21.taskmanagement.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;



@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
            "/api/v1/users/login",
                        "/api/v1/users/register"
                );
    }

    // 配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                // Live Server / 本地静态页常见端口；与浏览器地址栏一致（127.0.0.1 与 localhost 为不同 Origin）
                .allowedOrigins(
                        "http://127.0.0.1:5501",
                        "http://localhost:5500",
                        "http://127.0.0.1:5500",
                        "http://localhost:5501",
                        "http://127.0.0.1:5173",
                        "http://localhost:5173"
                )
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}