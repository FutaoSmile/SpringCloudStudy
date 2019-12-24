package com.futao.biz.order.service.impl;

import com.futao.biz.order.dao.OrderDao;
import com.futao.biz.order.service.OrderService;
import com.futao.biz.order.entity.OrderEntity;
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
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public void add(Long amount) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAmount(amount);
        orderEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        orderEntity.setStatus(1);
        orderDao.save(orderEntity);
        log.info("订单生成成功");
    }
}
