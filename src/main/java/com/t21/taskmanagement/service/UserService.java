package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.UserRegisterRequest;
import com.t21.taskmanagement.dto.user.response.UserRegisterResponse;
import com.t21.taskmanagement.dto.user.request.UserLoginRequest;
import com.t21.taskmanagement.dto.user.response.UserLoginResponse;
import com.t21.taskmanagement.dto.user.response.UserInfoResponse;
import com.t21.taskmanagement.dto.user.request.UserUpdateRequest;

public interface UserService {
    ApiResponse<UserRegisterResponse> register(UserRegisterRequest req);
    ApiResponse<UserLoginResponse> login(UserLoginRequest req);
    ApiResponse<Void> logout(Long userId);
    ApiResponse<UserInfoResponse> getUserInfo(Long userId);
    ApiResponse<UserInfoResponse> updateUserInfo(Long userId, UserUpdateRequest req);
}
