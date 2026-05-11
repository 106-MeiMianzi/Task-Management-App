package com.t21.taskmanagement.dto.attachment.response;

import java.util.List;

public record AttachmentListResponse(
        List<AttachmentItemDTO> list,
        Long total
) {
}