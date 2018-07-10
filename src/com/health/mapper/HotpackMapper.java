package com.health.mapper;

import com.health.entity.Hotpack;
import com.health.entity.HotpackExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface HotpackMapper {
	ArrayList<Hotpack>queryHot();
    int countByExample(HotpackExample example);

    int deleteByExample(HotpackExample example);

    int insert(Hotpack record);

    int insertSelective(Hotpack record);

    List<Hotpack> selectByExample(HotpackExample example);

    int updateByExampleSelective(@Param("record") Hotpack record, @Param("example") HotpackExample example);

    int updateByExample(@Param("record") Hotpack record, @Param("example") HotpackExample example);
}