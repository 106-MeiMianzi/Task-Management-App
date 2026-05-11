package com.t21.taskmanagement.dto.link.response;

import java.util.List;

public record TaskLinkListResponse(
        List<TaskLinkItemDTO> list,
        Long total
) {
}