package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

public record TaskBatchUpdateRequest(
        @NotEmpty
        List<Long> taskIds,

        String title,
        String content,
        Integer status,
        Integer priority,
        Integer progress,
        LocalDateTime dueDate
) {
}