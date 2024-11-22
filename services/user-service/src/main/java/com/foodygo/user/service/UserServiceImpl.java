package com.foodygo.user.service;

import com.foodygo.user.dto.request.UpdateProfileRequest;
import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.User;
import com.foodygo.user.mapper.UserMapper;
import com.foodygo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = repo.findAllByIsDeletedFalse();
        return users.stream()
                .map(UserMapper.INSTANCE::toDto)
                .toList();
    }


    @Override
    public UserDTO findById(Integer id) {
        return UserMapper.INSTANCE.toDto(repo.findByIdAndIsDeletedFalse(id));
    }

    @Override
    public User findEntityById(Integer id) {
        return repo.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public User findEntityByUsername(String username) {
        return repo.findByUsernameAndIsDeletedFalse(username);
    }

    @Override
    public User findEntityByPhone(String phone) {
        return repo.findByPhoneAndIsDeletedFalse(phone);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return UserMapper.INSTANCE.toDto(repo.findByUsernameAndIsDeletedFalse(username));
    }

    @Override
    public UserDTO save(User user) {
        return UserMapper.INSTANCE.toDto(repo.save(user));
    }

    @Override
    public Object delete(Integer id) {
        User temp = repo.findById(id).orElseThrow();
        temp.setIsDeleted(true);
        repo.save(temp);
        return null;
    }

    @Override
    public UserDTO updateProfile(Integer id, UpdateProfileRequest request) {
        User temp = repo.findByIdAndIsDeletedFalse(id);
        temp.setUsername(request.getUsername());
        temp.setFullname(request.getFullname());
        temp.setEmail(request.getEmail());
        return UserMapper.INSTANCE.toDto(repo.save(temp));
    }
}
