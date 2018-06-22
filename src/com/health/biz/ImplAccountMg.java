package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.entity.AccountExample;
import com.health.mapper.AccountMapper;

@Service
public class ImplAccountMg implements AccountMgBiz {

	@Resource
	AccountMapper accountMapper;

	@Override
	public int insertAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account queryOneAccount(Account account) {

		return null;
	}

	@Override
	public int updateAccount(String account) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * 实现查询所有的账户的方法
	 * @author 罗杭春
	 * @date 6月14日
	 */
	@Override
	public ArrayList<Account> queryAccountList() {
		//方式1：使用Example来查询
		AccountExample example = new AccountExample();
		ArrayList<Account> acList = (ArrayList<Account>) accountMapper.selectByExample(example);

		//方式2：使用自定义的映射语句
//		ArrayList<Account> accountList = accountMapper.queryAccountList();
		return acList;
	}


	@Override
	public int changeAccountState(HashMap<String, String> dataMap) {
		int result = accountMapper.changeAccountState(dataMap);
		return result;
	}

	@Override
	public ArrayList<Account> queryAccount(String name) {
		ArrayList<Account> queryListAcc=accountMapper.queryAccountName(name);
		
		return queryListAcc;
	}
}
