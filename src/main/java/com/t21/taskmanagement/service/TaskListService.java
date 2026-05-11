package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.list.response.*;
import com.t21.taskmanagement.dto.list.request.*;

public interface TaskListService {

    ApiResponse<TaskListResponse> getTaskLists(
            Long userId
    );

    ApiResponse<TaskListItemDTO> createTaskList(
        TaskListCreateRequest req,
        Long userId
    );

    ApiResponse<TaskListItemDTO> getTaskListById(
        Long listId,
        Long userId
    );

    ApiResponse<TaskListItemDTO> updateTaskList(
        Long listId,
        TaskListUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteTaskList(
        Long listId,
        Long userId
    );
}