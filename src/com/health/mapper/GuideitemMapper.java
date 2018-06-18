package com.health.mapper;

import com.health.entity.Guideitem;
import com.health.entity.GuideitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideitemMapper {
    int countByExample(GuideitemExample example);

    int deleteByExample(GuideitemExample example);

    int deleteByPrimaryKey(Integer guideitemid);

    int insert(Guideitem record);

    int insertSelective(Guideitem record);

    List<Guideitem> selectByExample(GuideitemExample example);

    Guideitem selectByPrimaryKey(Integer guideitemid);

    int updateByExampleSelective(@Param("record") Guideitem record, @Param("example") GuideitemExample example);

    int updateByExample(@Param("record") Guideitem record, @Param("example") GuideitemExample example);

    int updateByPrimaryKeySelective(Guideitem record);

    int updateByPrimaryKey(Guideitem record);
}