package com.foodygo.user.service;

import com.foodygo.user.dto.request.UpdateProfileRequest;
import com.foodygo.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User findByUsername(String username);
    User save(User user);
    User updateProfile(Integer id, UpdateProfileRequest request);
    Object delete(Integer id);
}
