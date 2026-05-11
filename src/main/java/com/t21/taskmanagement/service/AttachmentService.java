package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.attachment.response.*;
import com.t21.taskmanagement.dto.attachment.request.*;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {

    ApiResponse<AttachmentListResponse> getTaskAttachments(
            Long taskId,
            Long userId
    );

    ApiResponse<AttachmentItemDTO> addTaskAttachment(
        Long taskId,
        AttachmentCreateRequest req,
        Long userId
    );

    ApiResponse<AttachmentItemDTO> getAttachmentById(
        Long attachmentId,
        Long userId
    );

    ApiResponse<Void> deleteAttachment(
        Long attachmentId,
        Long userId
    );

    ApiResponse<AttachmentItemDTO> uploadAttachment(
        MultipartFile file,
        Long userId
    );

    ApiResponse<AttachmentItemDTO> createExternalAttachmentLink(
        AttachmentExternalLinkRequest req,
        Long userId
    );
    ApiResponse<AttachmentPreviewResponse> previewAttachment(
        Long attachmentId,
        Long userId
    );
}