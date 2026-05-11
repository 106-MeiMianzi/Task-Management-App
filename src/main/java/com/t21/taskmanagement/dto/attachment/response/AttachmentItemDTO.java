package com.t21.taskmanagement.dto.attachment.response;

public record AttachmentItemDTO(
        Long attachmentId,
        String fileName,
        String fileType,
        String url
) {
}