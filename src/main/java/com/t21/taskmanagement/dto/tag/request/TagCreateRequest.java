package com.t21.taskmanagement.dto.tag.request;

import jakarta.validation.constraints.NotBlank;

public record TagCreateRequest(
        @NotBlank
        String name
) {
}