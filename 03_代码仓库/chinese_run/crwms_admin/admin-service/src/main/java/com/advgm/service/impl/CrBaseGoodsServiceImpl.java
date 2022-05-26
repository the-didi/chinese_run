package com.advgm.service.impl;

import com.advgm.domain.Driver;
import com.advgm.mapper.DriverMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.advgm.mapper.CrBaseGoodsMapper;
import com.advgm.domain.CrBaseGoods;
import com.advgm.service.CrBaseGoodsService;
@Service
public class CrBaseGoodsServiceImpl extends ServiceImpl<CrBaseGoodsMapper, CrBaseGoods> implements CrBaseGoodsService{

    @Override
    public int updateBatch(List<CrBaseGoods> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<CrBaseGoods> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(CrBaseGoods record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(CrBaseGoods record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
    @Override
    public Page<CrBaseGoods> queryAllDrivers(Page<CrBaseGoods> page) {
        return page(page,new LambdaQueryWrapper<CrBaseGoods>());
    }
    @Autowired
    private CrBaseGoodsMapper crBaseGoodsMapper;
    @Override
    public int addCrBaseGoods(CrBaseGoods crBaseGoods) {
        return crBaseGoodsMapper.insert(crBaseGoods);
    }

    @Override
    public int deleteCrBaseGoodsById(Long id) {
        return crBaseGoodsMapper.deleteById(id);
    }

    @Override
    public int updateCrBaseGoodsById(CrBaseGoods crBaseGoods) {
        return crBaseGoodsMapper.updateById(crBaseGoods);}

    @Override
    public CrBaseGoods getCrBaseGoodsById(Long id) {
        return crBaseGoodsMapper.selectById(id);
    }

    @Override
    public List<CrBaseGoods> getCrBaseGoodsByName(String name) {
        QueryWrapper<CrBaseGoods> wrapper = new QueryWrapper<>();
        wrapper.eq("h_name",name);
        return crBaseGoodsMapper.selectList(wrapper);
    }
}
