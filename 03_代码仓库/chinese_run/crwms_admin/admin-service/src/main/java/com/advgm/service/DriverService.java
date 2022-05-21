package com.advgm.service;

import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface DriverService {
    /**
     * 分页查询司机数据
     * @param page
     * @return
     */
    Page<Driver> queryAllDrivers(Page<Driver> page);
    int addDriver(Driver driver);
    int deleteDriverById(Long id);
    int updateDriverById(Driver driver);
    Driver getDriverById(Long id);
//    通过司机姓名查询司机信息
    List<Driver> getDriverByName(String name);
}
