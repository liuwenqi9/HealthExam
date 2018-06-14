package com.health.mapper;

import com.health.entity.Operations;
import com.health.entity.OperationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface OperationsMapper {
    int countByExample(OperationsExample example);

    int deleteByExample(OperationsExample example);

    int deleteByPrimaryKey(Integer operationid);

    int insert(Operations record);

    int insertSelective(Operations record);

    List<Operations> selectByExample(OperationsExample example);

    Operations selectByPrimaryKey(Integer operationid);

    int updateByExampleSelective(@Param("record") Operations record, @Param("example") OperationsExample example);

    int updateByExample(@Param("record") Operations record, @Param("example") OperationsExample example);

    int updateByPrimaryKeySelective(Operations record);

    int updateByPrimaryKey(Operations record);
}