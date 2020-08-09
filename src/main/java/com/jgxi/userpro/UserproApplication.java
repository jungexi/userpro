package com.jgxi.userpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//
@MapperScan("com.jgxi.userpro.dao")//扫描持久层
public class UserproApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserproApplication.class, args);
    }

}
