package com.health.mapper;

import com.health.entity.Guidepack;
import com.health.entity.GuidepackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuidepackMapper {
    int countByExample(GuidepackExample example);

    int deleteByExample(GuidepackExample example);

    int deleteByPrimaryKey(Integer guidepackid);

    int insert(Guidepack record);

    int insertSelective(Guidepack record);

    List<Guidepack> selectByExample(GuidepackExample example);

    Guidepack selectByPrimaryKey(Integer guidepackid);

    int updateByExampleSelective(@Param("record") Guidepack record, @Param("example") GuidepackExample example);

    int updateByExample(@Param("record") Guidepack record, @Param("example") GuidepackExample example);

    int updateByPrimaryKeySelective(Guidepack record);

    int updateByPrimaryKey(Guidepack record);
}