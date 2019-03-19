package com.futao.eurekaprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@RestController
@RequestMapping(path = "hello")
public class HelloController {


    @Value("${server.port}")
    String port;

    /**
     * @param words
     * @return
     */
    @GetMapping("say/{words}")
    public String say(@PathVariable String words) {
        return String.format("你好 %s! I am %s", words, port);
    }
}
