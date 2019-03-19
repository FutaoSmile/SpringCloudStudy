package com.futao.consumerfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@FeignClient(value = "eureka-provider")
public interface HelloService {

    /**
     * @param words
     * @return
     */
    @GetMapping("hello/say/{words}")
    String say(@PathVariable String words);
}
