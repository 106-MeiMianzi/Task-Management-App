package com.t21.taskmanagement.dto.attachment.request;

import jakarta.validation.constraints.NotBlank;

public record AttachmentExternalLinkRequest(
        @NotBlank
        String fileName,

        @NotBlank
        String url,

        String platform
) {
}