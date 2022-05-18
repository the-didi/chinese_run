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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiumin
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

    @GetMapping("/getById")
    @ApiOperation(value = "根据ID获取订单状态信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orderStatusId",value = "订单状态id")
    })
    public R<OrderStatus> findOrderStatusById(long id){
        OrderStatus orderStatus = orderStatusService.findOrderStatusById(id);
        return R.ok(orderStatus);
    }

    @DeleteMapping("/deleteOrderStatus")
    @ApiOperation(value = "根据ID删除订单状态信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orderStatusId",value = "订单状态ID集合的json")
    })
    public R<String> deleteOrderStatusByIds(@RequestBody List<Long> ids){
        int i = orderStatusService.deleteOrderStatusByIds(ids);
        if (i!=0) {
            return R.ok("删除成功");
        }else {
            return R.fail("删除失败");
        }
    }

    @PutMapping("/updateOrderStatus")
    @ApiOperation(value = "根据ID更新订单状态信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus",value = "订单状态的json数据")
    })
    public R<String> updateOrderStatusById(@RequestBody OrderStatus orderStatus){
        int i = orderStatusService.updateOrderStatusById(orderStatus);
        if (i!=0) {
            return R.ok("更新成功");
        }else {
            return R.fail("更新失败");
        }
    }

    @PostMapping("/addOrderStatus")
    @ApiOperation(value = "新增订单状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus",value = "订单状态的json数据")
    })
    public R<String> insertStatusOrder(@RequestBody OrderStatus orderStatus){
        int i = orderStatusService.insertStatusOrder(orderStatus);
        if (i!=0) {
            return R.ok("新增成功");
        }else {
            return R.fail("新增失败");
        }
    }
}