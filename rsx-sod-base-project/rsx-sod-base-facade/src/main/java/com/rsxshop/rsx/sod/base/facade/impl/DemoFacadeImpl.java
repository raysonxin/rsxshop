package com.rsxshop.rsx.sod.base.facade.impl;

import com.rsxshop.rsx.sod.base.common.exception.BizErrorEnum;
import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import com.rsxshop.rsx.sod.base.common.utils.ResponseUtils;
import com.rsxshop.rsx.sod.base.facade.stub.DemoFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: DemoFacadeImpl.java
 * @author: raysonxin
 * @date: 2020/1/9 4:59 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@RestController
@Slf4j
public class DemoFacadeImpl implements DemoFacade {
    @Override
    public CommonResponse success() {
        return ResponseUtils.success();
    }

    @Override
    public CommonResponse error() {
        return ResponseUtils.error();
    }

    @Override
    public CommonResponse bizError() {
        return ResponseUtils.error(BizErrorEnum.INVALID_PARAM);
    }

    @Override
    public CommonResponse exception() throws Exception {
        throw new Exception("Test Exception");
    }

    @Override
    public CommonResponse concurrentException() {
        Runnable r = () -> {
            System.out.println(3 / 0);
        };
        Thread t = new Thread(r);
        t.start();

        //ThreadLocal
        return ResponseUtils.success();
    }
}
