package com.advgm.service.impl;

import com.advgm.domain.OrderStatus;
import com.advgm.mapper.OrderStatusMapper;
import com.advgm.service.OrderStatusService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 袁鹏
 * @date 2022年05月09日 19:34
 */
@Service
public class OrderStatusServiceImpl extends ServiceImpl<OrderStatusMapper, OrderStatus> implements OrderStatusService {

    @Override
    public Page<OrderStatus> queryAllOrderStatusByPage(Page<OrderStatus> page) {
        return page(page, new LambdaQueryWrapper<OrderStatus>());
    }
}