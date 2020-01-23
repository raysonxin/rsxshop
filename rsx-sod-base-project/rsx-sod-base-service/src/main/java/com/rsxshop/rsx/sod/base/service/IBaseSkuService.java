package com.rsxshop.rsx.sod.base.service;

import com.rsxshop.rsx.sod.base.dao.model.BaseSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * sku信息表 服务类
 * </p>
 *
 * @author raysonxin
 * @since 2020-01-07
 */
public interface IBaseSkuService extends IService<BaseSku> {
    List<BaseSku> querySku(String code, String upc,String name);
    String cacheMethod(String key);
}
