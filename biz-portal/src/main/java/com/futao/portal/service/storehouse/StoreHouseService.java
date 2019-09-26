package com.futao.portal.service.storehouse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@Service
@FeignClient("biz-storeHouse")
public interface StoreHouseService {
    @PutMapping("storeHouse")
    void decremtn(@RequestParam int id);
}
