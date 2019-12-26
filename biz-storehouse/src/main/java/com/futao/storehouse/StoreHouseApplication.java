package com.futao.storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@SpringCloudApplication
public class StoreHouseApplication {
    public static void main(String[] args) {
        //设置数据库的存储引擎
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
        SpringApplication.run(StoreHouseApplication.class, args);
    }
}
