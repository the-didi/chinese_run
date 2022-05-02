package com.advgm.mapper;

import com.advgm.domain.OnlineCgForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OnlineCgFormMapper extends BaseMapper<OnlineCgForm> {
    @Select("select * from `information_schema`.`TABLES` where `information_schema`.`TABLES`.`TABLE_SCHEMA`='cr_wms' and `information_schema`.`TABLES`.`TABLE_COMMENT` like #{tableComment} and `information_schema`.`TABLES`.`TABLE_NAME` like #{tableName} order by `information_schema`.`TABLES`.`CREATE_TIME` limit #{end} offset #{start}")
    List<OnlineCgForm> findByPage(long start, long end, String tableName, String tableComment);
}
