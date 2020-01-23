package com.rsxshop.rsx.sod.base.facade.config;

import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import com.rsxshop.rsx.sod.base.common.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @className: ControllerExceptionHandler.java
 * @author: raysonxin
 * @date: 2020/1/9 5:25 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse exceptionHandler(HttpServletRequest request, Exception exception) {
        String message = exception.getMessage();
        log.error("ControllerExceptionHandler-exceptionHandler():", exception);
        return ResponseUtils.error(message);
    }

}
