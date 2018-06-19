package com.health.mapper;

import com.health.entity.Chargepack;
import com.health.entity.ChargepackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ChargepackMapper {
    int countByExample(ChargepackExample example);

    int deleteByExample(ChargepackExample example);

    int deleteByPrimaryKey(Integer chargepackid);

    int insert(Chargepack record);

    int insertSelective(Chargepack record);

    List<Chargepack> selectByExample(ChargepackExample example);

    Chargepack selectByPrimaryKey(Integer chargepackid);

    int updateByExampleSelective(@Param("record") Chargepack record, @Param("example") ChargepackExample example);

    int updateByExample(@Param("record") Chargepack record, @Param("example") ChargepackExample example);

    int updateByPrimaryKeySelective(Chargepack record);

    int updateByPrimaryKey(Chargepack record);
}