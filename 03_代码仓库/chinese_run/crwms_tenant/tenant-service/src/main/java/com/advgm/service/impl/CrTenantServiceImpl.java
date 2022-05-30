package com.advgm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.advgm.domain.CrTenant;
import com.advgm.mapper.CrTenantMapper;
import com.advgm.service.CrTenantService;
import org.springframework.util.StringUtils;

@Service
public class CrTenantServiceImpl extends ServiceImpl<CrTenantMapper, CrTenant> implements CrTenantService{

    @Override
    public int updateBatch(List<CrTenant> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<CrTenant> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Page<CrTenant> findByPage(Page<CrTenant> page, String tenantName) {
        return page(page, new LambdaQueryWrapper<CrTenant>().like(
                !StringUtils.isEmpty(tenantName),
                CrTenant::getTenantName,
                tenantName
        ));
    }
}
