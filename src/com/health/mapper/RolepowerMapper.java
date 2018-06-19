package com.health.mapper;

import com.health.entity.Rolepower;
import com.health.entity.RolepowerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RolepowerMapper {
    int countByExample(RolepowerExample example);

    int deleteByExample(RolepowerExample example);

    int deleteByPrimaryKey(Integer rolepowerid);

    int insert(Rolepower record);

    int insertSelective(Rolepower record);

    List<Rolepower> selectByExample(RolepowerExample example);

    Rolepower selectByPrimaryKey(Integer rolepowerid);

    int updateByExampleSelective(@Param("record") Rolepower record, @Param("example") RolepowerExample example);

    int updateByExample(@Param("record") Rolepower record, @Param("example") RolepowerExample example);

    int updateByPrimaryKeySelective(Rolepower record);

    int updateByPrimaryKey(Rolepower record);
}