package com.t21.taskmanagement.service.impl;

import com.t21.taskmanagement.service.UserService;
import org.springframework.stereotype.Service;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.*;
import com.t21.taskmanagement.dto.user.response.*;

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

    @Override
    public ApiResponse<UserLoginResponse> login(UserLoginRequest req) {
        UserLoginResponse response = new UserLoginResponse(
            1L,
            req.username(),
            "token"
        );
        return ApiResponse.success("登录成功", response);
    }

    @Override
    public ApiResponse<Void> logout(Long userId) {
        return ApiResponse.success("退出登录成功", null);
    }

    @Override
    public ApiResponse<UserInfoResponse> getUserInfo(Long userId) {
        UserInfoResponse response = new UserInfoResponse(
            userId,
            "testUser"
        );
        return ApiResponse.success("获取用户信息成功", response);
    }

    @Override
    public ApiResponse<UserInfoResponse> updateUserInfo(Long userId, UserUpdateRequest req) {
        UserInfoResponse response = new UserInfoResponse(
            userId,
            req.username()
        );
        return ApiResponse.success("更新用户信息成功", response);
    }
}
