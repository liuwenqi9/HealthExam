package com.health.mapper;

import com.health.entity.Viewpersonguidepack;
import com.health.entity.ViewpersonguidepackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewpersonguidepackMapper {
    int countByExample(ViewpersonguidepackExample example);

    int deleteByExample(ViewpersonguidepackExample example);

    int insert(Viewpersonguidepack record);

    int insertSelective(Viewpersonguidepack record);

    List<Viewpersonguidepack> selectByExample(ViewpersonguidepackExample example);

    int updateByExampleSelective(@Param("record") Viewpersonguidepack record, @Param("example") ViewpersonguidepackExample example);

    int updateByExample(@Param("record") Viewpersonguidepack record, @Param("example") ViewpersonguidepackExample example);
}