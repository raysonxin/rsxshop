package com.rsxshop.rsx.sod.base.facade.impl;

import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import com.rsxshop.rsx.sod.base.common.utils.ResponseUtils;
import com.rsxshop.rsx.sod.base.dao.model.BaseSku;
import com.rsxshop.rsx.sod.base.facade.stub.BaseSkuFacade;
import com.rsxshop.rsx.sod.base.facade.vo.req.ReqBaseSkuVO;
import com.rsxshop.rsx.sod.base.facade.vo.resp.ResBaseSkuVO;
import com.rsxshop.rsx.sod.base.service.IBaseSkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseSkuFacadeImpl implements BaseSkuFacade {

    @Autowired
    private IBaseSkuService baseSkuService;

    @Override
    public CommonResponse<List<ResBaseSkuVO>> listBaseSku(String skuCode, String upc, String name) {
        List<BaseSku> skuList = baseSkuService.querySku(skuCode, upc, name);
        if (CollectionUtils.isEmpty(skuList)) {
            return ResponseUtils.success(new ArrayList<>());
        }

        List<ResBaseSkuVO> baseSkuVOS = new ArrayList<>();
        for (BaseSku sku : skuList) {
            ResBaseSkuVO vo = new ResBaseSkuVO();
            BeanUtils.copyProperties(sku, vo);
            baseSkuVOS.add(vo);
        }
        return ResponseUtils.success(baseSkuVOS);
    }

    @Override
    public CommonResponse<Boolean> createBaseSku(ReqBaseSkuVO reqBaseSkuVO) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> updateBaseSku(ReqBaseSkuVO reqBaseSkuVO) {
        return null;
    }

    @Override
    public CommonResponse<Boolean> enableBaseSku(Boolean enable, List<String> skuCodes) {
        return null;
    }
}
