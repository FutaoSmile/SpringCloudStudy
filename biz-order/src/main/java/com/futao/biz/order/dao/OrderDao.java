package com.futao.biz.order.dao;

import com.futao.biz.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author futao
 * Created on 2019/9/26.
 */
public interface OrderDao extends JpaRepository<OrderEntity, Long> {
}
