package com.t21.taskmanagement.service.impl;

import org.springframework.stereotype.Service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.section.response.*;
import com.t21.taskmanagement.dto.section.request.*;
import com.t21.taskmanagement.service.SectionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    @Override
    public ApiResponse<SectionListResponse> getSections(
            Long listId,
            Long userId
    ) {
        List<SectionItemDTO> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            SectionItemDTO item = new SectionItemDTO(
                    (long) i,
                    "分区 " + i
            );

            list.add(item);
        }

        SectionListResponse response = new SectionListResponse(
                list,
                3L
        );

        return ApiResponse.success("获取分区列表成功", response);
    }

    @Override
    public ApiResponse<SectionItemDTO> createSection(
            Long listId,
            SectionCreateRequest req,
            Long userId
    ) {
        SectionItemDTO response = new SectionItemDTO(
                System.currentTimeMillis(),
                req.name()
        );

        return ApiResponse.success("创建分区成功", response);
    }

    @Override
    public ApiResponse<SectionItemDTO> getSectionById(
            Long sectionId,
            Long userId
    ) {
        SectionItemDTO response = new SectionItemDTO(
                sectionId,
                "分区 " + sectionId
        );

        return ApiResponse.success("获取分区详情成功", response);
    }

    @Override
    public ApiResponse<SectionItemDTO> updateSection(
            Long sectionId,
            SectionUpdateRequest req,
            Long userId
    ) {
        SectionItemDTO response = new SectionItemDTO(
                sectionId,
                req.name()
        );

        return ApiResponse.success("更新分区成功", response);
    }

    @Override
    public ApiResponse<Void> deleteSection(
            Long sectionId,
            Long userId
    ) {
        return ApiResponse.success("删除分区成功", null);
    }
}