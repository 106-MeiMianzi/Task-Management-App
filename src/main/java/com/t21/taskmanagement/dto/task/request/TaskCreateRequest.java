package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.constraints.NotBlank;

public record TaskCreateRequest(
    @NotBlank
    String title,
    String content,
    Integer priority
) {}
