package com.t21.taskmanagement.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.t21.taskmanagement.service.TaskService;
import jakarta.validation.Valid;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.task.response.*;
import com.t21.taskmanagement.dto.task.request.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController{
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ApiResponse<TaskListResponse> getTasks(
            @RequestParam(required = false) Integer status,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.getTasks(userId, status, page, size);
    }

    @PostMapping
    public ApiResponse<TaskItemDTO> createTask(
            @Valid @RequestBody TaskCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.createTask(req, userId);
    }

    @GetMapping("/{taskId}")
    public ApiResponse<TaskItemDTO> getTaskById(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.getTaskById(taskId, userId);
    }

    @PatchMapping("/{taskId}")
    public ApiResponse<TaskItemDTO> updateTask(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTask(taskId, req, userId);
    }

    @DeleteMapping("/{taskId}")
    public ApiResponse<Void> deleteTask(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.deleteTask(taskId, userId);
    }

    @DeleteMapping("/batch-delete")
    public ApiResponse<Void> batchDeleteTasks(
            @Valid @RequestBody TaskBatchDeleteRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.batchDeleteTasks(req, userId);
    }

    @PatchMapping("/batch-update")
    public ApiResponse<Void> batchUpdateTasks(
            @Valid @RequestBody TaskBatchUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.batchUpdateTasks(req, userId);
    }

    @PostMapping("/search")
    public ApiResponse<TaskListResponse> searchTasks(
            @Valid @RequestBody TaskQueryRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.searchTasks(req, userId);
    }

    @PostMapping("/vector-search")
    public ApiResponse<TaskListResponse> vectorSearchTasks(
            @Valid @RequestBody TaskVectorSearchRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.vectorSearchTasks(req, userId);
    }

    @PatchMapping("/{taskId}/status")
    public ApiResponse<TaskItemDTO> updateTaskStatus(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskStatusUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTaskStatus(taskId, req, userId);
    }

    @PatchMapping("/{taskId}/complete")
    public ApiResponse<TaskItemDTO> completeTask(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.completeTask(taskId, userId);
    }

    @PatchMapping("/{taskId}/uncomplete")
    public ApiResponse<TaskItemDTO> uncompleteTask(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.uncompleteTask(taskId, userId);
    }

    @PatchMapping("/{taskId}/progress")
    public ApiResponse<TaskItemDTO> updateTaskProgress(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskProgressUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTaskProgress(taskId, req, userId);
    }

    @PatchMapping("/{taskId}/priority")
    public ApiResponse<TaskItemDTO> updateTaskPriority(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskPriorityUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTaskPriority(taskId, req, userId);
    }

    @PatchMapping("/batch-priority")
    public ApiResponse<Void> batchUpdateTaskPriority(
            @Valid @RequestBody TaskBatchPriorityUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.batchUpdateTaskPriority(req, userId);
    }

    @PatchMapping("/{taskId}/order")
    public ApiResponse<TaskItemDTO> updateTaskOrder(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskOrderUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTaskOrder(taskId, req, userId);
    }

    @PatchMapping("/reorder")
    public ApiResponse<Void> reorderTasks(
            @Valid @RequestBody TaskReorderRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.reorderTasks(req, userId);
    }

    @PatchMapping("/{taskId}/parent")
    public ApiResponse<TaskItemDTO> updateTaskParent(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskParentUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.updateTaskParent(taskId, req, userId);
    }

    @GetMapping("/{taskId}/subtasks")
    public ApiResponse<TaskListResponse> getSubtasks(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.getSubtasks(taskId, userId);
    }

    @PostMapping("/{taskId}/subtasks")
    public ApiResponse<TaskItemDTO> createSubtask(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.createSubtask(taskId, req, userId);
    }

    @GetMapping("/{taskId}/dependencies")
    public ApiResponse<TaskListResponse> getTaskDependencies(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.getTaskDependencies(taskId, userId);
    }

    @PostMapping("/{taskId}/dependencies")
    public ApiResponse<Void> addTaskDependency(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskDependencyCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.addTaskDependency(taskId, req, userId);
    }

    @DeleteMapping("/{taskId}/dependencies/{dependencyId}")
    public ApiResponse<Void> deleteTaskDependency(
            @PathVariable Long taskId,
            @PathVariable Long dependencyId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.deleteTaskDependency(taskId, dependencyId, userId);
    }

    @PostMapping("/{taskId}/dependencies/check-cycle")
    public ApiResponse<TaskDependencyCycleCheckResponse> checkDependencyCycle(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskDependencyCycleCheckRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.checkDependencyCycle(taskId, req, userId);
    }

    @GetMapping("/trash")
    public ApiResponse<TaskListResponse> getTrashTasks(
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.getTrashTasks(userId);
    }

    @PostMapping("/{taskId}/restore")
    public ApiResponse<TaskItemDTO> restoreTask(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.restoreTask(taskId, userId);
    }

    @DeleteMapping("/{taskId}/permanent")
    public ApiResponse<Void> permanentlyDeleteTask(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.permanentlyDeleteTask(taskId, userId);
    }

    @PostMapping("/trash/empty")
    public ApiResponse<Void> emptyTaskTrash(
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.emptyTaskTrash(userId);
    }

    @PostMapping("/{taskId}/tags")
    public ApiResponse<Void> addTaskTag(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskTagCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.addTaskTag(taskId, req, userId);
    }

    @DeleteMapping("/{taskId}/tags/{tagId}")
    public ApiResponse<Void> deleteTaskTag(
            @PathVariable Long taskId,
            @PathVariable Long tagId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.deleteTaskTag(taskId, tagId, userId);
    }

    @PostMapping("/batch-move")
    public ApiResponse<Void> batchMoveTasks(
            @Valid @RequestBody TaskBatchMoveRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.batchMoveTasks(req, userId);
    }

    @PatchMapping("/{taskId}/move")
    public ApiResponse<TaskItemDTO> moveTask(
            @PathVariable Long taskId,
            @Valid @RequestBody TaskMoveRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskService.moveTask(taskId, req, userId);
    }
}
