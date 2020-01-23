package com.rsxshop.rsx.sod.base.common.utils;

import java.io.Serializable;

/**
 * @className: CommonResponse.java
 * @author: raysonxin
 * @date: 2020/1/9 2:55 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = 2222706187123548979L;

    public CommonResponse() {
    }

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResponse(int code, String msg, T data) {
        this(code, msg);
        this.data = data;
    }

    private int code;
    private String msg = "";
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
