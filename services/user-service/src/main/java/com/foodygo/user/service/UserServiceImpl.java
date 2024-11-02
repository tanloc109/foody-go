package com.foodygo.user.service;

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
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public void delete(Integer id) {
        User temp = findById(id);
        temp.setIsDeleted(true);
        repo.save(temp);
    }
}
