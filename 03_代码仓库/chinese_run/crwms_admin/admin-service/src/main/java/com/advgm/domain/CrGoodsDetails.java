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

@ApiModel(value="cr_wms.cr_goods_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_goods_details")
public class CrGoodsDetails implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 货主姓名
     */
    @TableField(value = "g_name")
    @ApiModelProperty(value="货主姓名")
    private String gName;

    /**
     * 商品编码
     */
    @TableField(value = "g_no")
    @ApiModelProperty(value="商品编码")
    private String gNo;

    /**
     * 商品SKU
     */
    @TableField(value = "g_SKU")
    @ApiModelProperty(value="商品SKU")
    private String gSku;

    /**
     * 品名
     */
    @TableField(value = "p_name")
    @ApiModelProperty(value="品名")
    private String pName;

    /**
     * 计费商品类
     */
    @TableField(value = "j_category")
    @ApiModelProperty(value="计费商品类")
    private String jCategory;

    /**
     * 单位
     */
    @TableField(value = "unit")
    @ApiModelProperty(value="单位")
    private String unit;

    /**
     * 存放温层
     */
    @TableField(value = "cunfangwencheng")
    @ApiModelProperty(value="存放温层")
    private String cunfangwencheng;

    /**
     * 单层
     */
    @TableField(value = "id_dangcheng")
    @ApiModelProperty(value="单层")
    private String idDangcheng;

    /**
     * 层高
     */
    @TableField(value = "height")
    @ApiModelProperty(value="层高")
    private Double height;

    /**
     * 保质期
     */
    @TableField(value = "baozhiqi")
    @ApiModelProperty(value="保质期")
    private Integer baozhiqi;

    /**
     * 体积
     */
    @TableField(value = "tiji")
    @ApiModelProperty(value="体积")
    private String tiji;

    /**
     * 重量
     */
    @TableField(value = "weight")
    @ApiModelProperty(value="重量")
    private String weight;

    /**
     * 折零数量
     */
    @TableField(value = "zl_number")
    @ApiModelProperty(value="折零数量")
    private Integer zlNumber;

    /**
     * 产品属性
     */
    @TableField(value = "g_property")
    @ApiModelProperty(value="产品属性")
    private String gProperty;

    /**
     * 基本单位
     */
    @TableField(value = "base_unit")
    @ApiModelProperty(value="基本单位")
    private String baseUnit;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
     * 租户id
     */
    @TableField(value = "telent_id")
    @ApiModelProperty(value="租户id")
    private Long telentId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 修改者
     */
    @TableField(value = "modify_by")
    @ApiModelProperty(value="修改者")
    private String modifyBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_G_NAME = "g_name";

    public static final String COL_G_NO = "g_no";

    public static final String COL_G_SKU = "g_SKU";

    public static final String COL_P_NAME = "p_name";

    public static final String COL_J_CATEGORY = "j_category";

    public static final String COL_UNIT = "unit";

    public static final String COL_CUNFANGWENCHENG = "cunfangwencheng";

    public static final String COL_ID_DANGCHENG = "id_dangcheng";

    public static final String COL_HEIGHT = "height";

    public static final String COL_BAOZHIQI = "baozhiqi";

    public static final String COL_TIJI = "tiji";

    public static final String COL_WEIGHT = "weight";

    public static final String COL_ZL_NUMBER = "zl_number";

    public static final String COL_G_PROPERTY = "g_property";

    public static final String COL_BASE_UNIT = "base_unit";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_TELENT_ID = "telent_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFY_BY = "modify_by";

    public static final String COL_UPDATE_TIME = "update_time";
}