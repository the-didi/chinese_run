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

@ApiModel(value="cr_wms.cr_other_in")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_other_in")
public class CrOtherIn implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;

    @TableField(value = "create_by")
    @ApiModelProperty(value="")
    private String createBy;

    @TableField(value = "create_time")
    @ApiModelProperty(value="")
    private Date createTime;

    @TableField(value = "tz_no")
    @ApiModelProperty(value="")
    private Long tzNo;

    @TableField(value = "tetant_id")
    @ApiModelProperty(value="")
    private Long tenantId;

    @TableField(value = "arrive_time")
    @ApiModelProperty(value="")
    private Date arriveTime;

    @TableField(value = "k_no")
    @ApiModelProperty(value="")
    private String kNo;

    @TableField(value = "car_id")
    @ApiModelProperty(value="")
    private String carId;

    @TableField(value = "driver_tel")
    @ApiModelProperty(value="")
    private String driverTel;

    @TableField(value = "order_category")
    @ApiModelProperty(value="")
    private String orderCategory;

    @TableField(value = "modify_by")
    @ApiModelProperty(value="")
    private String modifyBy;

    @TableField(value = "last_update_time")
    @ApiModelProperty(value="")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_TZ_NO = "tz_no";

    public static final String COL_TETANT_ID = "tetant_id";

    public static final String COL_ARRIVE_TIME = "arrive_time";

    public static final String COL_K_NO = "k_no";

    public static final String COL_CAR_ID = "car_id";

    public static final String COL_DRIVER_TEL = "driver_tel";

    public static final String COL_ORDER_CATEGORY = "order_category";

    public static final String COL_MODIFY_BY = "modify_by";

    public static final String COL_LAST_UPDATE_TIME = "last_update_time";
}