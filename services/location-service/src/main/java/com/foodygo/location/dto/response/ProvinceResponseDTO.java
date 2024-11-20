package com.foodygo.location.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ProvinceResponseDTO(
        Integer total,
        List<ProvinceDTO> data,
        String code,
        String message
) {
    @Builder
    public record ProvinceDTO(
            String id,
            String name,
            Integer type,
            String typeText,
            String slug
    ) {
    }
}
