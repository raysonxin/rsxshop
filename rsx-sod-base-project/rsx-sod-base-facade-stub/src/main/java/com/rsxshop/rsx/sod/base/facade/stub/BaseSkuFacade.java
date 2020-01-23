package com.rsxshop.rsx.sod.base.facade.stub;

import com.rsxshop.rsx.sod.base.common.utils.CommonResponse;
import com.rsxshop.rsx.sod.base.facade.vo.req.ReqBaseSkuVO;
import com.rsxshop.rsx.sod.base.facade.vo.resp.ResBaseSkuVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@Api(description = "BaseSkuFacade")
@RequestMapping("/sku")
public interface BaseSkuFacade {

    /**
     * 根据条件查询sku列表（最多十条）
     *
     * @param skuCode sku编码，精确
     * @param upc     upc编码，精确
     * @param name    sku名称，模糊
     */
    @ApiOperation(value = "按照条件查询sku列表（最多10条）", notes = "支持多个条件查询（sku编码、sku名称模糊、upc等），最多返回10条命中记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "skuCode", value = "sku编码（精确）", required = false, dataType = "String"),
            @ApiImplicitParam(name = "upc", value = "upc编码（精确）", required = false, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "sku名称（模糊）", required = false, dataType = "String")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    CommonResponse<List<ResBaseSkuVO>> listBaseSku(
            @RequestParam(required = false) String skuCode,
            @RequestParam(required = false) String upc,
            @RequestParam(required = false) String name
    );

    @ApiOperation(value = "添加sku", notes = "添加sku，默认创建时间和更新时间")
    @ApiImplicitParam(name = "reqBaseSkuVO", value = "sku实体结构", required = true, dataType = "ReqBaseSkuVO")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    CommonResponse<Boolean> createBaseSku(@RequestBody(required = true) ReqBaseSkuVO reqBaseSkuVO);

    @ApiOperation(value = "更新sku", notes = "更新sku，创建人与创建时间不可更新")
    @ApiImplicitParam(name = "reqBaseSkuVO", value = "sku实体结构", required = true, dataType = "ReqBaseSkuVO")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    CommonResponse<Boolean> updateBaseSku(@RequestBody(required = true) ReqBaseSkuVO reqBaseSkuVO);

    /**
     * 批量启用或禁用sku。禁用后将无法上架售卖，同时导致全局下架操作。启用后商品可以上架。
     *
     * @param enable   是否启用：true-启用，false-禁用
     * @param skuCodes sku编码列表
     */
    @ApiOperation(value = "批量启用或禁用sku", notes = "批量启用或禁用sku，该操作会引起sku向三方、es的同步")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "enable", value = "启用或禁用", required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "skuCodes", value = "sku列表编码", allowMultiple = true, required = true, dataType = "String")
    })
    @RequestMapping(value = "/enable", method = RequestMethod.POST)
    CommonResponse<Boolean> enableBaseSku(
            @RequestParam(required = true, defaultValue = "true") Boolean enable,
            @RequestBody(required = true) List<String> skuCodes
    );
}
