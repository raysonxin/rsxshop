package com.rsxshop.rsx.sod.base.common.filter;

import com.rsxshop.rsx.sod.base.common.utils.LogbackUtils;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * @className: LogbackFilter.java
 * @author: raysonxin
 * @date: 2020/2/23 11:08 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
public class LogbackFilter implements Filter {

    public LogbackFilter() {
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean hasMDC;
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            if (request.getRequestURI().contains("favicon.ico")) {
                return;
            }
            String traceId = (String) Optional.ofNullable(request.getHeader(LogbackUtils.TRACE_ID)).orElse(LogbackUtils.generateTraceId());
            hasMDC = LogbackUtils.insertMDC(traceId);
        } else {
            hasMDC = LogbackUtils.insertMDC(LogbackUtils.generateTraceId());
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            if (hasMDC) {
                MDC.remove(LogbackUtils.TRACE_ID);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
