package com.t21.taskmanagement.dto.tag.request;

import jakarta.validation.constraints.NotBlank;

public record TagUpdateRequest(
        @NotBlank
        String name
) {
}