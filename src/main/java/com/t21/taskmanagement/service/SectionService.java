package com.t21.taskmanagement.service;

import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.section.response.*;
import com.t21.taskmanagement.dto.section.request.*;

public interface SectionService {

    ApiResponse<SectionListResponse> getSections(
            Long listId,
            Long userId
    );

    ApiResponse<SectionItemDTO> createSection(
        Long listId,
        SectionCreateRequest req,
        Long userId
    );

    ApiResponse<SectionItemDTO> getSectionById(
        Long sectionId,
        Long userId
    );

    ApiResponse<SectionItemDTO> updateSection(
        Long sectionId,
        SectionUpdateRequest req,
        Long userId
    );

    ApiResponse<Void> deleteSection(
        Long sectionId,
        Long userId
    );
}