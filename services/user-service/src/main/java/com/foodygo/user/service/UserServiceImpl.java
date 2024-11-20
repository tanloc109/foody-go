package com.foodygo.user.service;

import com.foodygo.user.dto.request.UpdateProfileRequest;
import com.foodygo.user.entity.User;
import com.foodygo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAllByIsDeletedFalse();
    }

    @Override
    public User findById(Integer id) {
        return repo.findByIdAndIsDeletedFalse(id);
    }

    @Override
    public User findByUsername(String username) {
        return repo.findByUsernameAndIsDeletedFalse(username);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public Object delete(Integer id) {
        User temp = findById(id);
        temp.setIsDeleted(true);
        repo.save(temp);
        return null;
    }

    @Override
    public User updateProfile(Integer id, UpdateProfileRequest request) {
        User temp = findById(id);
        temp.setUsername(request.getUsername());
        temp.setFullname(request.getFullname());
        temp.setEmail(request.getEmail());
        return repo.save(temp);
    }
}
