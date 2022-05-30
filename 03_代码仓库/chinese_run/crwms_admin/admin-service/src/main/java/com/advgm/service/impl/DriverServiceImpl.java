package com.advgm.service.impl;

import com.advgm.domain.Driver;
import com.advgm.domain.SysMenu;
import com.advgm.mapper.DriverMapper;
import com.advgm.service.DriverService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.DriverManager;
import java.util.List;

/**
 * @author 袁鹏
 * @date 2022年05月03日 14:46
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper,Driver> implements DriverService {
    @Override
public Page<Driver> queryAllDrivers(Page<Driver> page) {
    return page(page,new LambdaQueryWrapper<Driver>());
}
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public int addDriver(Driver driver) {
        return driverMapper.insert(driver);
    }

    @Override
    public int deleteDriverById(Long id) {
        return driverMapper.deleteById(id);
    }

    @Override
    public int updateDriverById(Driver driver) {
        return driverMapper.updateById(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverMapper.selectById(id);
    }

    @Override
    public List<Driver> getDriverByName(String name) {
        QueryWrapper<Driver> wrapper = new QueryWrapper<>();
        wrapper.eq("d_name",name);
        return driverMapper.selectList(wrapper);
    }
}