package com.health.mapper;

import com.health.entity.Detaildata;
import com.health.entity.DetaildataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DetaildataMapper {
    int countByExample(DetaildataExample example);

    int deleteByExample(DetaildataExample example);

    int deleteByPrimaryKey(Integer dataid);

    int insert(Detaildata record);

    int insertSelective(Detaildata record);

    List<Detaildata> selectByExample(DetaildataExample example);

    Detaildata selectByPrimaryKey(Integer dataid);

    int updateByExampleSelective(@Param("record") Detaildata record, @Param("example") DetaildataExample example);

    int updateByExample(@Param("record") Detaildata record, @Param("example") DetaildataExample example);

    int updateByPrimaryKeySelective(Detaildata record);

    int updateByPrimaryKey(Detaildata record);
}