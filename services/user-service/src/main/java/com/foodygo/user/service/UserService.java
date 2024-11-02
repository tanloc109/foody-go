package com.foodygo.user.service;

import com.foodygo.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user);
    void delete(Integer id);
}
