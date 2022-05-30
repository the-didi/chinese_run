package com.advgm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 基础商品
    */
@ApiModel(value="基础商品")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_base_goods")
public class CrBaseGoods implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Long id;

    @TableField(value = "g_name")
    @ApiModelProperty(value="")
    private String gName;

    @TableField(value = "e_name")
    @ApiModelProperty(value="")
    private String eName;

    @TableField(value = "g_no")
    @ApiModelProperty(value="")
    private String gNo;

    @TableField(value = "c_name")
    @ApiModelProperty(value="")
    private String cName;

    @TableField(value = "g_guige")
    @ApiModelProperty(value="")
    private String gGuige;

    @TableField(value = "g_category")
    @ApiModelProperty(value="")
    private String gCategory;

    @TableField(value = "zl")
    @ApiModelProperty(value="")
    private String zl;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_G_NAME = "g_name";

    public static final String COL_E_NAME = "e_name";

    public static final String COL_G_NO = "g_no";

    public static final String COL_C_NAME = "c_name";

    public static final String COL_G_GUIGE = "g_guige";

    public static final String COL_G_CATEGORY = "g_category";

    public static final String COL_ZL = "zl";
}