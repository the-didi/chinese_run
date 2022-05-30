package com.advgm.mapper;

import com.advgm.domain.CrTenant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrTenantMapper extends BaseMapper<CrTenant> {
    int updateBatch(List<CrTenant> list);

    int batchInsert(@Param("list") List<CrTenant> list);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(CrTenant record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CrTenant record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CrTenant selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CrTenant record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CrTenant record);
}