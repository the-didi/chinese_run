package com.advgm.controller;

import com.advgm.domain.SysUser;
import com.advgm.model.R;
import com.advgm.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sysUser")
@Api(tags = "系统用户管理")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    @ApiOperation(value = "条件查询后台用户参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "mobile", value = "用户的手机"),
            @ApiImplicitParam(name = "fullname", value = "用户的全名"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数")

    })
    public R<Page<SysUser>> findByPage(Page<SysUser> page,
                                       String mobile,
                                       String fullname){
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(sysUserService.findByPage(page, mobile,fullname));
    }

}
