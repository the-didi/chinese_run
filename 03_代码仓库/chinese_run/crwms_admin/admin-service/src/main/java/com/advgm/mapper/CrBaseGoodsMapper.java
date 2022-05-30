package com.advgm.mapper;

import com.advgm.domain.CrBaseGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrBaseGoodsMapper extends BaseMapper<CrBaseGoods> {
    int updateBatch(List<CrBaseGoods> list);

    int batchInsert(@Param("list") List<CrBaseGoods> list);

    int insertOrUpdate(CrBaseGoods record);

    int insertOrUpdateSelective(CrBaseGoods record);
}