package com.futao.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置管理中心
 * <p>
 * 访问http://localhost:8888/foo/dev
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * <p>
 * <p>
 * {application}, which maps to spring.application.name on the client side.
 * <p>
 * {profile}, which maps to spring.profiles.active on the client (comma-separated list).
 * <p>
 * {label}, which is a server side feature labelling a "versioned" set of config files.
 *
 *
 * * @EnableConfigServer 标识这是一个配置管理服务中心
 *
 * @author futao
 * Created on 2019/03/19
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
