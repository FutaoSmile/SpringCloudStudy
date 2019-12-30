package com.futao.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@SpringBootApplication
@RestController("/")
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setMaxAge(18000L);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
}
