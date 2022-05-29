package com.advgm.service.impl;

import com.advgm.domain.CrGoodsDetails;
import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.advgm.mapper.CrOtherInMapper;
import com.advgm.domain.CrOtherIn;
import com.advgm.service.CrOtherInService;
@Service
public class CrOtherInServiceImpl extends ServiceImpl<CrOtherInMapper, CrOtherIn> implements CrOtherInService{

    @Autowired
    private  CrOtherInMapper crOtherInMapper;

    @Override
    public Page<CrOtherIn> queryAllCrOtherIn(Page<CrOtherIn> page) {
        return page(page,new LambdaQueryWrapper<CrOtherIn>());
    }

    @Override
    public int addCrOtherIn(CrOtherIn crOtherIn) {
        return crOtherInMapper.insert(crOtherIn);
    }

    @Override
    public int deleteCrOtherInById(Long id) {
        return crOtherInMapper.deleteById(id);
    }

    @Override
    public int updateCrOtherById(CrOtherIn crOtherIn) {
        return crOtherInMapper.updateById(crOtherIn);
    }

    @Override
    public CrOtherIn getCrOtherInById(Long id) {
        return crOtherInMapper.selectById(id);
    }

    @Override
    public List<CrOtherIn> getCrOtherInByName(String name) {
        QueryWrapper<CrOtherIn> w = new QueryWrapper<>();
        w.eq("create_by",name);
     return    crOtherInMapper.selectList(w);

    }
}
