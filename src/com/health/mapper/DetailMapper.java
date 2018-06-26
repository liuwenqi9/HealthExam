package com.health.mapper;

import com.health.entity.Detail;
import com.health.entity.DetailExample;
import com.health.entity.Parameter;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
@Repository
public interface DetailMapper {
    int countByExample(DetailExample example);

    int deleteByExample(DetailExample example);

    int deleteByPrimaryKey(Integer detailid);

    int insert(Detail record);

    int insertSelective(Detail record);

    List<Detail> selectByExample(DetailExample example);

    Detail selectByPrimaryKey(Integer detailid);

    int updateByExampleSelective(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByExample(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
    
    List<Detail> selectPageList(@Param("sItemName") String sItemName);
    
    List<Parameter> selectAllParameter();
    
    List<Detail> selectByItemId(Integer itemId);
}