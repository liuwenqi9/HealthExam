package com.health.mapper;

import com.health.entity.Detaildataview;
import com.health.entity.DetaildataviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DetaildataviewMapper {
    int countByExample(DetaildataviewExample example);

    int deleteByExample(DetaildataviewExample example);

    int insert(Detaildataview record);

    int insertSelective(Detaildataview record);

    List<Detaildataview> selectByExample(DetaildataviewExample example);

    int updateByExampleSelective(@Param("record") Detaildataview record, @Param("example") DetaildataviewExample example);

    int updateByExample(@Param("record") Detaildataview record, @Param("example") DetaildataviewExample example);
}