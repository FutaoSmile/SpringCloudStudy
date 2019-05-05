package com.futao.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;

    /**
     * 同步调用
     * 如果被调用的微服务发生异常将触发服务降级(可使用ignoreExceptions进行排除)
     *
     * @param words
     * @return
     */
    @HystrixCommand(fallbackMethod = "hyError", ignoreExceptions = NullPointerException.class)
    public String say(String words) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/hello/say/{1}", String.class, words);
    }

    public String hyError(String words, Throwable e) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + e.getMessage());
        e.printStackTrace();
        return "触发服务降级" + words;
    }


    /**
     * 异步调用
     *
     * @param words
     * @return
     */
    public Future<String> saySync(String words) {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://EUREKA-PROVIDER/hello/say/{1}", String.class, words);
            }
        };
    }

}
