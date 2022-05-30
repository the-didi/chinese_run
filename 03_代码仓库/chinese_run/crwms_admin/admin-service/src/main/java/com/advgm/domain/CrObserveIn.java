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

@ApiModel(value="cr_wms.cr_observe_in")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_wms.cr_observe_in")
public class CrObserveIn implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建者")
    private String createBy;

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
     * 修改时间
     */
    @TableField(value = "last_update_time")
    @ApiModelProperty(value="修改时间")
    private Date lastUpdateTime;

    /**
     * 进货通知单号
     */
    @TableField(value = "tz_no")
    @ApiModelProperty(value="进货通知单号")
    private Long tzNo;

    /**
     * 货主
     */
    @TableField(value = "g_host")
    @ApiModelProperty(value="货主")
    private String gHost;

    /**
     * 预计到货时间
     */
    @TableField(value = "arrive_time")
    @ApiModelProperty(value="预计到货时间")
    private Date arriveTime;

    /**
     * 客户订单号
     */
    @TableField(value = "c_no")
    @ApiModelProperty(value="客户订单号")
    private Long cNo;

    /**
     * 运输号码
     */
    @TableField(value = "tran_tel")
    @ApiModelProperty(value="运输号码")
    private String tranTel;

    /**
     * 运输公司
     */
    @TableField(value = "tran_company")
    @ApiModelProperty(value="运输公司")
    private String tranCompany;

    /**
     * 供应商编号
     */
    @TableField(value = "gy_no")
    @ApiModelProperty(value="供应商编号")
    private String gyNo;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_MODIFY_BY = "modify_by";

    public static final String COL_LAST_UPDATE_TIME = "last_update_time";

    public static final String COL_TZ_NO = "tz_no";

    public static final String COL_G_HOST = "g_host";

    public static final String COL_ARRIVE_TIME = "arrive_time";

    public static final String COL_C_NO = "c_no";

    public static final String COL_TRAN_TEL = "tran_tel";

    public static final String COL_TRAN_COMPANY = "tran_company";

    public static final String COL_GY_NO = "gy_no";
}