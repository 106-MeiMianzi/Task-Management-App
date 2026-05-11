package com.t21.taskmanagement.dto.task.response;

public record TaskDependencyCycleCheckResponse(
        Boolean hasCycle,
        String message
) {
}