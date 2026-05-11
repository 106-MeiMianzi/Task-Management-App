package com.t21.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.list.response.*;
import com.t21.taskmanagement.dto.list.request.*;
import com.t21.taskmanagement.service.TaskListService;

@RestController
@RequestMapping("/api/v1/lists")
public class TaskListController {

    @Autowired
    private TaskListService taskListService;

    @GetMapping
    public ApiResponse<TaskListResponse> getTaskLists(
            @RequestAttribute("userId") Long userId
    ) {
        return taskListService.getTaskLists(userId);
    }

    @PostMapping
    public ApiResponse<TaskListItemDTO> createTaskList(
            @Valid @RequestBody TaskListCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskListService.createTaskList(req, userId);
    }

    @GetMapping("/{listId}")
    public ApiResponse<TaskListItemDTO> getTaskListById(
            @PathVariable Long listId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskListService.getTaskListById(listId, userId);
    }

    @PatchMapping("/{listId}")
    public ApiResponse<TaskListItemDTO> updateTaskList(
            @PathVariable Long listId,
            @Valid @RequestBody TaskListUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return taskListService.updateTaskList(listId, req, userId);
    }

    @DeleteMapping("/{listId}")
    public ApiResponse<Void> deleteTaskList(
            @PathVariable Long listId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskListService.deleteTaskList(listId, userId);
    }
}