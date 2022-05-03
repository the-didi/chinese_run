package com.advgm.controller;

import com.advgm.domain.Driver;
import com.advgm.model.R;
import com.advgm.service.DriverService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 袁鹏
 * @date 2022年05月03日 14:51
 */
@RestController
@RequestMapping("/driver")
@Api(tags="司机管理")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @GetMapping("/info")
    @ApiOperation(value = "司机信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<Driver>> getInformationByPage(Page<Driver> page){
        return R.ok(driverService.queryAllDrivers(page));
    }
}