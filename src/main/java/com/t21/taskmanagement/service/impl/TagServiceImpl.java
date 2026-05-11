package com.t21.taskmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.tag.response.*;
import com.t21.taskmanagement.service.TagService;
import com.t21.taskmanagement.dto.tag.request.*;
import com.t21.taskmanagement.dto.task.request.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Override
    public ApiResponse<TagListResponse> getTags(
            Long userId
    ) {
        List<TagItemDTO> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            TagItemDTO item = new TagItemDTO(
                    (long) i,
                    "标签 " + i
            );

            list.add(item);
        }

        TagListResponse response = new TagListResponse(
                list,
                5L
        );

        return ApiResponse.success("获取标签列表成功", response);
    }

    @Override
    public ApiResponse<TagItemDTO> createTag(
            TagCreateRequest req,
            Long userId
    ) {
        TagItemDTO response = new TagItemDTO(
                System.currentTimeMillis(),
                req.name()
        );

        return ApiResponse.success("创建标签成功", response);
    }

    @Override
    public ApiResponse<TagItemDTO> getTagById(
            Long tagId,
            Long userId
    ) {
        TagItemDTO response = new TagItemDTO(
                tagId,
                "标签 " + tagId
        );

        return ApiResponse.success("获取标签详情成功", response);
    }

    @Override
    public ApiResponse<TagItemDTO> updateTag(
            Long tagId,
            TagUpdateRequest req,
            Long userId
    ) {
        TagItemDTO response = new TagItemDTO(
                tagId,
                req.name()
        );

        return ApiResponse.success("更新标签成功", response);
    }

    @Override
    public ApiResponse<Void> deleteTag(
            Long tagId,
            Long userId
    ) {
        return ApiResponse.success("删除标签成功", null);
    }
}