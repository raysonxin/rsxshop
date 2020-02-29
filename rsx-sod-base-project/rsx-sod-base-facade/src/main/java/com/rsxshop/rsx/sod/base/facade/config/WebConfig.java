package com.rsxshop.rsx.sod.base.facade.config;

import com.rsxshop.rsx.sod.base.common.filter.LogbackFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: WebConfig.java
 * @author: raysonxin
 * @date: 2020/2/23 11:14 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@Configuration
public class WebConfig {
    public WebConfig() {
    }

    @Bean
    public FilterRegistrationBean logbackFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new LogbackFilter(), new ServletRegistrationBean[0]);
        registrationBean.addUrlPatterns(new String[]{"/*"});
        registrationBean.setName("logbackFilter");
        return registrationBean;
    }
}
