package com.futao.biz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author futao
 * @date 2019/12/25.
 */
@MapperScan({"com.futao.biz.user.dao", "com.futao.biz.user.mapper"})
@SpringBootApplication(scanBasePackages = {"com.futao.common", "com.futao.biz.user"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
