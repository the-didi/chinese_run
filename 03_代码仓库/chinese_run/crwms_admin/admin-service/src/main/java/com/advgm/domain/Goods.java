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
 * @author 袁鹏
 * @date 2022年04月30日 17:49
 */
@ApiModel(value = "com-advgm-domain-goods")
@TableName(value = "cr_goods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    /**
     * 主键
     */
    @TableId(value = "id" ,type= IdType.AUTO)
    @ApiModelProperty(value = "商品id")
    private Long id;
    /**
     * 商品名称
     */
    @TableField(value = "g_name")
    @ApiModelProperty(value = "商品名称")
    private String name;
    /**
     * 商品类型
     */
    @TableField(value = "g_type")
    @ApiModelProperty(value = "商品类型")
    private String type;
    /**
     * 入库时间
     */
    @TableField(value = "in_time")
    @ApiModelProperty(value = "入库时间")
    private Date inTime;
    /**
     * 生产时间
     */
    @TableField(value = "pro_time")
    @ApiModelProperty(value = "生产时间")
    private Date proTime;
    /**
     * 过期时间
     */
    @TableField(value = "brun_id")
    @ApiModelProperty(value = "过期时间")
    private Date burnTime;
    /**
     * 所属仓库编号
     */
    @TableField(value = "w_id")
    @ApiModelProperty(value = "所属仓库id")
    private Long WId;
}