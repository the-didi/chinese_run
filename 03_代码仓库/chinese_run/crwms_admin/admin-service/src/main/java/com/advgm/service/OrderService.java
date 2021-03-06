package com.advgm.service;

import com.advgm.domain.Order;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;


/**
 * @author qiumin
 * @date 2022年05月09日 19:30
 */
public interface OrderService {
    Page<Order> queryAllOrderByPage(Page<Order> page);
    Order findOrderById(long id);
    int deleteOrderByIds(Long id);
    int updateOrderById(Order order);
    int insertOrder(Order order);
//    查询未派送得订单
    List<Order> getOrderId();
}