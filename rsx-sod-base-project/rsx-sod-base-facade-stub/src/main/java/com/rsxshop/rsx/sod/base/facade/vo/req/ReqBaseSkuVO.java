package com.rsxshop.rsx.sod.base.facade.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @className: ReqBaseSkuVO.java
 * @author: raysonxin
 * @date: 2020/1/19 10:21 下午
 * @email: raysonxin@163.com
 * @description: TODO
 **/
@Data
@ApiModel(description = "创建或更新sku请求实体")
public class ReqBaseSkuVO implements Serializable {

    private static final long serialVersionUID = 3053695157831634308L;

    /**
     * 来源类型：1-标品，2-非标，3-组合
     */
    @NotBlank
    @ApiModelProperty(name = "sourceType",value = "1-标品，2-非标，3-组合")
    private Integer sourceType;

    /**
     * 商品名称
     */
    @NotBlank
    @ApiModelProperty(name = "skuName",value = "商品名称")
    private String skuName;

    /**
     * 副标题
     */
    @NotBlank
    @ApiModelProperty(name = "subtitle",value = "副标题")
    private String subtitle;

    /**
     * 商品编码
     */
    @ApiModelProperty(name = "skuCode",value = "商品编码")
    private String skuCode;

    /**
     * 商品条码/UPC
     */
    @ApiModelProperty(name = "upc",value = "商品条码/UPC")
    private String upc;

    /**
     * sku主图
     * */
    @ApiModelProperty(name = "mainImage",value = "sku主图url")
    private String mainImage;

    /**
     * 品牌ID
     */
    @ApiModelProperty(name = "brandId",value = "品牌ID")
    private Integer brandId;

    /**
     * 毛重，默认单位：kg
     */
    @ApiModelProperty(name = "grossWeight",value = "毛重，默认单位：kg")
    private BigDecimal grossWeight;

    /**
     * 商品规格
     */
    @ApiModelProperty(name = "specs",value = "商品规格")
    private String specs;

    /**
     * 商品单位，如：份
     */
    @ApiModelProperty(name = "unit",value = "商品单位，如：份")
    private String unit;

    /**
     * 产地
     */
    @ApiModelProperty(name = "originPlace",value = "产地")
    private String originPlace;

    /**
     * 保质期
     */
    @ApiModelProperty(name = "shelfLife",value = "保质期")
    private String shelfLife;

    /**
     * 储藏方式
     */
    @ApiModelProperty(name = "storageWay",value = "储藏方式")
    private String storageWay;

    /**
     * 长，单位：mm
     */
    @ApiModelProperty(name = "length",value = "长，单位：mm")
    private Integer length;

    /**
     * 宽，单位：mm
     */
    @ApiModelProperty(name = "width",value = "宽，单位：mm")
    private Integer width;

    /**
     * 高，单位：mm
     */
    @ApiModelProperty(name = "height",value = "高，单位：mm")
    private Integer height;

    /**
     * 启用状态：0-禁用，1-启用，默认1-启用
     */
    @ApiModelProperty(name = "enabled",value = "启用状态：0-禁用，1-启用，默认1-启用")
    private Boolean enabled;

//    /**
//     * 创建时间
//     */
//    @ApiModelProperty(name = "createdTime",value = "创建时间")
//    private LocalDateTime createdTime;

    /**
     * 创建人
     */
    @ApiModelProperty(name = "createdBy",value = "创建人")
    private String createdBy;

//    /**
//     * 更新时间
//     */
//    @ApiModelProperty(name = "updatedTime",value = "更新时间")
//    private LocalDateTime updatedTime;

    /**
     * 修改人
     */
    @ApiModelProperty(name = "updatedBy",value = "修改人")
    private String updatedBy;

    /**
     * 逻辑删除，0-否，1-是
     */
    @ApiModelProperty(name = "isDelete",value = "逻辑删除，0-否，1-是")
    private Boolean isDelete;


}
