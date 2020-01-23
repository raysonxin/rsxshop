package com.rsxshop.rsx.sod.base.facade.impl;

import org.springframework.scheduling.annotation.Async;

/**
 * @className: Test.java
 * @author: raysonxin
 * @date: 2020/1/9 6:09 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class Test {

    //@Async
    public void testException() {
        System.out.println(3 / 0);
    }

}
