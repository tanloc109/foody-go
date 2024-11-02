package com.foodygo.user.repository;

import com.foodygo.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findAllByIsDeletedFalse();
    Role findByIdAndIsDeletedFalse(Integer id);
}
