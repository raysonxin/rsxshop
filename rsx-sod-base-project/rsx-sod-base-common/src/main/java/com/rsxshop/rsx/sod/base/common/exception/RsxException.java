package com.rsxshop.rsx.sod.base.common.exception;

public class RsxException extends RuntimeException {

    /**
     * Override serialVersionUID
     */
    private static final long serialVersionUID = 8992815120994457281L;

    /**
     * exception description
     */
    private String msg;

    /**
     * the code for custom business exception
     */
    private int code = 500000;

    public RsxException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RsxException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RsxException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RsxException(int code, String msg, Throwable e) {
        super(msg, e);
        this.code = code;
        this.msg = msg;
    }

    public RsxException(BaseBizError bizError) {
        super(bizError.getDesc());
        this.code = bizError.getCode();
        this.msg = bizError.getDesc();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
