package com.foodygo.user.mapper;

import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    UserDTO.RoleDTO toDto(Role role);
    Role toEntity(UserDTO.RoleDTO dto);
}
