package com.health.mapper;

import com.health.entity.Account;
import com.health.entity.AccountExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

 

	ArrayList<Account> queryAccountList(); // 查询所有的账户的方法

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
}