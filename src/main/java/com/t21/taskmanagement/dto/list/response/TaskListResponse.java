package com.t21.taskmanagement.dto.list.response;

import java.util.List;

public record TaskListResponse(
        List<TaskListItemDTO> list,
        Long total
) {
}