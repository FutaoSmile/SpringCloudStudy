package com.futao.biz.order.controller;

import com.futao.biz.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@RequestMapping("/order")
@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 下定
     */
    @PostMapping
    public void add(
            @RequestParam
                    Long amount
    ) {
        orderService.add(amount);
    }
}
