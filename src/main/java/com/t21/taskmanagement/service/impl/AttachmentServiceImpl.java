package com.t21.taskmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.attachment.response.*;
import com.t21.taskmanagement.dto.attachment.request.*;
import com.t21.taskmanagement.service.AttachmentService;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Override
    public ApiResponse<AttachmentListResponse> getTaskAttachments(
            Long taskId,
            Long userId
    ) {
        List<AttachmentItemDTO> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            AttachmentItemDTO item = new AttachmentItemDTO(
                    (long) i,
                    "附件 " + i + ".pdf",
                    "PDF",
                    "https://example.com/files/" + i
            );

            list.add(item);
        }

        AttachmentListResponse response = new AttachmentListResponse(
                list,
                3L
        );

        return ApiResponse.success("获取任务附件列表成功", response);
    }

    @Override
    public ApiResponse<AttachmentItemDTO> addTaskAttachment(
            Long taskId,
            AttachmentCreateRequest req,
            Long userId
    ) {
        AttachmentItemDTO response = new AttachmentItemDTO(
                System.currentTimeMillis(),
                req.fileName(),
                req.fileType(),
                req.url()
        );

        return ApiResponse.success("新增任务附件成功", response);
    }

    @Override
    public ApiResponse<AttachmentItemDTO> getAttachmentById(
            Long attachmentId,
            Long userId
    ) {
        AttachmentItemDTO response = new AttachmentItemDTO(
                attachmentId,
                "附件 " + attachmentId + ".pdf",
                "PDF",
                "https://example.com/files/" + attachmentId
        );

        return ApiResponse.success("获取附件详情成功", response);
    }

    @Override
    public ApiResponse<Void> deleteAttachment(
            Long attachmentId,
            Long userId
    ) {
        return ApiResponse.success("删除附件成功", null);
    }

    @Override
    public ApiResponse<AttachmentItemDTO> uploadAttachment(
            MultipartFile file,
            Long userId
    ) {
        AttachmentItemDTO response = new AttachmentItemDTO(
                System.currentTimeMillis(),
                file.getOriginalFilename(),
                file.getContentType(),
                "https://example.com/files/" + file.getOriginalFilename()
        );

        return ApiResponse.success("上传附件成功", response);
    }

    @Override
    public ApiResponse<AttachmentItemDTO> createExternalAttachmentLink(
            AttachmentExternalLinkRequest req,
            Long userId
    ) {
        AttachmentItemDTO response = new AttachmentItemDTO(
                System.currentTimeMillis(),
                req.fileName(),
                req.platform(),
                req.url()
        );

        return ApiResponse.success("创建外部附件链接成功", response);
    }

    @Override
    public ApiResponse<AttachmentPreviewResponse> previewAttachment(
            Long attachmentId,
            Long userId
    ) {
        AttachmentPreviewResponse response = new AttachmentPreviewResponse(
                attachmentId,
                "附件 " + attachmentId + ".pdf",
                "https://example.com/preview/" + attachmentId,
                "PDF"
        );

        return ApiResponse.success("获取附件预览成功", response);
    }
}