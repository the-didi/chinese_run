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
 * @date 2022年04月30日 18:59
 */
@ApiModel(value = "com-advgm-domain-order")
@TableName(value = "cr_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
    主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 订单号
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value = "订单号")
    private String orderId;
    /**
     * 物料名称
     */
    @TableField(value = "w_name")
    @ApiModelProperty(value = "物料名称")
    private String wName;
    /**
     * 物料数量
     */
    @TableField(value = "number")
    @ApiModelProperty(value = "物料数量")
    private String number;
    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    @ApiModelProperty(value = "下单时间")
    private Date orderTime;
    /**
     * 付款时间
     */
    @TableField(value = "pay_time")
    @ApiModelProperty(value = "付款时间")
    private  Date payTime;
    /**
     * 支付方式
     */
    @TableField(value = "pay_method")
    @ApiModelProperty(value = "支付方式")
    private String payMethod;
    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 签收时间
     */
    @TableField(value = "sign_time")
    @ApiModelProperty(value = "签收时间")
    private Date signTime;
    /**
     * 订单状态
     */
    @TableField(value = "order_status")
    @ApiModelProperty(value = "订单状态")
    private String status;
    /**
     * 订单所在位置，这里的位置由gps得到
     */
    @TableField(value = "position")
    @ApiModelProperty(value = "订单所在位置")
    private String position;
    /**
     * 司机id
     */
    @TableField(value = "driver_id")
    @ApiModelProperty(value = "司机id")
    private  Long driverId;
    /**
     * 物料id
     */
    @TableField(value = "w_id")
    @ApiModelProperty(value = "物料id")
    private Long wId;
}