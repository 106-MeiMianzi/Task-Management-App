package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.tag.response.*;
import com.t21.taskmanagement.dto.tag.request.*;
import com.t21.taskmanagement.dto.task.request.*;

public interface TagService {

    ApiResponse<TagListResponse> getTags(
            Long userId
    );

    ApiResponse<TagItemDTO> createTag(
        TagCreateRequest req,
        Long userId
    );

    ApiResponse<TagItemDTO> getTagById(
        Long tagId,
        Long userId
    );

    ApiResponse<TagItemDTO> updateTag(
        Long tagId,
        TagUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteTag(
        Long tagId,
        Long userId
    );
}