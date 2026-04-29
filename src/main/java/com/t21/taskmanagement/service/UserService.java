package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.UserRegisterRequest;
import com.t21.taskmanagement.dto.user.response.UserRegisterResponse;

public interface UserService {
    ApiResponse<UserRegisterResponse> register(UserRegisterRequest req);
}
