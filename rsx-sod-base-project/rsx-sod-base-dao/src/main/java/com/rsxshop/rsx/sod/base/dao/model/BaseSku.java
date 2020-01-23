package com.rsxshop.rsx.sod.base.dao.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * sku信息表
 * </p>
 *
 * @author raysonxin
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 来源类型：1-标品，2-非标，3-组合
     */
    private Integer sourceType;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 商品条码/UPC
     */
    private String upc;

    /**
     * sku主图
     * */
    private String mainImage;

    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 毛重，默认单位：kg
     */
    private BigDecimal grossWeight;

    /**
     * 商品规格
     */
    private String specs;

    /**
     * 商品单位，如：份
     */
    private String unit;

    /**
     * 产地
     */
    private String originPlace;

    /**
     * 保质期
     */
    private String shelfLife;

    /**
     * 储藏方式
     */
    private String storageWay;

    /**
     * 长，单位：mm
     */
    private Integer length;

    /**
     * 宽，单位：mm
     */
    private Integer width;

    /**
     * 高，单位：mm
     */
    private Integer height;

    /**
     * 启用状态：0-禁用，1-启用，默认1-启用
     */
    private Boolean enabled;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 修改人
     */
    private String updatedBy;

    /**
     * 逻辑删除，0-否，1-是
     */
    private Boolean isDelete;


}
