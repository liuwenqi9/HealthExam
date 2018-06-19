package com.health.mapper;

import com.health.entity.Packitem;
import com.health.entity.PackitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PackitemMapper {
	
	String[] getItemIdsByPackageId(String packageId); //根据套餐id获取所有的项目ID
	
    int countByExample(PackitemExample example);

    int deleteByExample(PackitemExample example);

    int deleteByPrimaryKey(Integer packitemid);

    int insert(Packitem record);

    int insertSelective(Packitem record);

    List<Packitem> selectByExample(PackitemExample example);

    Packitem selectByPrimaryKey(Integer packitemid);

    int updateByExampleSelective(@Param("record") Packitem record, @Param("example") PackitemExample example);

    int updateByExample(@Param("record") Packitem record, @Param("example") PackitemExample example);

    int updateByPrimaryKeySelective(Packitem record);

    int updateByPrimaryKey(Packitem record);
}