package com.advgm.service.impl;

import com.advgm.domain.CrGoodsDetails;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import com.advgm.mapper.CrObserveInMapper;
import com.advgm.domain.CrObserveIn;
import com.advgm.service.CrObserveInService;

@Service
public class CrObserveInServiceImpl extends ServiceImpl<CrObserveInMapper, CrObserveIn> implements CrObserveInService {
    @Autowired
    private CrObserveInMapper crObserveInMapper;

    @Override
    public int updateBatch(List<CrObserveIn> list) {
        return 0;
    }

    @Override
    public int batchInsert(List<CrObserveIn> list) {
        return 0;
    }

    @Override
    public int insertOrUpdate(CrObserveIn record) {
        return 0;
    }

    @Override
    public int insertOrUpdateSelective(CrObserveIn record) {
        return 0;
    }

    @Override
    public Page<CrObserveIn> queryAllCrObserveIns(Page<CrObserveIn> page) {
        return page(page, new LambdaQueryWrapper<CrObserveIn>());
    }

    @Override
    public int addCrObserveIn(CrObserveIn crObserveIn) {
        return crObserveInMapper.insert(crObserveIn);
    }

    @Override
    public int deleteCrObserveInById(Long id) {
        return crObserveInMapper.deleteById(id);
    }

    @Override
    public int updateCrObserveById(CrObserveIn crObserveIn) {
        return crObserveInMapper.updateById(crObserveIn);
    }

    @Override
    public CrObserveIn getCrObserveById(Long id) {
        return crObserveInMapper.selectById(id);
    }

    @Override
    public List<CrObserveIn> getCrObserveInByName(String name) {
        QueryWrapper<CrObserveIn> w = new QueryWrapper<>();
        w.eq("g_hots",name);
        return crObserveInMapper.selectList(w);
    }
}
