package com.futao.serviceribbon.foundation;

import com.futao.framework.interceptors.RequestLogInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author futao
 * Created on 2019-03-20.
 */
@SpringBootConfiguration
public class WebWvcConfig implements WebMvcConfigurer {

    @Resource
    private RequestLogInterceptor requestLogInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
    }
}
