package com.t21.taskmanagement.dto.task.request;

import java.util.List;

public record TaskVectorSearchRequest(
        String query,
        Integer topK,
        Double threshold,
        Integer status,
        Integer priority,
        List<Long> tagIds,
        Integer page,
        Integer size
) {
}