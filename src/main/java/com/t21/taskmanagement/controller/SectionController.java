package com.t21.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.t21.taskmanagement.common.ApiResponse;
import com.t21.taskmanagement.dto.section.response.*;
import com.t21.taskmanagement.service.SectionService;
import com.t21.taskmanagement.dto.section.request.*;

@RestController
@RequestMapping("/api/v1")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/lists/{listId}/sections")
    public ApiResponse<SectionListResponse> getSections(
            @PathVariable Long listId,
            @RequestAttribute("userId") Long userId
    ) {
        return sectionService.getSections(listId, userId);
    }

    @PostMapping("/lists/{listId}/sections")
    public ApiResponse<SectionItemDTO> createSection(
            @PathVariable Long listId,
            @Valid @RequestBody SectionCreateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return sectionService.createSection(listId, req, userId);
    }

    @GetMapping("/sections/{sectionId}")
    public ApiResponse<SectionItemDTO> getSectionById(
            @PathVariable Long sectionId,
            @RequestAttribute("userId") Long userId
    ) {
        return sectionService.getSectionById(sectionId, userId);
    }

    @PatchMapping("/sections/{sectionId}")
    public ApiResponse<SectionItemDTO> updateSection(
            @PathVariable Long sectionId,
            @Valid @RequestBody SectionUpdateRequest req,
            @RequestAttribute("userId") Long userId
    ) {
        return sectionService.updateSection(sectionId, req, userId);
    }

    @DeleteMapping("/sections/{sectionId}")
    public ApiResponse<Void> deleteSection(
            @PathVariable Long sectionId,
            @RequestAttribute("userId") Long userId
    ) {
        return sectionService.deleteSection(sectionId, userId);
    }
}