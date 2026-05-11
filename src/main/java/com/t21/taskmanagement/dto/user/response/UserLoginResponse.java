package com.t21.taskmanagement.dto.user.response;

public record UserLoginResponse(
    Long userId,
    String username,
    String token
) {
}
