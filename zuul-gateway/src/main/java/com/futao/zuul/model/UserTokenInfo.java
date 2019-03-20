package com.futao.zuul.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
