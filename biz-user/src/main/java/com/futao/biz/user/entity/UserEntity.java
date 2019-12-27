package com.futao.biz.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.futao.common.db.IdTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author futao
 * @date 2019/12/27.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_user")
public class UserEntity extends IdTimeEntity {

    @TableField("real_name")
    private String realName;

    @TableField("mobile")
    private String mobile;

    @TableField("address")
    private String address;

    @TableField("sex")
    private Integer sex;

    @TableField("avatar")
    private String avatar;

    @TableField("password")
    private String password;

    @TableField("birthday")
    private Date birthday;
}
