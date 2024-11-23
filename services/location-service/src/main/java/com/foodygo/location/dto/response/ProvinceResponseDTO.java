package com.foodygo.location.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ProvinceResponseDTO(
        Integer id,
        String name,
        List<DistrictResponseDTO> districts
) {
    @Builder
    public record DistrictResponseDTO(
            Integer id,
            String name,
            List<WardResponseDTO> wards
    ) {
        @Builder
        public record WardResponseDTO(
                Integer id,
                String name
        ) {}
    }
}
