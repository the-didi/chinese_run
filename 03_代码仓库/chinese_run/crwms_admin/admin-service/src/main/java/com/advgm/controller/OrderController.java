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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 袁鹏
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
}