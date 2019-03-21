package com.futao.consumerfeign.controller;

import com.futao.consumerfeign.service.HelloService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@Api
@RestController
@RequestMapping(path = "hello")
public class HelloController {


    @Resource
    private HelloService helloService;

    /**
     * @param words
     * @return
     */
    @GetMapping("say/{words}")
    public String say(@PathVariable String words) {
        return helloService.say(words);
    }
}