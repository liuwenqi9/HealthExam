package com.health.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.health.entity.Personinfo;
import com.health.entity.PersoninfoExample;
@Repository
public interface PersoninfoMapper {
	
	List<Personinfo> employeeList(String account);
	
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