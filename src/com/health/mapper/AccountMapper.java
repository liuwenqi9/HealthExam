package com.health.mapper;


import com.health.entity.Account;
import com.health.entity.AccountExample;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountMapper {
	
	public Account loginClient(Account account);  //登陆
	
	public ArrayList<Account> queryAccountName(Account account);  //团检单位模糊查询
	
	int updateAcName(Account account);    //团检单位名称修改
	
	int updatePwd(Account account);        //团检单位修改密码
	
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Object account);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Object account);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
	int changeAccountState(HashMap<String, String> dataMap);

	ArrayList<Account> queryAccountList();

	Account queryAccountById(String accountId); //根据ID号查找一个企业账号

}