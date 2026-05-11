package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.constraints.NotNull;

public record TaskOrderUpdateRequest(
        @NotNull
        Integer sortOrder
) {
}