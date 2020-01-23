package com.rsxshop.rsx.sod.base.facade.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @className: User.java
 * @author: raysonxin
 * @date: 2020/1/20 7:51 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@Data
@ApiModel
public class User {
    private String name;
    private Integer age;
}
