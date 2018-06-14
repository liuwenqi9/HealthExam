package com.health.mapper;

import com.health.entity.Chshflow;
import com.health.entity.ChshflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChshflowMapper {
    int countByExample(ChshflowExample example);

    int deleteByExample(ChshflowExample example);

    int deleteByPrimaryKey(Integer chshflowid);

    int insert(Chshflow record);

    int insertSelective(Chshflow record);

    List<Chshflow> selectByExample(ChshflowExample example);

    Chshflow selectByPrimaryKey(Integer chshflowid);

    int updateByExampleSelective(@Param("record") Chshflow record, @Param("example") ChshflowExample example);

    int updateByExample(@Param("record") Chshflow record, @Param("example") ChshflowExample example);

    int updateByPrimaryKeySelective(Chshflow record);

    int updateByPrimaryKey(Chshflow record);
}