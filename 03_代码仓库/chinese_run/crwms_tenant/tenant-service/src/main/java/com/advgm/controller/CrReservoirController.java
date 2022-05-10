package com.advgm.controller;

import com.advgm.domain.CrReservoir;
import com.advgm.model.R;
import com.advgm.service.CrReservoirService;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservoir")
@Api(tags = "库区的管理")
public class CrReservoirController {

    @Autowired
    private CrReservoirService crReservoirService;

    @GetMapping
    @ApiOperation(value = "条件分页查询")
    @PreAuthorize("hasAuthority('cr_reservoir_query')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页"),
            @ApiImplicitParam(name = "size", value = "每页显示的大小"),
            @ApiImplicitParam(name = "rsName", value = "库区名称"),
            @ApiImplicitParam(name = "rsCode", value = "库区编码"),
            @ApiImplicitParam(name = "rsDesc", value = "库区备注"),
            @ApiImplicitParam(name = "rsType", value = "库区属性"),
    })
    public R<Page<CrReservoir>> findByPage(Page<CrReservoir> page,
                                           String rsName,
                                           String rsCode,
                                           String rsDesc,
                                           String rsType){
        page.addOrder(OrderItem.desc("last_update_time"));
        return R.ok(crReservoirService.findByPage(page,rsName,rsCode,rsDesc,rsType));
    }

}
