package com.futao.portal.controller;

import com.futao.portal.service.order.OrderService;
import com.futao.portal.service.storehouse.StoreHouseService;
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

    @Autowired
    private StoreHouseService storeHouseService;

    /**
     * 下定
     */
    @PostMapping
    public void add(
            @RequestParam
                    Long amount,
            @RequestParam
                    int storeId
    ) {
        orderService.add(amount);
        storeHouseService.decremtn(storeId);
    }
}
