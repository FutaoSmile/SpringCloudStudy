package com.futao.common.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author futao
 * Created on 2019/12/9.
 */
@Component
public class MybatisHandler implements MetaObjectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisHandler.class);

    // TODO: 2019/12/27 获取当前登录的用户主键

    @Override
    public void insertFill(MetaObject metaObject) {
        LOGGER.debug("insert操作时自动设置创建时间(人)与更新时间(人)");
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.setFieldValByName("createDateTime", now, metaObject);
        this.setFieldValByName("createBy", "creator", metaObject);

        this.setFieldValByName("updateDateTime", now, metaObject);
        this.setFieldValByName("updateBy", "creator", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        LOGGER.debug("update自动设置更新时间(人)");
        this.setFieldValByName("updateDateTime", new Timestamp(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("updateBy", "updater", metaObject);
    }
}
