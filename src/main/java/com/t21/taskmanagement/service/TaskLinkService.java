package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.link.response.TaskLinkListResponse;

public interface TaskLinkService {

    ApiResponse<TaskLinkListResponse> getTaskLinks(
            Long taskId,
            Long userId
    );
}