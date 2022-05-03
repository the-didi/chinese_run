package com.advgm.service;

import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface DriverService {
    Page<Driver> queryAllDrivers(Page<Driver> page);
}
