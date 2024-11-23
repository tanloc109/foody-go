package com.foodygo.user.service;

import com.foodygo.user.dto.request.CreateRoleRequest;
import com.foodygo.user.dto.request.UpdateRoleRequest;
import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.Role;

import java.util.List;

public interface RoleService {
    List<UserDTO.RoleDTO> findAll();
    UserDTO.RoleDTO findById(Integer id);
    Role findEntityById(Integer id);
    UserDTO.RoleDTO create(CreateRoleRequest request);
    UserDTO.RoleDTO update(Integer id, UpdateRoleRequest request);
    Object delete(Integer id);
}
