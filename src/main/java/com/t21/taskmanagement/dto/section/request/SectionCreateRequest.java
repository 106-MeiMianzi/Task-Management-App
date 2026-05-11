package com.t21.taskmanagement.dto.section.request;

import jakarta.validation.constraints.NotBlank;

public record SectionCreateRequest(
        @NotBlank
        String name
) {
}