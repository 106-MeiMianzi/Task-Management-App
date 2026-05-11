package com.t21.taskmanagement.dto.task.request;

import java.time.LocalDateTime;
import java.util.List;

public record TaskQueryRequest(
        String keyword,
        Integer status,
        Integer priority,
        List<Long> tagIds,
        Long listId,
        Long sectionId,
        LocalDateTime dueDateStart,
        LocalDateTime dueDateEnd,
        String sortBy,
        String sortOrder,
        Integer page,
        Integer size
) {
}