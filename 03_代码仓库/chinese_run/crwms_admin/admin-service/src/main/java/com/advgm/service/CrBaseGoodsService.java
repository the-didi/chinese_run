package com.advgm.service;

import java.util.List;
import com.advgm.domain.CrBaseGoods;
import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CrBaseGoodsService extends IService<CrBaseGoods>{


    int updateBatch(List<CrBaseGoods> list);

    int batchInsert(List<CrBaseGoods> list);

    int insertOrUpdate(CrBaseGoods record);

    int insertOrUpdateSelective(CrBaseGoods record);
    Page<CrBaseGoods> queryAllDrivers(Page<CrBaseGoods> page);
    int addCrBaseGoods(CrBaseGoods crBaseGoods);
    int deleteCrBaseGoodsById(Long id);
    int updateCrBaseGoodsById(CrBaseGoods crBaseGoods);
    List<CrBaseGoods> getCrBaseGoodsByName(String name);
     CrBaseGoods getCrBaseGoodsById(Long id);

}
