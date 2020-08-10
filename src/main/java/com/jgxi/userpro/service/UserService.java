package com.jgxi.userpro.service;

import com.jgxi.userpro.entity.po.User;

import java.util.List;

public interface UserService {
    public List<User> queryUserList();
    public void addUser(User user);
}
