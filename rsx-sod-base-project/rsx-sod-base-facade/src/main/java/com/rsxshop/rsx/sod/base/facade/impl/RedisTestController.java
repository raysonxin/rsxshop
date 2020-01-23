package com.rsxshop.rsx.sod.base.facade.impl;

import com.rsxshop.rsx.sod.base.common.redis.RedisLock;
import com.rsxshop.rsx.sod.base.common.redis.RedisUtils;
import com.rsxshop.rsx.sod.base.common.redis.annotation.RedisMethodCache;
import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import com.rsxshop.rsx.sod.base.common.utils.ResponseUtils;
import com.rsxshop.rsx.sod.base.facade.vo.User;
import com.rsxshop.rsx.sod.base.service.IBaseSkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @className: RedisTest.java
 * @author: raysonxin
 * @date: 2020/1/20 3:07 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@Api(value = "redis api")
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    @Autowired
    private IBaseSkuService baseSkuService;

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "redis set test")
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public CommonResponse<Boolean> set(String key, String value) {
        redisUtils.set(key, value, 10L);
        return ResponseUtils.success(true);
    }

    @ApiOperation(value = "redis get test")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CommonResponse<User> get(String key) {

        User user = new User();
        user.setName("rayson");
        user.setAge(31);

        redisUtils.set(key, user);

        return ResponseUtils.success(redisUtils.get(key));
    }

    @RedisMethodCache(expire = 1000)
    @ApiOperation(value = "redis cache test")
    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    public CommonResponse<String> cache() {
        String result = baseSkuService.cacheMethod("abc");
        return ResponseUtils.success(result);
    }

    @ApiOperation(value = "redis cache test")
    @RequestMapping(value = "/lock", method = RequestMethod.GET)
    public CommonResponse<Boolean> lock() throws InterruptedException {

        RedisLock redisLock = new RedisLock(redisUtils.getRedisTemplate().getConnectionFactory(), "redis:lock:key", 30 * 1000);
        boolean done = redisLock.lock(5000);
        return ResponseUtils.success(done);
    }
}
