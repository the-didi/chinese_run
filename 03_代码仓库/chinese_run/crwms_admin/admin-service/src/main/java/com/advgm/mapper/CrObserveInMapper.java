package com.advgm.mapper;

import com.advgm.domain.CrObserveIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrObserveInMapper extends BaseMapper<CrObserveIn> {
    int updateBatch(List<CrObserveIn> list);

    int batchInsert(@Param("list") List<CrObserveIn> list);

    int insertOrUpdate(CrObserveIn record);

    int insertOrUpdateSelective(CrObserveIn record);
}