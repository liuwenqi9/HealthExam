package com.health.mapper;

import com.health.entity.Viewguideinfo;
import com.health.entity.ViewguideinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ViewguideinfoMapper {
    int countByExample(ViewguideinfoExample example);

    int deleteByExample(ViewguideinfoExample example);

    int insert(Viewguideinfo record);

    int insertSelective(Viewguideinfo record);

    List<Viewguideinfo> selectByExample(ViewguideinfoExample example);

    int updateByExampleSelective(@Param("record") Viewguideinfo record, @Param("example") ViewguideinfoExample example);

    int updateByExample(@Param("record") Viewguideinfo record, @Param("example") ViewguideinfoExample example);
}