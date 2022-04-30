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
 * @date 2022年04月30日 17:49
 */
@ApiModel(value = "com-advgm-domain-wareHouse")
@TableName(value = "warehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 仓库编号
     */
    @TableField(value = "w_id")
    @ApiModelProperty(value = "仓库编号")
    private int wId;
    /**
     * 仓库地址
     */
    @TableField(value = "w_address")
    @ApiModelProperty(value = "仓库地址")
    private String address;
}