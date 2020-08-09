package com.jgxi.userpro.controller;

import com.jgxi.userpro.common.JgxiData;
import com.jgxi.userpro.entity.po.User;
import com.jgxi.userpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// springmvc    运行原理  常用注解
@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("test")
    public JgxiData test(){
        List<User> users = userService.queryUserList();
        return  JgxiData.getSuccessJgxiData(users);
    }
}
