package com.rsxshop.rsx.sod.base.common.utils;

/**
 * @className: RsxExceptionHandler.java
 * @author: raysonxin
 * @date: 2020/1/9 6:05 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class RsxExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        System.out.println(t.getName() + "-" + e.getStackTrace());
    }
}
