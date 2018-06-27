package com.health.mapper;

import com.health.entity.Mysettleview;
import com.health.entity.MysettleviewExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MysettleviewMapper {
    int countByExample(MysettleviewExample example);

    int deleteByExample(MysettleviewExample example);

    int insert(Mysettleview record);

    int insertSelective(Mysettleview record);

    List<Mysettleview> selectByExample(MysettleviewExample example);
    
    //手动添加
    List<Mysettleview> selectAllData(MysettleviewExample example); //获取所有订单数据
    List<Mysettleview> selectRecorderDetail(MysettleviewExample example); //获取订单详情
    Mysettleview selectTotalPrice(MysettleviewExample example); //获取订单总价和实际消费价格
    List<Mysettleview> selectNotGuide(MysettleviewExample example); //找出未体检人员
    
    int updateByExampleSelective(@Param("record") Mysettleview record, @Param("example") MysettleviewExample example);

    int updateByExample(@Param("record") Mysettleview record, @Param("example") MysettleviewExample example);
}