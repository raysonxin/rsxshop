package com.rsxshop.rsx.sod.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rsxshop.rsx.sod.base.common.redis.annotation.RedisMethodCache;
import com.rsxshop.rsx.sod.base.dao.model.BaseSku;
import com.rsxshop.rsx.sod.base.dao.mapper.BaseSkuDao;
import com.rsxshop.rsx.sod.base.service.IBaseSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * sku信息表 服务实现类
 * </p>
 *
 * @author raysonxin
 * @since 2020-01-07
 */
@Service
@Slf4j
public class BaseSkuServiceImpl extends ServiceImpl<BaseSkuDao, BaseSku> implements IBaseSkuService {


    @Override
    public List<BaseSku> querySku(String code, String upc, String name) {
        QueryWrapper<BaseSku> wrapper = new QueryWrapper<>();
        wrapper.eq(!StringUtils.isEmpty(code), "sku_code", code)        //sku_code 精确匹配
                .eq(!StringUtils.isEmpty(upc), "upc", upc)              //upc 精确匹配
                .like(!StringUtils.isEmpty(name), "sku_name", name)     //sku_name 模糊匹配
                .last("limit 10");                                      //最多返回10条

        log.info("querySku:here");
        List<BaseSku> skuList = baseMapper.selectList(wrapper);
        return skuList;
    }

    @RedisMethodCache(expire = 100)
    public String cacheMethod(String key) {
        return null;
        //return UUID.randomUUID().toString();
    }
}
