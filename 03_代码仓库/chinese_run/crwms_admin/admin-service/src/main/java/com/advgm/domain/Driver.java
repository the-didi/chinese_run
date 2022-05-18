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
@ApiModel(value = "com-advgm-domain-driver")
@TableName(value = "cr_driver")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    /**
     * 主键id
     */
    @TableId(value = "id",type= IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 司机姓名
     */
    @TableField(value = "d_name")
    @ApiModelProperty(value = "司机姓名")
    private String name;
    /**
     * 司机性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "司机性别")
    private String sex;
    /**
     * 司机年龄
     */
    @TableField(value = "age")
    @ApiModelProperty(value = "司机年龄")
    private int age;
    /**
     * 司机电话号码
     */
    @TableField(value = "d_tel")
    @ApiModelProperty(value = "司机电话号码")
    private String tel;
    /**
     * 司机车牌号
     */
    @TableField(value = "car_id")
    @ApiModelProperty(value = "司机车牌号")
    private String carId;
    /**
     * 创建时间
     */
    @TableField(value = "created")
    @ApiModelProperty(value = "创建时间")
    private Date created;
    /**
     * 修改时间
     */
    @TableField(value = "lastUpdateTime")
    @ApiModelProperty(value = "创建时间")
    private Date lastUpdateTime;
}