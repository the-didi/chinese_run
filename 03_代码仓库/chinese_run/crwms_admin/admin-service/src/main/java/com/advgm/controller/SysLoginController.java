package com.advgm.controller;

import com.advgm.domain.SysUser;
import com.advgm.model.LoginResult;
import com.advgm.model.R;
import com.advgm.service.SysLoginService;
import com.advgm.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;

/**
 * 登录的控制器
 */
@RestController
@Api(tags = "登录的控制器")
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    @ApiOperation(value = "后台管理人员登录")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "username", value = "用户名称"),
                    @ApiImplicitParam(name = "password", value = "用户的密码"),
            }
    )
    public LoginResult login(
            @RequestParam(required = true) String username, // 用户名称
            @RequestParam(required = true) String password  // 用户的密码
    ) {
        return loginService.login(username, password);
    }

    @GetMapping("/info")
    @ApiOperation(value="获取登录用户的信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username",value = "登录用户的ID")
    })
    public R<SysUser> userInfo(String username){
        QueryWrapper<SysUser> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        SysUser user = sysUserService.getOne(wrapper);
        return R.ok(user);
    }
}
