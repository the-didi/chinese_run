package com.advgm.service.impl;

import com.advgm.domain.OrderStatus;
import com.advgm.mapper.OrderStatusMapper;
import com.advgm.service.OrderStatusService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiumin
 * @date 2022年05月09日 19:34
 */
@Service
public class OrderStatusServiceImpl extends ServiceImpl<OrderStatusMapper, OrderStatus> implements OrderStatusService {

    @Autowired
    OrderStatusMapper orderStatusMapper;

    @Override
    public Page<OrderStatus> queryAllOrderStatusByPage(Page<OrderStatus> page) {
        return page(page, new LambdaQueryWrapper<OrderStatus>());
    }

    public OrderStatusServiceImpl() {
        super();
    }

    /**
     * 根据id查询订单状态
     * @param id
     * @return
     *
     * */
    @Override
    public OrderStatus findOrderStatusById(long id) {
        return orderStatusMapper.selectById(id);
    }


    /**
     * 根据id批量删除订单状态
     * @param ids
     * @return
     *
     * */
    @Override
    public int deleteOrderStatusByIds(List<Long> ids) {
        return orderStatusMapper.deleteBatchIds(ids);
    }


    /**
     * 根据id更新订单状态
     * @param orderStatus
     * @return
     *
     * */
    @Override
    public int updateOrderStatusById(OrderStatus orderStatus) {
        return orderStatusMapper.updateById(orderStatus);
    }


    /**
     * 新增订单状态
     * @param orderStatus
     * @return
     *
     * */
    @Override
    public int insertStatusOrder(OrderStatus orderStatus) {
        return orderStatusMapper.insert(orderStatus);
    }
}