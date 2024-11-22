package com.foodygo.user.service;

import com.foodygo.user.dto.request.UpdateProfileRequest;
import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Integer id);
    User findEntityById(Integer id);
    User findEntityByUsername(String username);
    User findEntityByPhone(String phone);
    UserDTO findByUsername(String username);
    UserDTO save(User user);
    UserDTO updateProfile(Integer id, UpdateProfileRequest request);
    Object delete(Integer id);
}
