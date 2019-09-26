package com.futao.biz.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        //设置数据库的存储引擎
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
        SpringApplication.run(OrderApplication.class, args);
    }
}
