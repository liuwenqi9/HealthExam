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
	@Resource
	AccountExample acountExample;

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
		ArrayList<Account> acList = (ArrayList<Account>) accountMapper.selectByExample(acountExample);
		return acList;
	}

	/*
	 * 实现查询所有的账户的方法
	 * @author 罗杭春
	 * @date 6月14日
	 */
	@Override
	public int changeAccountState(HashMap<String, String> dataMap) {
		int result = accountMapper.changeAccountState(dataMap);
		return result;
	}


	/*
	 * 根据一个账户id号来查询账户
	 * @author 罗杭春   6月21日
	 * @param 一个账户ID号
	 * @return 返回一个账户对象
	 */
	@Override
	public Account queryAccountById(String accountId) {
		return accountMapper.queryAccountById(accountId);

	}
	@Override
	public ArrayList<Account> queryAccount(Account account) {
		ArrayList<Account> queryListAcc=accountMapper.queryAccountName(account);
		
		return queryListAcc;

	}

	@Override
	public int updateAcName(Account account) {
		int resultUpName= accountMapper.updateAcName(account);
		return resultUpName;
	}
}
