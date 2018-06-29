package com.health.mapper;

import com.health.entity.Guideitemsview;
import com.health.entity.GuideitemsviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuideitemsviewMapper {
    int countByExample(GuideitemsviewExample example);

    int deleteByExample(GuideitemsviewExample example);

    int insert(Guideitemsview record);

    int insertSelective(Guideitemsview record);

    List<Guideitemsview> selectByExample(GuideitemsviewExample example);

    int updateByExampleSelective(@Param("record") Guideitemsview record, @Param("example") GuideitemsviewExample example);

    int updateByExample(@Param("record") Guideitemsview record, @Param("example") GuideitemsviewExample example);
}