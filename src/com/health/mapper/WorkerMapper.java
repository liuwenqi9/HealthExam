package com.health.mapper;

import com.health.entity.Worker;
import com.health.entity.WorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkerMapper {
    int countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);

    int deleteByPrimaryKey(Integer workerid);

    int insert(Worker record);

    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);

    Worker selectByPrimaryKey(Integer workerid);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}