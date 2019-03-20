package com.futao.zuul.utils;

/**
 * @author futao
 * Created on 2019-03-19.
 */
public class Constant {
    public static class JwtConfig {
        private static final String VERIFY_KEY = "futao";
        public static final String JWT_KEY_USER_ID = VERIFY_KEY + "userId";
        public static final String JWT_KEY_USER_NAME = VERIFY_KEY + "userName";

        /**
         * JWT有效时长
         */
        public static final long EXPIRED_TIME = 1000 * 60 * 60 * 24;
        public static final String JWT_KEY = "nobug666";


    }
}
