package com.t21.taskmanagement.dto.tag.response;

import java.util.List;

public record TagListResponse(
        List<TagItemDTO> list,
        Long total
) {
}