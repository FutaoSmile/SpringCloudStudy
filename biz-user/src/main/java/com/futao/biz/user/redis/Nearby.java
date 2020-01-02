package com.futao.biz.user.redis;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * redis实现附近的人
 *
 * @author futao
 * @date 2019/12/30.
 */
@RequestMapping("/nearby")
@RestController
@Service
public class Nearby {

    private static final String STRING = "geo-1";


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 上传位置
     *
     * @param x
     * @param y
     * @param userId
     * @return
     */
    @PostMapping("/uploadPosition")
    public Long uploadPosition(
            @RequestParam("x") double x,
            @RequestParam("y") double y,
            @RequestParam("userId") String userId
    ) {
        Long add = redisTemplate.opsForGeo().add(STRING, new Point(x, y), userId);
        System.out.println("addValue:" + add);
        return add;
    }


    /**
     * 计算距离
     *
     * @param userId1
     * @param userId2
     */
    @GetMapping("/distance")
    public void nearby(
            @RequestParam("userId1") String userId1,
            @RequestParam("userId2") String userId2
    ) {
        Distance distance = redisTemplate.opsForGeo().distance(STRING, userId1, userId2);
        Distance distance1 = redisTemplate.opsForGeo().distance(STRING, userId1, userId2, Metrics.MILES);
    }


    /**
     * 查询附近的人
     *
     * @param currentUserId
     * @param meter
     * @param size
     */
    @GetMapping("/nearby")
    public void nearby(
            @RequestParam("currentUserId") String currentUserId,
            @RequestParam("meter") int meter,
            @RequestParam("size") long size
    ) {
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        args.limit(size);
        args.sortAscending();
        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(STRING, currentUserId, new Distance(meter, Metrics.NEUTRAL), args);
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> content = radius.getContent();
        for (GeoResult<RedisGeoCommands.GeoLocation<String>> geoLocationGeoResult : content) {
            RedisGeoCommands.@NonNull GeoLocation<String> content1 = geoLocationGeoResult.getContent();
            System.out.println("content1.getName:[{}]" + content1.getName());
            System.out.println(content1.getPoint());
        }
    }

}
