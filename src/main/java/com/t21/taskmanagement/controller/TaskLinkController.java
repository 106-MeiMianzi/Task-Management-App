package com.t21.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.link.response.TaskLinkListResponse;
import com.t21.taskmanagement.service.TaskLinkService;

@RestController
@RequestMapping("/api/v1")
public class TaskLinkController {

    @Autowired
    private TaskLinkService taskLinkService;

    @GetMapping("/tasks/{taskId}/links")
    public ApiResponse<TaskLinkListResponse> getTaskLinks(
            @PathVariable Long taskId,
            @RequestAttribute("userId") Long userId
    ) {
        return taskLinkService.getTaskLinks(taskId, userId);
    }
}