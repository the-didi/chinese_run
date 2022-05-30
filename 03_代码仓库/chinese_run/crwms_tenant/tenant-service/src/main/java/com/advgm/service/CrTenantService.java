package com.advgm.service;

import com.advgm.domain.CrTenant;
import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CrTenantService extends IService<CrTenant>{


    int updateBatch(List<CrTenant> list);

    int batchInsert(List<CrTenant> list);

    Page<CrTenant> findByPage(Page<CrTenant> page, String tenantName);
}
