package com.health.mapper;

import com.health.entity.Workerrole;
import com.health.entity.WorkerroleExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkerroleMapper {
	Workerrole queryWorkerrole(int workerid);
	int updateWorkerrole(Integer workerid,Integer roleid);
	int deleteWorkerrole(Integer workerid,Integer roleid);
    int countByExample(WorkerroleExample example);

    int deleteByExample(WorkerroleExample example);

    int deleteByPrimaryKey(Integer workerroleid);

    int insert(Workerrole workerrole);

    int insertSelective(Workerrole record);

    List<Workerrole> selectByExample(WorkerroleExample example);

    Workerrole selectByPrimaryKey(Integer workerroleid);

    int updateByExampleSelective(@Param("record") Workerrole record, @Param("example") WorkerroleExample example);

    int updateByExample(@Param("record") Workerrole record, @Param("example") WorkerroleExample example);

    int updateByPrimaryKeySelective(Workerrole record);

    int updateByPrimaryKey(Workerrole record);
}