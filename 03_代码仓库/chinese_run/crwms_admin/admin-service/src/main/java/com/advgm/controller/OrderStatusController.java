package com.advgm.controller;

import com.advgm.domain.OrderStatus;
import com.advgm.model.R;
import com.advgm.service.OrderStatusService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 袁鹏
 * @date 2022年05月09日 20:09
 */
@RestController
@Api(tags = "运输管理")
@RequestMapping("/transport")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;
    @GetMapping("/info")
    @ApiOperation(value = "物流信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<OrderStatus>> getInformationByPage(Page<OrderStatus> page){
        return R.ok(orderStatusService.queryAllOrderStatusByPage(page));
    }
}