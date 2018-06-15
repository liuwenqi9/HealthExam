package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.entity.AccountExample;
import com.health.entity.AccountExample.Criteria;
import com.health.mapper.AccountMapper;
/**
 * 
 * @author JSY
 *
 */
@Service
public class ImpRegister implements RegisterBiz {
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private AccountExample accountExample;	
	
	@Override
	public int addAccount(Account account) {
	
		return accountMapper.insert(account);
	}


	@Override
	public List<Account> findAccountByName(String name) {
		
		Criteria criteria = accountExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<Account> list=accountMapper.selectByExample(accountExample);
		return list;
	}


		
	
	
}
