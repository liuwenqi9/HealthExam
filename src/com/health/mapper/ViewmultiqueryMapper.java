package com.health.mapper;

import com.health.entity.Viewmultiquery;
import com.health.entity.ViewmultiqueryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewmultiqueryMapper {
    int countByExample(ViewmultiqueryExample example);

    int deleteByExample(ViewmultiqueryExample example);

    int insert(Viewmultiquery record);

    int insertSelective(Viewmultiquery record);

    List<Viewmultiquery> selectByExample(ViewmultiqueryExample example);

    int updateByExampleSelective(@Param("record") Viewmultiquery record, @Param("example") ViewmultiqueryExample example);

    int updateByExample(@Param("record") Viewmultiquery record, @Param("example") ViewmultiqueryExample example);
    
    List<Viewmultiquery> selectByMultiCondition(Viewmultiquery multiCondition);   //根据多个条件进行查询
    
}