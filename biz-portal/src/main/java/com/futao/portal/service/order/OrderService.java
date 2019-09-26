package com.futao.portal.service.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@Service
@FeignClient(name = "biz-order")
public interface OrderService {
    @PostMapping("/order")
    void add(@RequestParam Long amount);
}
