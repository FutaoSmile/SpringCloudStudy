package com.futao.biz.user.controller;


import com.futao.biz.user.entity.UserSignIn;
import com.futao.biz.user.service.IUserSignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author futao
 * @since 2020-01-10
 */
@RestController
@RequestMapping("/user-sign-in")
public class UserSignInController {

    @Autowired
    private IUserSignInService userSignInService;


    @PostMapping
    public long signIn(
            @RequestBody UserSignIn userSignIn
    ) throws InterruptedException {
        userSignInService.save(userSignIn);
        Thread.sleep(30L);
        return System.currentTimeMillis();
    }

}

