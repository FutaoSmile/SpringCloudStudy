package com.futao.eurekaprovider.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author futao
 * Created on 2019-03-21.
 */
@SpringBootConfiguration
public class WebMvcConfiguration implements WebMvcConfigurer {

//    @Resource
//    private RequestLogInterceptor requestLogInterceptor;
//
//    @Resource
//    private FastJson2HttpMessageConverter fastJson2HttpMessageConverter;
//
//    /**
//     * 添加静态资源映射
//     * <p>
//     * Add handlers to serve static resources such as images, js, and, css
//     * files from specific locations under web application root, the classpath,
//     * and others.
//     * <p>
//     * 配置了该资源解析器之后会导致swagger 404 ，需要加上对/swagger-ui.html的映射
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//        registry.addResourceHandler("/file/**")
//                .addResourceLocations("classpath:/uploadFiles/");
//    }
//
//    /**
//     * 拦截器
//     *
//     * @param registry
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //正常情况下不会打印，异常情况下才会打印???
//        registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
//    }
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.clear();
//        converters.add(fastJson2HttpMessageConverter);
//    }
}
