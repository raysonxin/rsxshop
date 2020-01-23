package com.rsxshop.rsx.sod.base.common.redis.aspect;

import com.rsxshop.rsx.sod.base.common.redis.RedisUtils;
import com.rsxshop.rsx.sod.base.common.redis.annotation.RedisMethodCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @className: RedisMethodAspect.java
 * @author: raysonxin
 * @date: 2020/1/21 10:15 上午
 * @email: raysonxin@163.com
 * @description: 方法缓存切面
 **/
@Component
@Aspect
@Slf4j
public class RedisMethodAspect {
    @Autowired
    private RedisUtils redisUtils;

    public RedisMethodAspect() {
    }

    @Pointcut("@annotation(com.rsxshop.rsx.sod.base.common.redis.annotation.RedisMethodCache)")
    private void invoke() {
    }

    @Around("invoke()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取类型信息：类型、类名
        Class<?> classTarget = joinPoint.getTarget().getClass();
        String className = classTarget.getName();

        //获取方法信息：名称、参数类型、参数
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        Class<?>[] argsType = signature.getParameterTypes();
        Object[] args = joinPoint.getArgs();

        //获取方法注解中超时参数expire
        Method method = classTarget.getMethod(methodName, argsType);
        RedisMethodCache annotation = method.getAnnotation(RedisMethodCache.class);
        int expire = annotation.expire();

        //构建redis的key
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            sb.append("_").append(arg);
        }
        String methodCacheKey = className.concat("_").concat(methodName).concat(sb.toString());

        Object cacheResult = redisUtils.get(methodCacheKey);
        if (cacheResult != null) {
            return cacheResult;
        }

        Object result = joinPoint.proceed();
        try {
            redisUtils.set(methodCacheKey, result, expire);
        } catch (Exception ex) {
            log.error("RedisMethodAspect, {}", methodCacheKey, ex);
        }
        return result;
    }
}
