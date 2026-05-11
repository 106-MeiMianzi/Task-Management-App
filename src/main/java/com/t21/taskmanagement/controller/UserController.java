package com.t21.taskmanagement.controller;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.t21.taskmanagement.service.UserService;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.UserRegisterRequest;
import com.t21.taskmanagement.dto.user.response.UserRegisterResponse;
import com.t21.taskmanagement.dto.user.response.UserLoginResponse;
import com.t21.taskmanagement.dto.user.request.UserLoginRequest;
import com.t21.taskmanagement.dto.user.response.UserInfoResponse;
import com.t21.taskmanagement.dto.user.request.UserUpdateRequest;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserRegisterResponse> register(@Valid @RequestBody UserRegisterRequest req) {
        return userService.register(req);
    }

    @PostMapping("/login")
    public ApiResponse<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest req) {
        return userService.login(req);
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestAttribute("userId") Long userId) {
        return userService.logout(userId);
    }

    @GetMapping("/me")
    public ApiResponse<UserInfoResponse> getUserInfo(@RequestAttribute("userId") Long userId) {
        return userService.getUserInfo(userId);
    }

    @PutMapping("/users/me")
    public ApiResponse<UserInfoResponse> updateUserInfo(
        @RequestAttribute("userId") Long userId,
        @Valid @RequestBody UserUpdateRequest req
    ) {
        return userService.updateUserInfo(userId, req);
    }


}
