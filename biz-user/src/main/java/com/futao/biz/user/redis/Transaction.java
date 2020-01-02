package com.futao.biz.user.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 事物-保证被包裹的命令不被其他客户端打断
 * <p>
 * #multi() Mark the start of a transaction block. <br>
 * * Commands will be queued and can then be executed by calling {@link #exec()} or rolled back using {@link #discard()}
 * <p>
 * /--------/
 * todo 没有实现效果-尝试启动了两个springboot应用也不行
 * /-------/
 *
 * @author futao
 * @date 2020/1/2.
 */
@Slf4j
@Component
public class Transaction implements ApplicationRunner {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY = "transaction-key";

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        new Thread(this::useRedisTransaction).start();
        new Thread(this::otherClient).start();
    }

    private void useRedisTransaction() {
        //开启redis事物
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        try {
            Thread.sleep(5000L);
            redisTemplate.opsForValue().set(KEY, "vvvvvvvv");
        } catch (InterruptedException e) {
            //回滚
            redisTemplate.discard();
            return;
        }
        redisTemplate.exec();
    }

    private void otherClient() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("尝试操作redis资源....");
        log.info("result:[{}]", redisTemplate.opsForValue().get(KEY));
    }
}
