package com.advgm.mapper;

import com.advgm.domain.CrOtherIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrOtherInMapper extends BaseMapper<CrOtherIn> {
    int updateBatch(List<CrOtherIn> list);

    int batchInsert(@Param("list") List<CrOtherIn> list);

    int insertOrUpdate(CrOtherIn record);

    int insertOrUpdateSelective(CrOtherIn record);
}