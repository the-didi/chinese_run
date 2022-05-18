package com.advgm.service.impl;


import com.advgm.domain.Order;
import com.advgm.mapper.OrderMapper;
import com.advgm.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 袁鹏
 * @date 2022年05月09日 19:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public OrderServiceImpl() {
        super();
    }
    /**
     * 分页查询订单信息
     * @param page
     * @return
     */
    @Override
    public Page<Order> queryAllOrderByPage(Page<Order> page) {
        return page(page, new LambdaQueryWrapper<Order>());
    }

    /**
     * 根据id查询订单
     * @param id
     * @return
     *
     * */
    @Override
    public Order findOrderById(long id) {
        return  orderMapper.selectById(id);
    }


    /**
     * 根据id删除订单
     * @param id
     * @return
     *
     * */
    @Override
    public int deleteOrderByIds(Long id) {
       return orderMapper.deleteById(id);
    }

    /**
     * 根据更新订单订单
     * @param order
     * @return
     *
     * */
    @Override
    public int updateOrderById(Order order) {
        return orderMapper.updateById(order);
    }


    /**
     * 根据新增订单
     * @param order
     * @return
     *
     * */
    @Override
    public int insertOrder(Order order) {
        return orderMapper.insert(order);
    }
}