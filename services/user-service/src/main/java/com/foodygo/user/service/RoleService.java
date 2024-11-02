package com.foodygo.user.service;

import com.foodygo.user.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Integer id);
    Role save(Role role);
    void delete(Integer id);
}
