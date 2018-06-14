package com.health.mapper;

import com.health.entity.Workerrole;
import com.health.entity.WorkerroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkerroleMapper {
    int countByExample(WorkerroleExample example);

    int deleteByExample(WorkerroleExample example);

    int deleteByPrimaryKey(Integer workerroleid);

    int insert(Workerrole record);

    int insertSelective(Workerrole record);

    List<Workerrole> selectByExample(WorkerroleExample example);

    Workerrole selectByPrimaryKey(Integer workerroleid);

    int updateByExampleSelective(@Param("record") Workerrole record, @Param("example") WorkerroleExample example);

    int updateByExample(@Param("record") Workerrole record, @Param("example") WorkerroleExample example);

    int updateByPrimaryKeySelective(Workerrole record);

    int updateByPrimaryKey(Workerrole record);
}