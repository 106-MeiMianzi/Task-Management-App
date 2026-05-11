package com.t21.taskmanagement.dto.task.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record TaskReorderRequest(
        @NotEmpty
        @Valid
        List<TaskOrderItemRequest> items
) {
}