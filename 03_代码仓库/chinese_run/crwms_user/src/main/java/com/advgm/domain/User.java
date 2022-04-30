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
 * @date 2022年04月30日 18:59
 */
@ApiModel("com-advgm-domain-user")
@TableName(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 密码，注册需要用到MD5加密算法
     */
    @TableField(value = "password")
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 用户电话号码
     */
    @TableField(value = "tel")
    @ApiModelProperty(value = "用户电话号码")
    private String tel;
    /**
     * 收货地址
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "收货地址")
    private String address;
}