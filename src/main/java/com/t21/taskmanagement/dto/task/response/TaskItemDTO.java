package com.t21.taskmanagement.dto.task.response;

import java.time.LocalDateTime;

public record TaskItemDTO(
        Long taskId,
        String title,
        Integer status, // 0-未开始 1-进行中 2-完成
        Integer priority,
        Integer progress,
        LocalDateTime dueDate,
        LocalDateTime createdAt
) {
}
