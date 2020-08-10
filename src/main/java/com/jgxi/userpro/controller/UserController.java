package com.jgxi.userpro.controller;

import com.jgxi.userpro.common.JgxiData;
import com.jgxi.userpro.entity.po.User;
import com.jgxi.userpro.service.UserService;
import com.jgxi.userpro.utils.FileUtils_jgxi;
import com.jgxi.userpro.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// springmvc    运行原理  常用注解
@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("registerUser")
    public JgxiData registerUser(User user,@RequestParam("img") MultipartFile img){
        Map rs=new HashMap();
        String filePath="";
        //处理上传的文件   //阿里云上
        try {
             filePath = FileUtils_jgxi.uploadFileToOss(img.getOriginalFilename(), img.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            rs.put("code",300);
            rs.put("message","处理上传文件异常:"+e.getMessage());
            return JgxiData.getSuccessJgxiData(rs);
        }
        //设置用户的相关信息
        user.setImgPath(filePath);
        user.setRegisterDate(new Date());
        //设置密码  加两次密  md5（md5(password)+唯一的标示）+
        String password= MD5.encrypByMd5(MD5.encrypByMd5(user.getPassword())+user.getName());
        user.setPassword(password);
        //保存注册信息
        userService.addUser(user);
        rs.put("code",200);
        rs.put("message","注册成功");
        return JgxiData.getSuccessJgxiData(rs);
    }
}
