package com.advgm.controller;



import com.advgm.domain.Order;
import com.advgm.model.R;
import com.advgm.service.OrderService;
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
 * @date 2022年05月09日 19:44
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单管理")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/info")
    @ApiOperation(value = "订单信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current" ,value = "当前页") ,
            @ApiImplicitParam(name = "size" ,value = "每页显示的大小") ,
    })
    public R<Page<Order>> getInformationByPage(Page<Order> page){
        return R.ok(orderService.queryAllOrderByPage(page));
    }

    @GetMapping("/getById")
    @ApiOperation(value = "根据ID获取订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orderId",value = "订单id")
    })
    public R<Order> findById(long id){
       Order order = orderService.findOrderById(id);
        return R.ok(order);
    }

    @DeleteMapping("/deleteOrder")
    @ApiOperation(value = "根据ID删除订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "订单ID集合的json")
    })
    public R<String> deleteOrderByIds( Long id){
        int i = orderService.deleteOrderByIds(id);
        if (i!=0) {
            return R.ok("删除成功");
        }else {
            return R.fail("删除失败");
        }
    }

    @PutMapping("/updateOrder")
    @ApiOperation(value = "根据ID更新订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order",value = "订单的json数据")
    })
    public R<String> updateOrderById(@RequestBody Order order){
        int i = orderService.updateOrderById(order);
        if (i!=0) {
            return R.ok("更新成功");
        }else {
            return R.fail("更新失败");
        }
    }

    @PostMapping("/addOrder")
    @ApiOperation(value = "新增订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order",value = "订单的json数据")
    })
    public R<String> insertOrder(@RequestBody Order order){
        int i = orderService.insertOrder(order);
        if (i!=0) {
            return R.ok("新增成功");
        }else {
            return R.fail("新增失败");
        }
    }
    @GetMapping("/getOrderId")
  public    R<List<Order>> getOrderId(){
        return R.ok(orderService.getOrderId());
  }

}