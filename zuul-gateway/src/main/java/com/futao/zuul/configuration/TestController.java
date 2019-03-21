package com.futao.zuul.configuration;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * Created on 2019-03-21.
 */
@Api
@RestController("test")
public class TestController {

    @RequestMapping("test")
    public void test(){
        
    }
}
