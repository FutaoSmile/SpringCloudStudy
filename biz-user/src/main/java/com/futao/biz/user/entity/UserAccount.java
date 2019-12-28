package com.futao.biz.user.entity;

import java.math.BigDecimal;
import com.futao.common.db.IdTimeEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户账户表
 * </p>
 *
 * @author futao
 * @since 2019-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserAccount extends IdTimeEntity {

    private static final long serialVersionUID=1L;

    /**
     * 用户主键
     */
    private String userId;

    /**
     * 余额，保留两位小数
     */
    private BigDecimal balance;
}
