package com.jgxi.userpro.service.impl;

import com.jgxi.userpro.dao.UserDao;
import com.jgxi.userpro.entity.po.User;
import com.jgxi.userpro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service // 事务
public class UserServiceImpl implements UserService {
    @Resource //@resource 和@autowire  区别
    private UserDao userDao;
    @Override
    public List<User> queryUserList() {
        return userDao.selectList(null);
    }
}
