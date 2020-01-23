package com.rsxshop.rsx.sod.base.facade.stub;

import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @className: DemoFacade.java
 * @author: raysonxin
 * @date: 2020/1/9 4:58 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@Api(description = "Demo接口")
@RequestMapping("/demo")
public interface DemoFacade {

    @ApiOperation(value = "success接口")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    CommonResponse success();

    @ApiOperation(value = "success接口")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    CommonResponse error();

    @ApiOperation(value = "bizError接口")
    @RequestMapping(value = "/biz", method = RequestMethod.GET)
    CommonResponse bizError();

    @ApiOperation(value = "exception接口")
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    CommonResponse exception() throws Exception;

    @ApiOperation(value = "多线程异常测试")
    @RequestMapping(value = "/concException", method = RequestMethod.GET)
    CommonResponse concurrentException();
}
