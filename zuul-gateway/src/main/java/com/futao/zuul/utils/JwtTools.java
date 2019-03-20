package com.futao.zuul.utils;

import com.futao.zuul.model.UserTokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类(http://www.ibloger.net/article/3088.html)
 * Header.Payload.Signature
 * 只要服务端能确认是自己签发的 Token，而且其信息未被改动过，那就可以认为 Token 有效
 * TODO("token过期问题，因为session是用户每次访问都会刷新session访问时间，而token没有。是否可以通过在用户每次访问的时候都生成一个新的token")
 * TODO("问题:用户注销后，应该在服务端存储注销的jwt，否则被别人利用，还是能被系统验证通过")
 *
 * @author futao
 * Created on 2019-03-19.
 */
public class JwtTools {

    /**
     * 生成Token
     *
     * @param userTokenInfo 用户信息
     * @return 生成的token
     */
    public static String genToken(UserTokenInfo userTokenInfo) {
        return Jwts.builder()
                .setSubject(userTokenInfo.getUserName())
                .claim(Constant.JwtConfig.JWT_KEY_USER_ID, userTokenInfo.getUserId())
                .claim(Constant.JwtConfig.JWT_KEY_USER_NAME, userTokenInfo.getUserName())
                .setExpiration(new Date(System.currentTimeMillis() + Constant.JwtConfig.EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS256, Constant.JwtConfig.JWT_KEY)
                .compact();
    }

    /**
     * 根据token解析用户信息
     *
     * @param token token
     * @return 用户信息
     */
    public static UserTokenInfo getUserInfo(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Constant.JwtConfig.JWT_KEY)
                .parseClaimsJws(token)
                .getBody();
        UserTokenInfo userTokenInfo = new UserTokenInfo();
        userTokenInfo.setUserId(claims.get(Constant.JwtConfig.JWT_KEY_USER_ID).toString());
        userTokenInfo.setUserName(claims.get(Constant.JwtConfig.JWT_KEY_USER_NAME).toString());
        return userTokenInfo;
    }

}
