package com.advgm.service;

import java.util.List;
import com.advgm.domain.CrObserveIn;
import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CrObserveInService extends IService<CrObserveIn>{


    int updateBatch(List<CrObserveIn> list);

    int batchInsert(List<CrObserveIn> list);

    int insertOrUpdate(CrObserveIn record);

    int insertOrUpdateSelective(CrObserveIn record);
    Page<CrObserveIn> queryAllCrObserveIns(Page<CrObserveIn> page);
    int addCrObserveIn(CrObserveIn crObserveIn);
    int deleteCrObserveInById(Long id);
    int updateCrObserveById(CrObserveIn crObserveIn);
    CrObserveIn getCrObserveById(Long id);
    List<CrObserveIn> getCrObserveInByName(String name);
}
