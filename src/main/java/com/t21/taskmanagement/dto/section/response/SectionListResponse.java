package com.t21.taskmanagement.dto.section.response;

import java.util.List;

public record SectionListResponse(
        List<SectionItemDTO> list,
        Long total
) {
}