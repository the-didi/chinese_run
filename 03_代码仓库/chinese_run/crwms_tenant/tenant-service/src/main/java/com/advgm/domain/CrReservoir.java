package com.advgm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 库区
 */
@ApiModel(value="com-advgm-domain-CrReservoir")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_reservoir")
public class CrReservoir {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;


    /**
     * 租户编码
     */
    @TableField(value = "tenant_no")
    @ApiModelProperty(value = "租户编码")
    private String tenantNo;

    /**
     * 库区编码
     */
    @TableField(value = "rs_code")
    @ApiModelProperty(value = "库区编码")
    private String rsCode;

    /**
     * 库区名称
     */
    @TableField(value = "rs_name")
    @ApiModelProperty(value = "库区名称")
    private String rsName;

    /**
     * 库区描述
     */
    @TableField(value = "rs_desc")
    @ApiModelProperty(value = "库区描述")
    private String rsDesc;

    /**
     * 库区类型
     */
    @TableField(value = "rs_type")
    @ApiModelProperty(value = "库区描述")
    private Integer rsType;


    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建人")
    private Long createBy;

    /**
     * 修改人
     */
    @TableField(value = "modify_by")
    @ApiModelProperty(value="修改人")
    private Long modifyBy;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    @ApiModelProperty(value="创建时间")
    private Date created;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time")
    @ApiModelProperty(value="修改时间")
    private Date lastUpdateTime;
}
