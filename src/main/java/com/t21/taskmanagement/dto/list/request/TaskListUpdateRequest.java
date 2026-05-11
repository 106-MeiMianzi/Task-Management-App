package com.t21.taskmanagement.dto.list.request;

import jakarta.validation.constraints.NotBlank;

public record TaskListUpdateRequest(
        @NotBlank
        String name
) {
}