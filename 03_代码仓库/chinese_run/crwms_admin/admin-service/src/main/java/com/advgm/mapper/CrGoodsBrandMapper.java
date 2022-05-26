package com.advgm.mapper;

import com.advgm.domain.CrGoodsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrGoodsBrandMapper extends BaseMapper<CrGoodsBrand> {
    int updateBatch(List<CrGoodsBrand> list);

    int batchInsert(@Param("list") List<CrGoodsBrand> list);

    int insertOrUpdate(CrGoodsBrand record);

    int insertOrUpdateSelective(CrGoodsBrand record);

    int updateBatchSelective(List<CrGoodsBrand> list);
}