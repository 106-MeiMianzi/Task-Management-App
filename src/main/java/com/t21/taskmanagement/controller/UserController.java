package com.t21.taskmanagement.controller;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.t21.taskmanagement.service.UserService;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.user.request.UserRegisterRequest;
import com.t21.taskmanagement.dto.user.response.UserRegisterResponse;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserRegisterResponse> register(@Valid @RequestBody UserRegisterRequest req) {
        //注册接口不需要userId属性
        return userService.register(req);
    }
}
