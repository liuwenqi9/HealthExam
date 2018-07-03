package com.health.mapper;

import com.health.entity.Exampeople;
import com.health.entity.ExampeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampeopleMapper {
    int countByExample(ExampeopleExample example);

    int deleteByExample(ExampeopleExample example);

    int insert(Exampeople record);

    int insertSelective(Exampeople record);

    List<Exampeople> selectByExample(ExampeopleExample example);
    
    //额外添加 --获取所有人员数据
    List<Exampeople> selsectAllPeople(ExampeopleExample example);
    
    //额外添加 -- 获取人员详细信息
    List<Exampeople> selectPeopleDetail(ExampeopleExample example);
    
    //额外添加 -- 人员信息
    List<Exampeople> selectPeopleMsg(ExampeopleExample example);

    int updateByExampleSelective(@Param("record") Exampeople record, @Param("example") ExampeopleExample example);

    int updateByExample(@Param("record") Exampeople record, @Param("example") ExampeopleExample example);
}