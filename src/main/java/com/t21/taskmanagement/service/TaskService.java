package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.task.response.*;
import com.t21.taskmanagement.dto.task.request.*;

public interface TaskService {
    ApiResponse<TaskListResponse> getTasks(
        Long userId,
        Integer status,
        Integer page,
        Integer size
    );

    ApiResponse<TaskItemDTO> createTask(
        TaskCreateRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> getTaskById(
        Long taskId,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTask(
        Long taskId,
        TaskUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteTask(
        Long taskId,
        Long userId
    );

    ApiResponse<Void> batchDeleteTasks(
        TaskBatchDeleteRequest req,
        Long userId
    );

    ApiResponse<Void> batchUpdateTasks(
        TaskBatchUpdateRequest req,
        Long userId
    );

    ApiResponse<TaskListResponse> searchTasks(
        TaskQueryRequest req,
        Long userId
    );

    ApiResponse<TaskListResponse> vectorSearchTasks(
        TaskVectorSearchRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTaskStatus(
        Long taskId,
        TaskStatusUpdateRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> completeTask(
        Long taskId,
        Long userId
    );

    ApiResponse<TaskItemDTO> uncompleteTask(
        Long taskId,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTaskProgress(
        Long taskId,
        TaskProgressUpdateRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTaskPriority(
        Long taskId,
        TaskPriorityUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> batchUpdateTaskPriority(
        TaskBatchPriorityUpdateRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTaskOrder(
        Long taskId,
        TaskOrderUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> reorderTasks(
        TaskReorderRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> updateTaskParent(
        Long taskId,
        TaskParentUpdateRequest req,
        Long userId
    );

    ApiResponse<TaskListResponse> getSubtasks(
        Long taskId,
        Long userId
    );

    ApiResponse<TaskItemDTO> createSubtask(
        Long taskId,
        TaskCreateRequest req,
        Long userId
    );

    ApiResponse<TaskListResponse> getTaskDependencies(
        Long taskId,
        Long userId
    );

    ApiResponse<Void> addTaskDependency(
        Long taskId,
        TaskDependencyCreateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteTaskDependency(
        Long taskId,
        Long dependencyId,
        Long userId
    );

    ApiResponse<TaskDependencyCycleCheckResponse> checkDependencyCycle(
        Long taskId,
        TaskDependencyCycleCheckRequest req,
        Long userId
    );

    ApiResponse<TaskListResponse> getTrashTasks(
        Long userId
    );

    ApiResponse<TaskItemDTO> restoreTask(
        Long taskId,
        Long userId
    );

    ApiResponse<Void> permanentlyDeleteTask(
        Long taskId,
        Long userId
    );

    ApiResponse<Void> emptyTaskTrash(Long userId);

    ApiResponse<Void> addTaskTag(
        Long taskId,
        TaskTagCreateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteTaskTag(
        Long taskId,
        Long tagId,
        Long userId
    );

    ApiResponse<Void> batchMoveTasks(
        TaskBatchMoveRequest req,
        Long userId
    );

    ApiResponse<TaskItemDTO> moveTask(
        Long taskId,
        TaskMoveRequest req,
        Long userId
    );
}
