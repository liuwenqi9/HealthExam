package com.health.mapper;

import com.health.entity.Personinfo;
import com.health.entity.PersoninfoExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PersoninfoMapper {
	
	ArrayList<Personinfo> getPersonList(String account); //实现获取特定账户下的所有员工列表
	
    int countByExample(PersoninfoExample example);

    int deleteByExample(PersoninfoExample example);

    int deleteByPrimaryKey(Integer personinfoid);

    int insert(Personinfo record);

    int insertSelective(Personinfo record);

    List<Personinfo> selectByExample(PersoninfoExample example);

    Personinfo selectByPrimaryKey(Integer personinfoid);

    int updateByExampleSelective(@Param("record") Personinfo record, @Param("example") PersoninfoExample example);

    int updateByExample(@Param("record") Personinfo record, @Param("example") PersoninfoExample example);

    int updateByPrimaryKeySelective(Personinfo record);

    int updateByPrimaryKey(Personinfo record);
}