package com.t21.taskmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.list.response.*;
import com.t21.taskmanagement.dto.list.request.*;
import com.t21.taskmanagement.service.TaskListService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    @Override
    public ApiResponse<TaskListResponse> getTaskLists(
            Long userId
    ) {
        List<TaskListItemDTO> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            TaskListItemDTO item = new TaskListItemDTO(
                    (long) i,
                    "任务列表 " + i
            );

            list.add(item);
        }

        TaskListResponse response = new TaskListResponse(
                list,
                3L
        );

        return ApiResponse.success("获取任务列表成功", response);
    }

    @Override
    public ApiResponse<TaskListItemDTO> createTaskList(
            TaskListCreateRequest req,
            Long userId
    ) {
        TaskListItemDTO response = new TaskListItemDTO(
                System.currentTimeMillis(),
                req.name()
        );

        return ApiResponse.success("创建任务列表成功", response);
    }

    @Override
    public ApiResponse<TaskListItemDTO> getTaskListById(
            Long listId,
            Long userId
    ) {
        TaskListItemDTO response = new TaskListItemDTO(
                listId,
                "任务列表 " + listId
        );

        return ApiResponse.success("获取任务列表详情成功", response);
    }

    @Override
    public ApiResponse<TaskListItemDTO> updateTaskList(
            Long listId,
            TaskListUpdateRequest req,
            Long userId
    ) {
        TaskListItemDTO response = new TaskListItemDTO(
                listId,
                req.name()
        );

        return ApiResponse.success("更新任务列表成功", response);
    }

    @Override
    public ApiResponse<Void> deleteTaskList(
            Long listId,
            Long userId
    ) {
        return ApiResponse.success("删除任务列表成功", null);
    }
}