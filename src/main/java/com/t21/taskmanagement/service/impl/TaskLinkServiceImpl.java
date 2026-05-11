package com.t21.taskmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.link.response.TaskLinkItemDTO;
import com.t21.taskmanagement.dto.link.response.TaskLinkListResponse;
import com.t21.taskmanagement.service.TaskLinkService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskLinkServiceImpl implements TaskLinkService {

    @Override
    public ApiResponse<TaskLinkListResponse> getTaskLinks(
            Long taskId,
            Long userId
    ) {
        List<TaskLinkItemDTO> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            TaskLinkItemDTO item = new TaskLinkItemDTO(
                    (long) i,
                    "链接 " + i,
                    "https://example.com/link/" + i
            );

            list.add(item);
        }

        TaskLinkListResponse response = new TaskLinkListResponse(
                list,
                3L
        );

        return ApiResponse.success("获取任务链接列表成功", response);
    }
}