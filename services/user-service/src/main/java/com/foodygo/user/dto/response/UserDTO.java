package com.foodygo.user.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UserDTO(
        String id,
        String name,
        String fullname,
        String phone,
        String email,
        Boolean isDeleted,
        List<RoleDTO> roles
) {
    @Builder
    public record RoleDTO(
            String id,
            String name,
            Boolean isDeleted
    ) {
    }
}
