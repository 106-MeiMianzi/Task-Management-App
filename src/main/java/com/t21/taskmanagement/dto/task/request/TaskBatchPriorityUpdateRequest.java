package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record TaskBatchPriorityUpdateRequest(
        @NotEmpty
        List<Long> taskIds,
        @NotNull
        Integer priority
) {
}