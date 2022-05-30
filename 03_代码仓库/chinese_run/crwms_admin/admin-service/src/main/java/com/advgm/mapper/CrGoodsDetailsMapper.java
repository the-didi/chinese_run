package com.advgm.mapper;

import com.advgm.domain.CrGoodsDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrGoodsDetailsMapper extends BaseMapper<CrGoodsDetails> {
    int updateBatch(List<CrGoodsDetails> list);

    int batchInsert(@Param("list") List<CrGoodsDetails> list);

    int insertOrUpdate(CrGoodsDetails record);

    int insertOrUpdateSelective(CrGoodsDetails record);
}