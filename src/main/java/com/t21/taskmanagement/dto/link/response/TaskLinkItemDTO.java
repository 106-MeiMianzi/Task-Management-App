package com.t21.taskmanagement.dto.link.response;

public record TaskLinkItemDTO(
        Long linkId,
        String title,
        String url
) {
}