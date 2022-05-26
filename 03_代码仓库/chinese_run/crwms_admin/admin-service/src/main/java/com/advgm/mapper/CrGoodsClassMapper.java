package com.advgm.mapper;

import com.advgm.domain.CrGoodsClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrGoodsClassMapper extends BaseMapper<CrGoodsClass> {
    int updateBatch(List<CrGoodsClass> list);

    int batchInsert(@Param("list") List<CrGoodsClass> list);

    int insertOrUpdate(CrGoodsClass record);

    int insertOrUpdateSelective(CrGoodsClass record);
}