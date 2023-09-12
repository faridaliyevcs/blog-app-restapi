package com.blogapp.service.inter;

import com.blogapp.entity.User;

import java.util.List;

public interface UserServiceInter {

    public List<User> getAllUser();

    public void deleteUserByUserId(int id);

    public User updateNewUser(User user);

    public User getUserByUserId(int id);

}
