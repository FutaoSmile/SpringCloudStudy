package com.futao.storehouse.service.impl;

import com.futao.storehouse.dao.StoreHouseDao;
import com.futao.storehouse.entity.StoreHouseEntity;
import com.futao.storehouse.service.StoreHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @author futao
 * Created on 2019/9/26.
 */
@Slf4j
//@Transactional(rollbackFor = Exception.class)
@Service
public class StoreHouseServiceImpl implements StoreHouseService {

    @Autowired
    private StoreHouseDao storeHouseDao;

    @Override
    public void decrement(int id) {
        StoreHouseEntity houseDaoOne = storeHouseDao.getOne((long) id);
        if (houseDaoOne == null) {
            throw new RuntimeException("库存信不存在");
        }
        houseDaoOne.setLast(houseDaoOne.getLast() - 1);
        houseDaoOne.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        storeHouseDao.save(houseDaoOne);
        log.info("库存扣除成功");
    }
}
