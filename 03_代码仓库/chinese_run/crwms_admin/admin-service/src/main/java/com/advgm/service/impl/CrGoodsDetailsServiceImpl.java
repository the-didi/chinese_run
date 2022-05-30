package com.advgm.service.impl;

import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.advgm.domain.CrGoodsDetails;
import com.advgm.mapper.CrGoodsDetailsMapper;
import com.advgm.service.CrGoodsDetailsService;
@Service
public class CrGoodsDetailsServiceImpl extends ServiceImpl<CrGoodsDetailsMapper, CrGoodsDetails> implements CrGoodsDetailsService{

    @Override
    public int updateBatch(List<CrGoodsDetails> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<CrGoodsDetails> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(CrGoodsDetails record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(CrGoodsDetails record) {
        return baseMapper.insertOrUpdateSelective(record);
    }

    @Override
    public Page<CrGoodsDetails> queryAllCrGoodsDetails(Page<CrGoodsDetails> page) {
        return page(page,new LambdaQueryWrapper<CrGoodsDetails>());
    }

    @Override
    public int addCrGoodsDetails(CrGoodsDetails crGoodsDetails) {
        return baseMapper.insert(crGoodsDetails);
    }

    @Override
    public int deleteCrGoodsDetailsById(Long id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateCrGoodsDetailsById(CrGoodsDetails crGoodsDetails) {
        return baseMapper.updateById(crGoodsDetails);
    }

    @Override
    public CrGoodsDetails getCrGoodsDetailsById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<CrGoodsDetails> getCrGoodSDetailsByName(String name) {
        QueryWrapper<CrGoodsDetails> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("g_name",name);
        return baseMapper.selectList(queryWrapper);
    }
}
