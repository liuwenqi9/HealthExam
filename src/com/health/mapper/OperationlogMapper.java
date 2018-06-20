package com.health.mapper;

import com.health.entity.Operationlog;
import com.health.entity.OperationlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationlogMapper {
    int countByExample(OperationlogExample example);

    int deleteByExample(OperationlogExample example);

    int deleteByPrimaryKey(Integer operationlogid);

    int insert(Operationlog record);

    int insertSelective(Operationlog record);

    List<Operationlog> selectByExample(OperationlogExample example);

    Operationlog selectByPrimaryKey(Integer operationlogid);

    int updateByExampleSelective(@Param("record") Operationlog record, @Param("example") OperationlogExample example);

    int updateByExample(@Param("record") Operationlog record, @Param("example") OperationlogExample example);

    int updateByPrimaryKeySelective(Operationlog record);

    int updateByPrimaryKey(Operationlog record);
}