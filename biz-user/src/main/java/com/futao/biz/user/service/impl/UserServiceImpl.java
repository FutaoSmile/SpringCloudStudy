package com.futao.biz.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.futao.biz.user.dao.UserMapper;
import com.futao.biz.user.entity.UserEntity;
import com.futao.biz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author futao
 * @date 2019/12/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> list() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }
}
