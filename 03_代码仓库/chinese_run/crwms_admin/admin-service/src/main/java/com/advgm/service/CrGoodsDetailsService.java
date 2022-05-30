package com.advgm.service;

import java.util.List;
import com.advgm.domain.CrGoodsDetails;
import com.advgm.domain.Driver;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
public interface CrGoodsDetailsService extends IService<CrGoodsDetails>{


    int updateBatch(List<CrGoodsDetails> list);

    int batchInsert(List<CrGoodsDetails> list);

    int insertOrUpdate(CrGoodsDetails record);

    int insertOrUpdateSelective(CrGoodsDetails record);
    Page<CrGoodsDetails> queryAllCrGoodsDetails(Page<CrGoodsDetails> page);
    int addCrGoodsDetails(CrGoodsDetails crGoodsDetails);
    int deleteCrGoodsDetailsById(Long id);
    int updateCrGoodsDetailsById(CrGoodsDetails crGoodsDetails);
   CrGoodsDetails getCrGoodsDetailsById(Long id);
    //    通过司机姓名查询司机信息
    List<CrGoodsDetails> getCrGoodSDetailsByName(String name);

}
