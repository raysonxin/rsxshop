package com.rsxshop.rsx.sod.base.dao.mapper;

import com.rsxshop.rsx.sod.base.dao.model.BaseSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * sku信息表 Mapper 接口
 * </p>
 *
 * @author raysonxin
 * @since 2020-01-07
 */
@Repository
public interface BaseSkuDao extends BaseMapper<BaseSku> {

}
