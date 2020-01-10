package com.futao.biz.user.entity;

import com.futao.common.db.IdTimeEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author futao
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserSignIn extends IdTimeEntity {

    private static final long serialVersionUID=1L;

    private String userId;

    private String projectId;

    private String lat;

    private String lnt;


}
