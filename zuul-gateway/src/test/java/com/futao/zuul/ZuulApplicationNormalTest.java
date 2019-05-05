package com.futao.zuul;

import com.futao.zuul.model.UserTokenInfo;
import com.futao.zuul.utils.JwtTools;
import org.junit.Test;

import java.util.Base64;

/**
 * @author futao
 * Created on 2019-03-19.
 */
public class ZuulApplicationNormalTest {

    @Test
    public void test2() {
        System.out.println(new String(Base64.getDecoder().decode("eyJhbGciOiJIUzI1NiJ9")));
        System.out.println(new String(Base64.getDecoder().decode("eyJzdWIiOiLku5jpn6wiLCJmdXRhb3VzZXJJZCI6IjEyMyIsImZ1dGFvdXNlck5hbWUiOiLku5jpn6wiLCJleHAiOjE1NTMwNzQ0NzF9")));
        System.out.println(new String(Base64.getDecoder().decode("BHyC4pX7kYpHsJWbqqizBdwmzbPRMs3xnlE6KHFNfKs")));

    }

    @Test
    public void test1() {
        System.out.println(JwtTools.genToken(new UserTokenInfo("123", "付韬")));
//        System.out.println(JwtTools.getUserInfo("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLku5jpn6wiLCJmdXRhb3VzZXJJZCI6IjEyMyIsImZ1dGFvdXNlck5hbWUiOiLku5jpn6wiLCJleHAiOjE1NTI5OTI2NzR9.CuBxrZ3Tv6bJXNXT7wtYiJHqcJYMazN5JXLbYztx7wU"));
    }
}
