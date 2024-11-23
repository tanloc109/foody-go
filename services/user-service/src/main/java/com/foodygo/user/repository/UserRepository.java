package com.foodygo.user.repository;

import com.foodygo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByIsDeletedFalse();
    User findByIdAndIsDeletedFalse(Integer id);
    User findByUsernameAndIsDeletedFalse(String username);
    User findByEmailAndIsDeletedFalse(String email);
    User findByPhoneAndIsDeletedFalse(String username);
}
