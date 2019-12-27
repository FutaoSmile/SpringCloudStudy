package com.futao.biz.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.common.db.IdTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author futao
 * @date 2019/12/27.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_account")
public class AccountEntity extends IdTimeEntity {

    @TableField("user_id")
    private String userId;

    @TableField("余额")
    private double balance;
}
