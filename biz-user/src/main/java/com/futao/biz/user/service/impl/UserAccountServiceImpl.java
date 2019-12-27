package com.futao.biz.user.service.impl;

import com.futao.biz.user.entity.UserAccount;
import com.futao.biz.user.mapper.UserAccountMapper;
import com.futao.biz.user.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户表 服务实现类
 * </p>
 *
 * @author futao
 * @since 2019-12-28
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
