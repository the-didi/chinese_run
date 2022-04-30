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

/**
 * @author 袁鹏
 * @date 2022年04月30日 17:50
 */
@ApiModel(value = "com-advgm-domain-orderStatus")
@TableName(value ="order_status" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 订单编号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value = "订单编号")
    private Long orderId;
    /**
     * 订单位置
     */
    @TableField(value = "position")
    @ApiModelProperty(value = "订单位置")
    private String position;
    /**
     * 司机编号
     */
    @TableField(value = "driver_id")
    @ApiModelProperty(value = "司机编号")
    private Long driverId;
    /**
     * 订单状态
     * 1代表运输中，2代表已签收
     */
    @TableField(value = "status")
    @ApiModelProperty(value = "订单状态，1代表运输中，2代表已签收")
    private String status;
}