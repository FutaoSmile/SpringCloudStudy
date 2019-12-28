package com.futao.biz.user;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author futao
 * @date 2019/12/25.
 */
@Slf4j
@EnableApolloConfig({"TEST1.base", "application"})
@MapperScan({"com.futao.biz.user.dao", "com.futao.biz.user.mapper"})
@SpringBootApplication(scanBasePackages = {"com.futao.common", "com.futao.biz.user"})
public class UserApplication implements CommandLineRunner {


    @Value("${app.apollo.username}")
    private String userName;

    @Value("${app.apollo.age}")
    private int age;

    @Value("${apl.conf1}")
    private String c1;

    @Value("${apl.conf2}")
    private String c2;

    @Value("${apl.conf3}")
    private String c3;

    @Value("${apl.conf4}")
    private String c4;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            while (true) {
                log.info(StringUtils.repeat("-", 50));
                log.info("userName:{}", userName);
                log.info("age:{}", age);
                log.info("c1:{}", c1);
                log.info("c2:{}", c2);
                log.info("c3:{}", c3);
                log.info("c4:{}", c4);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
