package com.advgm.controller;

import com.advgm.domain.Config;
import com.advgm.model.R;
import com.advgm.service.ConfigService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/configs")
@Api(tags = "打印数据配置")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @GetMapping
    @ApiOperation(value = "条件查询后台参数")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type",value = "后台参数类型"),
        @ApiImplicitParam(name = "code",value = "后台参数编码"),
        @ApiImplicitParam(name = "current", value = "当前页"),
        @ApiImplicitParam(name = "name", value = "后台参数的名称"),
        @ApiImplicitParam(name = "size", value = "每页显示的条数")
    })
    @PreAuthorize("hasAuthority('config_query')")
    public R<Page<Config>> findByPage(@ApiIgnore Page<Config> page,String type,String code,String name){
        Page<Config> configPage=configService.findByPage(page,type,name,code);
        return R.ok(configPage);
    }

    @PostMapping
    @ApiOperation(value = "新增一个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config",value = "config 的json数据")
    })
    @PreAuthorize("hasAuthority('config_create')")
    public R add(@RequestBody @Validated Config config){
        boolean save = configService.save(config);
        if(save){
            return R.ok() ;
        }
        return R.fail("新增失败") ;
    }
    @PatchMapping
    @ApiOperation(value = "修改一个参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config",value = "config 的json数据")
    })
    @PreAuthorize("hasAuthority('config_update')")
    public R update(@RequestBody @Validated  Config config){
        boolean update = configService.updateById(config);

        if(update){
            return R.ok() ;
        }
        return R.fail("修改失败") ;
    }


}
