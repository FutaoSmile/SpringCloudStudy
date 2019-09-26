package com.futao.storehouse.dao;

import com.futao.storehouse.entity.StoreHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author futao
 * Created on 2019/9/26.
 */
public interface StoreHouseDao extends JpaRepository<StoreHouseEntity, Long> {
}
