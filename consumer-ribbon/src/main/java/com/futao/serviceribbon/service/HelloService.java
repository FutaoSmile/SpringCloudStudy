package com.futao.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@Service
public class HelloService {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hyError")
    public String say(String words) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/hello/say/" + words, String.class);
    }

    public String hyError(String words) {
        return "error happend" + words;
    }

}
