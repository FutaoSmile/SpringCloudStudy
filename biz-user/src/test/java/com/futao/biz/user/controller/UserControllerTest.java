package com.futao.biz.user.controller;

import com.futao.biz.user.dao.UserMapper;
import com.futao.biz.user.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author futao
 * @date 2020/1/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {


    @Autowired
    private UserMapper userMapper;

    /**
     * 在测试环境下，`@Transactional`注解的方法会自动回滚事物
     */
    @Transactional
    @Test
    public void list() {
        System.out.println(userMapper.insert(new UserEntity("RN", "18797811995", "杭州市", 1, "avt", "123", new Date())));
    }
}