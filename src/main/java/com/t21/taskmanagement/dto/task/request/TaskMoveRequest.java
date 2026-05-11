package com.t21.taskmanagement.dto.task.request;

public record TaskMoveRequest(
        Long targetListId,
        Long targetSectionId
) {
}