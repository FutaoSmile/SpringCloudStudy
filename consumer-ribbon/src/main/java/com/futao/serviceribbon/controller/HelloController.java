package com.futao.serviceribbon.controller;

import com.futao.serviceribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("say/{words}")
    public String say(@PathVariable String words) {
        return helloService.say(words);
    }
}
