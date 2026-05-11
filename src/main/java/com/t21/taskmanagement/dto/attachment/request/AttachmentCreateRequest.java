package com.t21.taskmanagement.dto.attachment.request;

import jakarta.validation.constraints.NotBlank;

public record AttachmentCreateRequest(
        @NotBlank
        String fileName,

        String fileType,

        @NotBlank
        String url
) {
}