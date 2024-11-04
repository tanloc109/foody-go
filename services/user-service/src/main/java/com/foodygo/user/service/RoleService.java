package com.foodygo.user.service;

import com.foodygo.user.dto.request.CreateRoleRequest;
import com.foodygo.user.dto.request.UpdateRoleRequest;
import com.foodygo.user.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Integer id);
    Role create(CreateRoleRequest request);
    Role update(Integer id, UpdateRoleRequest request);
    Object delete(Integer id);
}
