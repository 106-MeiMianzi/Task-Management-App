package com.t21.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.tag.request.*;
import com.t21.taskmanagement.dto.tag.response.*;
import com.t21.taskmanagement.dto.tag.response.TagListResponse;
import com.t21.taskmanagement.dto.task.request.TaskTagCreateRequest;
import com.t21.taskmanagement.service.TagService;
import com.t21.taskmanagement.service.TaskService;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ApiResponse<TagListResponse> getTags(
            @RequestAttribute("userId") Long userId
    ) {
        return tagService.getTags(userId);
    }

    @PostMapping
    public ApiResponse<TagItemDTO> createTag(
            @Valid @RequestBody TagCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return tagService.createTag(req, userId);
    }

    @GetMapping("/{tagId}")
    public ApiResponse<TagItemDTO> getTagById(
            @PathVariable Long tagId,
            @RequestAttribute("userId") Long userId
    ) {
        return tagService.getTagById(tagId, userId);
    }

    @PatchMapping("/{tagId}")
    public ApiResponse<TagItemDTO> updateTag(
            @PathVariable Long tagId,
            @Valid @RequestBody TagUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return tagService.updateTag(tagId, req, userId);
    }

    @DeleteMapping("/{tagId}")
    public ApiResponse<Void> deleteTag(
            @PathVariable Long tagId,
            @RequestAttribute("userId") Long userId
    ) {
        return tagService.deleteTag(tagId, userId);
    }
}