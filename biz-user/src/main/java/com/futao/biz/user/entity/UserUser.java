package com.futao.biz.user.entity;

import com.futao.common.db.IdTimeEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author futao
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserUser extends IdTimeEntity {

    private static final long serialVersionUID=1L;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 生日
     */
    private LocalDate birthday;
}
