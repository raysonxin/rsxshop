package com.rsxshop.rsx.sod.base.common.utils;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @className: LogbackUtils.java
 * @author: raysonxin
 * @date: 2020/2/23 11:04 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class LogbackUtils {

    public static final String TRACE_ID = "TRACE-ID";

    public LogbackUtils() {
    }

    public static boolean insertMDC(String uniqueId) {
        MDC.put(TRACE_ID, uniqueId);
        return true;
    }

    public static final String generateTraceId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    public static final String getOrDefaultMDC() {
        String traceId = MDC.get(TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            traceId = generateTraceId();
            insertMDC(traceId);
        }
        return traceId;
    }

}
