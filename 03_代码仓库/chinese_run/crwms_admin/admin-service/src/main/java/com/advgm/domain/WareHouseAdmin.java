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
@ApiModel(value = "com-advgm-domain-WareHouseAdmin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "warehouse_admin")
public class WareHouseAdmin {
    /**
    * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 仓库管理员姓名
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "仓库管理员姓名")
    private String name;
    /**
     * 仓库管理员性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "仓库管理员性别")
    /**
     * 仓库管理员性别
     */
    private String  sex;
    @TableField(value = "age")
    @ApiModelProperty(value = "仓库管理员性别")
    private int age;
    /**
     * 仓库管理员电话号码
     */
    @TableField(value = "tel")
    @ApiModelProperty(value = "仓库管理员电话号码")
    private String tel;
    /**
     * 仓库id
     */
    @TableField(value = "w_id")
    @ApiModelProperty(value = "仓库id")
    private Long WId;
}