package com.health.mapper;

import com.health.entity.Guide;
import com.health.entity.GuideExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideMapper {
    int countByExample(GuideExample example);

    int deleteByExample(GuideExample example);

    int deleteByPrimaryKey(Integer guideid);

    int insert(Guide record);

    int insertSelective(Guide record);

    List<Guide> selectByExample(GuideExample example);

    Guide selectByPrimaryKey(Integer guideid);

    int updateByExampleSelective(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByExample(@Param("record") Guide record, @Param("example") GuideExample example);

    int updateByPrimaryKeySelective(Guide record);

    int updateByPrimaryKey(Guide record);
}