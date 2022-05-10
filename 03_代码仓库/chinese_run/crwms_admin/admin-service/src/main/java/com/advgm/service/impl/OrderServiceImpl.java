package com.advgm.service.impl;


import com.advgm.domain.Order;
import com.advgm.mapper.OrderMapper;
import com.advgm.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 袁鹏
 * @date 2022年05月09日 19:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    /**
     * 分页查询订单信息
     * @param page
     * @return
     */
    @Override
    public Page<Order> queryAllOrderByPage(Page<Order> page) {
        return page(page, new LambdaQueryWrapper<Order>());
    }
}