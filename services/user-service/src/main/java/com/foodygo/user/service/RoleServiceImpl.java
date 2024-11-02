package com.foodygo.user.service;

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
    public Role save(Role role) {
        return repo.save(role);
    }

    @Override
    public void delete(Integer id) {
        Role temp = findById(id);
        temp.setIsDeleted(true);
        repo.save(temp);
    }
}
