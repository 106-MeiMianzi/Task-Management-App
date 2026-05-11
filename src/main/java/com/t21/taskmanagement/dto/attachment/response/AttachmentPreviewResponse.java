package com.t21.taskmanagement.dto.attachment.response;

public record AttachmentPreviewResponse(
        Long attachmentId,
        String fileName,
        String previewUrl,
        String previewType
) {
}