package com.blogapp.service.impl;

import com.blogapp.entity.User;
import com.blogapp.repository.UserRepositoryCustomImpl;
import com.blogapp.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    private UserRepositoryCustomImpl userRepositoryCustom;

    @Override
    public List<User> getAllUser() {
        return userRepositoryCustom.getAllUser();
    }

    @Override
    public void deleteUserByUserId(int id) {
        userRepositoryCustom.deleteUserByUserId(id);
    }

    @Override
    public User updateNewUser(User user) {
        return userRepositoryCustom.updateNewUser(user);
    }

    @Override
    public User getUserByUserId(int id) {
        return userRepositoryCustom.getUserByUserId(id);
    }
}
