package com.futao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 微服务网关Zuul
 * 路由转发、权限校验、限流控制
 *
 * @author futao
 * Created on 2019/03/19
 */
@EnableConfigurationProperties
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.futao.zuul", "com.futao.framework"})
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

}
