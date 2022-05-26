package com.advgm.mapper;

import com.advgm.domain.CrGoodsCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrGoodsCategoryMapper extends BaseMapper<CrGoodsCategory> {
    int updateBatch(List<CrGoodsCategory> list);

    int batchInsert(@Param("list") List<CrGoodsCategory> list);

    int insertOrUpdate(CrGoodsCategory record);

    int insertOrUpdateSelective(CrGoodsCategory record);
}