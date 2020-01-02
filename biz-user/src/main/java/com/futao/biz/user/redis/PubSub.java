package com.futao.biz.user.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * redis发布订阅
 * <p>
 * /-----------------------------------------------------------------------------------------/
 * /    订阅者sub负责订阅listener频道channel，发布者pub负责向频道channel发送二进制字符串消息        /
 * /    每当有消息被发送到执行频道时，频道的所有订阅者都会收到消息                                  /
 * /-----------------------------------------------------------------------------------------/
 *
 * @author futao
 * @date 2020/1/2.
 */
@Slf4j
@RestController
@RequestMapping("/pubSub")
@Configuration
public class PubSub extends MessageListenerAdapter {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Bean
    public RedisMessageListenerContainer pub(RedisConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer messageListenerContainer = new RedisMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.addMessageListener(listenerAdapter, new PatternTopic("redis-ps-topic-1"));
        messageListenerContainer.addMessageListener(listenerAdapter, new PatternTopic("redis-ps-topic-2"));
        messageListenerContainer.addMessageListener(listenerAdapter, new PatternTopic("redis-ps-topic-3"));
        messageListenerContainer.removeMessageListener(listenerAdapter, new PatternTopic("rPsT1"));
        return messageListenerContainer;
    }

//    @Bean
//    public MessageListenerAdapter messageListenerAdapter() {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter();
//        DefaultMessage defaultMessage = new DefaultMessage();
//        byte[] pattern = new byte[]; messageListenerAdapter.onMessage(defaultMessage, pattern);
//    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("channel为：[{}]", new String(message.getChannel(), StandardCharsets.UTF_8));
        log.info("消息体为:[{}]", new String(message.getBody(), StandardCharsets.UTF_8));
        log.info("pattern为:[{}]", new String(pattern, StandardCharsets.UTF_8));
        System.out.println("-------");
    }


    @PostMapping("/send")
    public void sendToRedis(
            @RequestParam("msg") String msg,
            @RequestParam("channel") String channel
    ) {
        redisTemplate.convertAndSend(channel, msg);
    }

}
