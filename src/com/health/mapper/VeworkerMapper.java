package com.health.mapper;

import com.health.entity.Veworker;
import com.health.entity.VeworkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface VeworkerMapper {
    int countByExample(VeworkerExample example);

    int deleteByExample(VeworkerExample example);

    int insert(Veworker record);

    int insertSelective(Veworker record);

    List<Veworker> selectByExample(VeworkerExample example);

    int updateByExampleSelective(@Param("record") Veworker record, @Param("example") VeworkerExample example);

    int updateByExample(@Param("record") Veworker record, @Param("example") VeworkerExample example);
}