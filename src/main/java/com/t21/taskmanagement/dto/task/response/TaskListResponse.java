package com.t21.taskmanagement.dto.task.response;

import java.util.List;

public record TaskListResponse(
        List<TaskItemDTO> list,
        Long total,
        Integer page,
        Integer size
) {
}
