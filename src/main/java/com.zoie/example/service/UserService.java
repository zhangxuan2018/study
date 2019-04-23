package com.zoie.example.service;

import com.zoie.example.entity.User;

import java.util.List;

public interface UserService {

    public User getUserById(Long id);

    public void save(User user);

    public List<User> getUserList();
}
