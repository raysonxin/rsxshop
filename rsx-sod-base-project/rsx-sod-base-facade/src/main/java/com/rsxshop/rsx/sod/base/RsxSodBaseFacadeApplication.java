package com.rsxshop.rsx.sod.base;

import com.rsxshop.rsx.sod.base.common.utils.RsxExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@SpringBootApplication
@MapperScan("com.rsxshop.rsx.sod.base.dao.mapper")
@EnableAsync
public class RsxSodBaseFacadeApplication {
    public static void main(String[] args) {
        //Thread.setDefaultUncaughtExceptionHandler(new RsxExceptionHandler());
        SpringApplication.run(RsxSodBaseFacadeApplication.class, args);
    }

}
