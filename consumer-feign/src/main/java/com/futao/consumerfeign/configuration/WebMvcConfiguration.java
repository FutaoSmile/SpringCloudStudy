package com.futao.consumerfeign.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author futao
 * Created on 2019-03-21.
 */
@SpringBootConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 添加静态资源映射
     * <p>
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     * <p>
     * 配置了该资源解析器之后会导致swagger 404 ，需要加上对/swagger-ui.html的映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/file/**")
                .addResourceLocations("classpath:/uploadFiles/");
    }
}
