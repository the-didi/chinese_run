package com.advgm.controller;

import com.advgm.model.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.advgm.domain.OnlineCgForm;
import com.advgm.service.OnlineCgFormService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cgForm")
@Api(tags = "在线表单开发")
public class OnlineCgFormController {
    @Autowired
    private OnlineCgFormService onlineCgFormService;



    @GetMapping
    @ApiOperation(value = "条件查询后台参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableComment",value = "后台参数编码"),
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "tableName", value = "表名称"),
            @ApiImplicitParam(name = "size", value = "每页显示的条数")
    })
    public R<Page<OnlineCgForm>> findByPage(Page<OnlineCgForm> page,String tableName,String tableComment){
        return R.ok(onlineCgFormService.findByPage(page,tableName,tableComment));
    }



}
