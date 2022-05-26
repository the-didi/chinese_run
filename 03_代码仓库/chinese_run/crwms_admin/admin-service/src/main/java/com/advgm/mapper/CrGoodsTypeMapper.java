package com.advgm.mapper;

import com.advgm.domain.CrGoodsType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrGoodsTypeMapper extends BaseMapper<CrGoodsType> {
    int updateBatch(List<CrGoodsType> list);

    int batchInsert(@Param("list") List<CrGoodsType> list);

    int insertOrUpdate(CrGoodsType record);

    int insertOrUpdateSelective(CrGoodsType record);
}