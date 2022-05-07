package com.advgm.service;

import com.advgm.domain.CrReservoir;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CrReservoirService extends IService<CrReservoir> {
    Page<CrReservoir> findByPage(Page<CrReservoir> page, String rsName, String rsCode, String rsDesc, String rsType);
}
