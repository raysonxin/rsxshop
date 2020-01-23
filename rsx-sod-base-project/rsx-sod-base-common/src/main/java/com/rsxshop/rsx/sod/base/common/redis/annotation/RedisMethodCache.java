package com.rsxshop.rsx.sod.base.common.redis.annotation;

import java.lang.annotation.*;

/**
 * @className: RedisMethodCache.java
 * @author: raysonxin
 * @date: 2020/1/21 9:54 上午
 * @email: raysonxin@163.com
 * @description: 注解，方法缓存。
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisMethodCache {
    int expire() default 60;
}
