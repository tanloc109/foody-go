package com.foodygo.user.service;

import com.foodygo.user.dto.request.CreateRoleRequest;
import com.foodygo.user.dto.request.UpdateRoleRequest;
import com.foodygo.user.entity.Role;
import com.foodygo.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    @Override
    public List<Role> findAll() {
        return repo.findAllByIsDeletedFalse();
    }

    @Override
    public Role findById(Integer id) {
        return repo.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public Role create(CreateRoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        return repo.save(role);
    }

    @Override
    public Role update(Integer id, UpdateRoleRequest request) {
        Role role = repo.findByIdAndIsDeletedFalse(id);
        role.setName(request.getName());
        return repo.save(role);
    }

    @Override
    public Object delete(Integer id) {
        Role temp = findById(id);
        temp.setIsDeleted(true);
        repo.save(temp);
        return null;
    }
}
