package com.advgm.service;

import com.advgm.domain.OrderStatus;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface OrderStatusService  {
    Page<OrderStatus> queryAllOrderStatusByPage(Page<OrderStatus> page);
    OrderStatus findOrderStatusById(long id);
    int deleteOrderStatusByIds(List<Long> ids);
    int updateOrderStatusById(OrderStatus orderStatus);
    int insertStatusOrder(OrderStatus orderStatus);
}
