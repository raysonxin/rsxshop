package com.rsxshop.rsx.sod.base.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @className: RedisUtils.java
 * @author: raysonxin
 * @date: 2020/1/20 3:08 下午
 * @email: raysonxin@163.com
 * @description: 封装一些常用的操作
 **/
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    public RedisUtils() {
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void set(String key, Object value) {
        this.set(key, value, -1L);
    }

    public void set(String key, Object value, long expire) {
        if (expire != -1L) {
            this.valueOperations.set(key, value, expire, TimeUnit.SECONDS);
        } else {
            this.valueOperations.set(key, value);
        }
    }

    public <T> T get(String key) {
        Object obj = this.valueOperations.get(key);
        return obj == null ? null : (T) obj;
    }

    public void expire(String key, long time, TimeUnit timeUnit) {
        this.redisTemplate.expire(key, time, timeUnit);
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return this.redisTemplate;
    }
}
