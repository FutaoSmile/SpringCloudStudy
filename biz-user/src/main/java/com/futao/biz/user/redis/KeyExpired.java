package com.futao.biz.user.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.nio.charset.StandardCharsets;

/**
 * 监听redis的过期事件
 *
 * @author futao
 * @date 2020/1/3.
 */
@Slf4j
@Configuration
public class KeyExpired extends KeyExpirationEventMessageListener {
    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     *
     * @param listenerContainer must not be {@literal null}.
     */
    public KeyExpired(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("监听key过期-channel为：[{}]", new String(message.getChannel(), StandardCharsets.UTF_8));
        log.info("监听key过期-消息体为:[{}]", new String(message.getBody(), StandardCharsets.UTF_8));
        log.info("监听key过期-pattern为:[{}]", new String(pattern, StandardCharsets.UTF_8));
        System.out.println("-------");
    }
}
