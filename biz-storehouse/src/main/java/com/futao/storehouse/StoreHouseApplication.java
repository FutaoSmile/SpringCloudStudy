package com.futao.storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@EnableEurekaClient
@SpringBootApplication
public class StoreHouseApplication {
    public static void main(String[] args) {
        //设置数据库的存储引擎
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
        SpringApplication.run(StoreHouseApplication.class, args);
    }
}
