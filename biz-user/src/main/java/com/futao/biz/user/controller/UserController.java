package com.futao.biz.user.controller;

import com.futao.biz.user.entity.UserEntity;
import com.futao.biz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author futao
 * @date 2019/12/27.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserEntity> list() {
        return userService.list();
    }

}
