package com.futao.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 服务消费者consumer-ribbon版
 * 通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
 * 通过轮询ribbonServerList列表来达到负载均衡的目的
 * 客户端负载均衡:需要客户端自己维护一份服务清单列表，这份列表来自服务注册中心。
 * 服务端负载均衡由服务端维护一份服务清单列表。
 *
 * @author futao
 * Created on 2019/03/19
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.futao.serviceribbon", "com.futao.framework"})
@EnableHystrix
//http://localhost:8883/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8883%2Factuator%2Fhystrix.stream&delay=2000&title=miya
//https://www.cnblogs.com/chenweida/p/9025589.html
@EnableHystrixDashboard     //访问地址 http://localhost:8762/actuator/hystrix.stream
@EnableCircuitBreaker
//@EnableTurbine
public class ConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
