package com.t21.taskmanagement.dto.task.request;

import java.time.LocalDateTime;

public record TaskUpdateRequest(
        String title,
        String content,
        Integer priority,
        Integer status,
        Integer progress,
        LocalDateTime dueDate
) {
}
