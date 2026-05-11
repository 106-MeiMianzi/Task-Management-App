package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record TaskBatchDeleteRequest(
        @NotEmpty
        List<Long> taskIds
) {}
