package com.t21.taskmanagement.service.impl;

import com.t21.taskmanagement.service.UserService;
import org.springframework.stereotype.Service;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.UserRegisterRequest;
import com.t21.taskmanagement.dto.user.response.UserRegisterResponse;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public ApiResponse<UserRegisterResponse> register(UserRegisterRequest req) {
        UserRegisterResponse response = new UserRegisterResponse(
                1L,
                req.username()
        );

        return ApiResponse.success("注册成功", response);
    }
}
