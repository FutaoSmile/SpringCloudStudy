package com.futao.serviceribbon.controller;

import com.futao.serviceribbon.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@Api("测试")
@RestController
@RequestMapping("hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @ApiOperation("测试method")
    @GetMapping("say/{words}")
    public String say(@PathVariable String words) {
        return helloService.say(words);
    }
}
