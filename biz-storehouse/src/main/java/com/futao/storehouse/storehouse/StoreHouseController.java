package com.futao.storehouse.storehouse;

import com.futao.storehouse.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@RequestMapping("/storeHouse")
@RestController
public class StoreHouseController {


    @Autowired
    private StoreHouseService storeHouseService;

    /**
     * 减库存
     */
    @PutMapping
    public void decrement(
            @RequestParam
                    int id

    ) {
        storeHouseService.decrement(id);
    }
}
