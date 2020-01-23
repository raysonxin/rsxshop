package com.rsxshop.rsx.sod.base.common.exception;

public interface BaseBizError {

    /**
     * 获取错误编码
     * */
    int getCode();

    /**
     * 获取错误描述
     * */
    String getDesc();
}
