package com.health.mapper;

import com.health.entity.Cashflow;
import com.health.entity.CashflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashflowMapper {
    int countByExample(CashflowExample example);

    int deleteByExample(CashflowExample example);

    int deleteByPrimaryKey(Integer cashflowid);

    int insert(Cashflow record);

    int insertSelective(Cashflow record);

    List<Cashflow> selectByExample(CashflowExample example);

    Cashflow selectByPrimaryKey(Integer cashflowid);

    int updateByExampleSelective(@Param("record") Cashflow record, @Param("example") CashflowExample example);

    int updateByExample(@Param("record") Cashflow record, @Param("example") CashflowExample example);

    int updateByPrimaryKeySelective(Cashflow record);

    int updateByPrimaryKey(Cashflow record);
}