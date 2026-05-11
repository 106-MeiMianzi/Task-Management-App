package com.t21.taskmanagement.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
) throws Exception {

    // 直接放行预检请求
    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("Access-Control-Allow-Origin",
                request.getHeader("Origin"));

        response.setHeader("Access-Control-Allow-Methods",
                "GET,POST,PUT,PATCH,DELETE,OPTIONS");

        response.setHeader("Access-Control-Allow-Headers",
                "Authorization,Content-Type");

        response.setHeader("Access-Control-Allow-Credentials",
                "true");

        return false;
    }

    String token = request.getHeader("Authorization");

    if (token == null || token.isBlank()) {
        response.setStatus(401);
        return false;
    }

    Long userId = 1L;
    request.setAttribute("userId", userId);

    return true;
}
}