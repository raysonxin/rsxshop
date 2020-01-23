package com.rsxshop.rsx.sod.base.common.utils;

import com.rsxshop.rsx.sod.base.common.exception.BaseBizError;

/**
 * @className: ResponseUtils.java
 * @author: raysonxin
 * @date: 2020/1/9 3:26 下午
 * @email: raysonxin@163.com
 * @description: 封装通用消息响应
 **/
public class ResponseUtils {

    private static final int CODE_SUCCESS = 200000;
    private static final int CODE_SYSTEM_ERROR = 500000;

    private static final CommonResponse RESPONSE_SUCCESS = new CommonResponse<>(CODE_SUCCESS, "success");
    private static final CommonResponse RESPONSE_SYSTEM_ERROR = new CommonResponse<>(CODE_SYSTEM_ERROR, "system error");

    /**
     * 响应成功，无数据
     */
    public static <T> CommonResponse<T> success() {
        return RESPONSE_SUCCESS;
    }

    /**
     * 响应成功，有数据
     *
     * @param data 数据内容
     */
    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(CODE_SUCCESS, "success", data);
    }

    /**
     * 响应失败
     * */
    public static <T> CommonResponse<T> error() {
        return RESPONSE_SYSTEM_ERROR;
    }

    public static <T> CommonResponse<T> error(String msg) {
        return new CommonResponse<>(CODE_SYSTEM_ERROR, msg);
    }

    public static <T> CommonResponse<T> error(BaseBizError bizError) {
        return new CommonResponse<>(bizError.getCode(), bizError.getDesc());
    }
}
