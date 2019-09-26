package com.futao.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 *
 * @author futao
 * Created on 2019/03/19
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.trace("trace---");
        log.debug("debug---");
        log.info("info---");
        log.warn("warn---");
        log.error("error---");

        Logger logger = LoggerFactory.getLogger("payment-log");
        logger.trace("trace---payment");
        logger.debug("debug---payment");
        logger.info("info---payment");
        logger.warn("warn---payment");
        logger.error("error---payment");
    }
}
