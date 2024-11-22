package com.foodygo.user.service;

import com.foodygo.user.dto.request.CreateRoleRequest;
import com.foodygo.user.dto.request.UpdateRoleRequest;
import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.Role;
import com.foodygo.user.mapper.RoleMapper;
import com.foodygo.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    @Override
    public List<UserDTO.RoleDTO> findAll() {
        List<Role> roles = repo.findAll();
        return roles.stream()
                .map(RoleMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    public UserDTO.RoleDTO findById(Integer id) {
        return RoleMapper.INSTANCE.toDto(repo.findByIdAndIsDeletedFalse(id));
    }

    @Override
    public Role findEntityById(Integer id) {
        return repo.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public UserDTO.RoleDTO create(CreateRoleRequest request) {
        Role role = new Role();
        role.setName(request.getName());
        return RoleMapper.INSTANCE.toDto(repo.save(role));
    }

    @Override
    public UserDTO.RoleDTO update(Integer id, UpdateRoleRequest request) {
        Role role = repo.findByIdAndIsDeletedFalse(id);
        role.setName(request.getName());
        return RoleMapper.INSTANCE.toDto(repo.save(role));
    }

    @Override
    public Object delete(Integer id) {
        Role temp = repo.findByIdAndIsDeletedFalse(id);
        temp.setIsDeleted(true);
        repo.save(temp);
        return null;
    }
}
