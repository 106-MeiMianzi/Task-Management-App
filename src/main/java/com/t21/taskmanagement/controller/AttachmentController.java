package com.t21.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.attachment.response.*;
import com.t21.taskmanagement.dto.attachment.request.*;
import com.t21.taskmanagement.service.AttachmentService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/tasks/{taskId}/attachments")
    public ApiResponse<AttachmentListResponse> getTaskAttachments(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.getTaskAttachments(taskId, userId);
    }

    @PostMapping("/tasks/{taskId}/attachments")
    public ApiResponse<AttachmentItemDTO> addTaskAttachment(
            @PathVariable Long taskId,
            @Valid @RequestBody AttachmentCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.addTaskAttachment(taskId, req, userId);
    }

    @GetMapping("/attachments/{attachmentId}")
    public ApiResponse<AttachmentItemDTO> getAttachmentById(
            @PathVariable Long attachmentId,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.getAttachmentById(attachmentId, userId);
    }

    @DeleteMapping("/attachments/{attachmentId}")
    public ApiResponse<Void> deleteAttachment(
            @PathVariable Long attachmentId,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.deleteAttachment(attachmentId, userId);
    }

    @PostMapping("/attachments/upload")
    public ApiResponse<AttachmentItemDTO> uploadAttachment(
            @RequestParam("file") MultipartFile file,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.uploadAttachment(file, userId);
    }

    @PostMapping("/attachments/external-link")
    public ApiResponse<AttachmentItemDTO> createExternalAttachmentLink(
            @Valid @RequestBody AttachmentExternalLinkRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.createExternalAttachmentLink(req, userId);
    }

    @GetMapping("/attachments/{attachmentId}/preview")
    public ApiResponse<AttachmentPreviewResponse> previewAttachment(
            @PathVariable Long attachmentId,
            @RequestAttribute("userId") Long userId
    ) {
        return attachmentService.previewAttachment(attachmentId, userId);
    }
}