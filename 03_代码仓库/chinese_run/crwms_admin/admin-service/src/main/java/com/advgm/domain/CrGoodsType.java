package com.advgm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 商品类型表
    */
@ApiModel(value="商品类型表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_goods_type")
public class CrGoodsType implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private String id;

    /**
     * 创建人名称
     */
    @TableField(value = "create_name")
    @ApiModelProperty(value="创建人名称")
    private String createName;

    /**
     * 创建人登录名称
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建人登录名称")
    private String createBy;

    /**
     * 创建日期
     */
    @TableField(value = "create_date")
    @ApiModelProperty(value="创建日期")
    private Date createDate;

    /**
     * 更新人名称
     */
    @TableField(value = "update_name")
    @ApiModelProperty(value="更新人名称")
    private String updateName;

    /**
     * 更新人登录名称
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新人登录名称")
    private String updateBy;

    /**
     * 更新日期
     */
    @TableField(value = "update_date")
    @ApiModelProperty(value="更新日期")
    private Date updateDate;

    /**
     * 所属部门
     */
    @TableField(value = "sys_org_code")
    @ApiModelProperty(value="所属部门")
    private String sysOrgCode;

    /**
     * 所属公司
     */
    @TableField(value = "sys_company_code")
    @ApiModelProperty(value="所属公司")
    private String sysCompanyCode;

    /**
     * 产品属性编码
     */
    @TableField(value = "goods_type_code")
    @ApiModelProperty(value="产品属性编码")
    private String goodsTypeCode;

    /**
     * 产品属性名称
     */
    @TableField(value = "goods_type_name")
    @ApiModelProperty(value="产品属性名称")
    private String goodsTypeName;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_NAME = "create_name";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_NAME = "update_name";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_SYS_ORG_CODE = "sys_org_code";

    public static final String COL_SYS_COMPANY_CODE = "sys_company_code";

    public static final String COL_GOODS_TYPE_CODE = "goods_type_code";

    public static final String COL_GOODS_TYPE_NAME = "goods_type_name";
}