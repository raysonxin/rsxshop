package com.rsxshop.rsx.sod.base.common.exception;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @className: BizErrorEnum.java
 * @author: raysonxin
 * @date: 2020/1/9 1:00 下午
 * @email: raysonxin@163.com
 * @description: 业务异常枚举，通过不同的枚举值定义不同的错误，编码规范：
 *               编码前两位定义为子系统编码，第三位为模块代码，后三位为异常代码
 *               如：10-平台基础服务，1-后端服务模块，001-非法参数
 *
 **/
public enum BizErrorEnum implements BaseBizError {
    INVALID_PARAM(100000, "参数无效"),
    ILLEGAL_ARGUMENT(1000001, "非法参数"),
    ;

    /**
     * 业务异常代码
     */
    private final int code;

    /**
     * 业务异常描述
     */
    private final String desc;

    BizErrorEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * the map to hold all enum object
     */
    private static final Map<Integer, BizErrorEnum> ENUM_VALUES = new ConcurrentHashMap<>(values().length);

    static {
        for (BizErrorEnum bizErr : EnumSet.allOf(BizErrorEnum.class)) {
            ENUM_VALUES.put(bizErr.code, bizErr);
        }
    }

    public static BizErrorEnum get(Integer code) {
        return code == null ? null : ENUM_VALUES.get(code);
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
