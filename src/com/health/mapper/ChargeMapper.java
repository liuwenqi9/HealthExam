package com.health.mapper;

import com.health.entity.Account;
import com.health.entity.Charge;
import com.health.entity.ChargeExample;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ChargeMapper {
    int countByExample(ChargeExample example);

    int deleteByExample(ChargeExample example);

    int deleteByPrimaryKey(Integer chargeid);

    int insert(Charge record);
    
    Account queryMoney(Charge charge);  //通过企业账号查找账户余额
    
    int updateMoney(Account account);  //通过企业账号修改账户余额
    
    int updateState(Charge charge);    //修改账单状态

    int insertSelective(Charge record);
    
    List<Charge>  queryBill();

    List<Charge> selectByExample(ChargeExample example);

    Charge selectByPrimaryKey(Integer chargeid);

    int updateByExampleSelective(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByExample(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);

	int insertCharge(Charge currentCharge);  //用于插入一条订单记账信息

	String getMaxChargeId();  //获取现在订单记账的ID最大值

	void updateAmountOfCharge(HashMap<String, Object> updateCostMap); //用于修改订单记账表的账目额度
}