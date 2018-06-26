
package com.health.mapper;

import com.health.entity.Guide;
import com.health.entity.GuideExample;
import com.health.entity.Mysettleview;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
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
    
    int getMaxGuideId(); //获取导检表中现在ID号的最大值

	int insertGuide(Guide currentGuide);  //用于插入一条导检信息记录
	
	int updateBatch(List<Mysettleview> list); //批量更新
}