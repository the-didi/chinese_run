package com.advgm.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-advgm-domain-CrTenant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "cr_tenant")
public class CrTenant{
    /**
     * 租户主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "租户主键")
    private Long id;

    /**
     * 租户号码,数据隔离使用
     */
    @TableField(value = "tenant_no",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "租户号码,数据隔离使用")
    private String tenantNo;

    /**
     * 货主名称
     */
    @TableField(value = "tenant_name")
    @ApiModelProperty(value = "货主名称")
    private String tenantName;

    /**
     * 货主邮箱
     */
    @TableField(value = "tenant_email")
    @ApiModelProperty(value = "货主邮箱")
    private String tenantEmail;

    /**
     * 货主用户名
     */
    @TableField(value = "tenant_username")
    @ApiModelProperty(value = "货主用户名")
    private String tenantUsername;

    /**
     * 货主密码
     */
    @TableField(value = "tenant_password")
    @ApiModelProperty(value = "货主密码")
    private String tenantPassword;

    /**
     * 创建人
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 修改人
     */
    @TableField(value = "modify_by",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "修改人")
    private String modifyBy;

    /**
     * 创建时间
     */
    @TableField(value = "created",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date created;

    /**
     * 修改时间
     */
    @TableField(value = "last_update_time",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "修改时间")
    private Date lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_TENANT_NO = "tenant_no";

    public static final String COL_TENANT_NAME = "tenant_name";

    public static final String COL_TENANT_EMAIL = "tenant_email";

    public static final String COL_TENANT_USERNAME = "tenant_username";

    public static final String COL_TENANT_PASSWORD = "tenant_password";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_MODIFY_BY = "modify_by";

    public static final String COL_CREATED = "created";

    public static final String COL_LAST_UPDATE_TIME = "last_update_time";
}