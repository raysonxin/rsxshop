package com.rsxshop.rsx.sod.base.facade.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @className: LogAspect.java
 * @author: raysonxin
 * @date: 2020/1/10 3:17 下午
 * @email: raysonxin@163.com
 * @description: 为包com.rsxshop.rsx.sod.base.facade.impl下所有的公共接口增加日志
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.rsxshop.rsx.sod.base.facade.impl..*.*(..))")
    public void invoke() {
    }

    @Around(value = "invoke()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = className + "-" + method.getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {
            long start = System.currentTimeMillis();
            log.info("请求方法：{},请求参数：{}", methodName, args);
            proceed = proceedingJoinPoint.proceed();
            log.info("请求方法：{},参数：{}，结果：{}，时长：{}毫秒", methodName, args, proceed, System.currentTimeMillis() - start);
        } catch (Throwable throwable) {
            log.error("请求方法：{}发生异常", methodName, throwable);
        }
        return proceed;
    }
}
