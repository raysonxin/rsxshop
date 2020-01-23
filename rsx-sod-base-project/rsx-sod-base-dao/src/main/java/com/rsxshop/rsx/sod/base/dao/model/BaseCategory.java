package com.rsxshop.rsx.sod.base.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类信息表
 * </p>
 *
 * @author raysonxin
 * @since 2020-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类编码
     */
    private String catCode;

    /**
     * 分类名称
     */
    private String catName;

    /**
     * 分类logo
     */
    private String catLogo;

    /**
     * 上级分类编码，空代表无上级
     */
    private String parentCode;

    /**
     * 排序序号，范围1-99
     */
    private Integer sortOrder;

    /**
     * 层级，对照枚举表
     */
    private Integer level;

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
     * 是否删除：0-否，1-是
     */
    private Boolean isDelete;


}
