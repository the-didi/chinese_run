package com.advgm.controller;

import com.advgm.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "菜单管理")
@RequestMapping("/menus")
@RestController
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name")
    })
}
