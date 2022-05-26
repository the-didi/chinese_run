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
    * 商品类目表
    */
@ApiModel(value="商品类目表")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_goods_category")
public class CrGoodsCategory implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;

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
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建日期")
    private Date createTime;

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
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新日期")
    private Date updateTime;

    /**
     * 所属部门
     */
    @TableField(value = "sys_org_code")
    @ApiModelProperty(value="所属部门")
    private String sysOrgCode;

    /**
     * 类目编码
     */
    @TableField(value = "category_code")
    @ApiModelProperty(value="类目编码")
    private String categoryCode;

    /**
     * 类目名称
     */
    @TableField(value = "category_name")
    @ApiModelProperty(value="类目名称")
    private String categoryName;

    /**
     * 类目级别
     */
    @TableField(value = "category_level")
    @ApiModelProperty(value="类目级别")
    private Integer categoryLevel;

    /**
     * 父级目录
     */
    @TableField(value = "pid")
    @ApiModelProperty(value="父级目录")
    private Integer pid;

    /**
     * 是否为顶级目录
     */
    @TableField(value = "top_node")
    @ApiModelProperty(value="是否为顶级目录")
    private String topNode;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_NAME = "create_name";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_NAME = "update_name";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_SYS_ORG_CODE = "sys_org_code";

    public static final String COL_CATEGORY_CODE = "category_code";

    public static final String COL_CATEGORY_NAME = "category_name";

    public static final String COL_CATEGORY_LEVEL = "category_level";

    public static final String COL_PID = "pid";

    public static final String COL_TOP_NODE = "top_node";
}