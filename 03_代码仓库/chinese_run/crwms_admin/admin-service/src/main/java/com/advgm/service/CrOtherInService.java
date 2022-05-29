package com.advgm.service;

import java.util.List;
import com.advgm.domain.CrOtherIn;
import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CrOtherInService extends IService<CrOtherIn>{


    Page<CrOtherIn> queryAllCrOtherIn(Page<CrOtherIn> page);
    int addCrOtherIn(CrOtherIn crOtherIn);
    int deleteCrOtherInById(Long id);
    int updateCrOtherById(CrOtherIn crOtherIn);
    CrOtherIn getCrOtherInById(Long id);
    //    通过司机姓名查询司机信息
    List<CrOtherIn> getCrOtherInByName(String name);
}
