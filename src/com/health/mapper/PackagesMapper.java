package com.health.mapper;

import com.health.entity.Packages;
import com.health.entity.PackagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PackagesMapper {
    int countByExample(PackagesExample example);

    int deleteByExample(PackagesExample example);

    int deleteByPrimaryKey(Integer packageid);

    int insert(Packages record);

    int insertSelective(Packages record);

    List<Packages> selectByExample(PackagesExample example);

    Packages selectByPrimaryKey(Integer packageid);

    int updateByExampleSelective(@Param("record") Packages record, @Param("example") PackagesExample example);

    int updateByExample(@Param("record") Packages record, @Param("example") PackagesExample example);

    int updateByPrimaryKeySelective(Packages record);

    int updateByPrimaryKey(Packages record);
}