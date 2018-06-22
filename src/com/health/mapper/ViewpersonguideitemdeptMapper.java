package com.health.mapper;

import com.health.entity.Viewpersonguideitemdept;
import com.health.entity.ViewpersonguideitemdeptExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ViewpersonguideitemdeptMapper {
    int countByExample(ViewpersonguideitemdeptExample example);

    int deleteByExample(ViewpersonguideitemdeptExample example);

    int insert(Viewpersonguideitemdept record);

    int insertSelective(Viewpersonguideitemdept record);

    List<Viewpersonguideitemdept> selectByExample(ViewpersonguideitemdeptExample example);

    int updateByExampleSelective(@Param("record") Viewpersonguideitemdept record, @Param("example") ViewpersonguideitemdeptExample example);

    int updateByExample(@Param("record") Viewpersonguideitemdept record, @Param("example") ViewpersonguideitemdeptExample example);

    public ArrayList<Viewpersonguideitemdept> getOrderInfo(String account);   //获取所有的已经预定体检的项目详细信息
    
}