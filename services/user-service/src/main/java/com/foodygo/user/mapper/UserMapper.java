package com.foodygo.user.mapper;

import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
    User toEntity(UserDTO dto);
}
