package com.futao.consumerfeign.service.impl;

import com.futao.consumerfeign.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author futao
 * Created on 2019-03-19.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String words) {
        return "error happen" + words;
    }
}
