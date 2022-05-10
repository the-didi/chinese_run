package com.advgm.service.impl;

import com.advgm.domain.CrReservoir;
import com.advgm.mapper.CrReservoirMapper;
import com.advgm.service.CrReservoirService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CrReservoirServiceImpl extends ServiceImpl<CrReservoirMapper, CrReservoir> implements CrReservoirService {

    @Autowired
    private CrReservoirMapper crReservoirMapper;

    @Override
    public Page<CrReservoir> findByPage(Page<CrReservoir> page, String rsName, String rsCode, String rsDesc, String rsType) {
        return page(page, new LambdaQueryWrapper<CrReservoir>().like(
                !StringUtils.isEmpty(rsName),
                CrReservoir::getRsName,
                rsName
        ).like(
                !StringUtils.isEmpty(rsCode),
                CrReservoir::getRsCode,
                rsCode
                ).like(
                !StringUtils.isEmpty(rsDesc),
                CrReservoir::getRsDesc,
                rsDesc
                ).like(
                !StringUtils.isEmpty(rsCode),
                CrReservoir::getRsType,
                rsType
                )
        );
    }
}
