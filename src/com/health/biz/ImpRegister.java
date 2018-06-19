package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.entity.AccountExample;
import com.health.entity.AccountExample.Criteria;
import com.health.entity.Location;
import com.health.mapper.AccountMapper;
import com.health.mapper.LocationMapper;
/**
 *  注册biz实现类
 * @author JSY
 * @date 20180615
 */
@Service
public class ImpRegister implements RegisterBiz {
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private AccountExample accountExample;	
	@Resource
	private LocationMapper locationMapper;
	//注册企业数据
	@Override
	public int addAccount(Account account) {
	
		return accountMapper.insert(account);
	}

	//通过企业名称查找企业对象
	@Override
	public List<Account> findAccountByName(String name) {
		accountExample.clear();
		Criteria criteria = accountExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<Account> list=accountMapper.selectByExample(accountExample);
		return list;
	}

	//通过企业账号查找企业对象
	@Override
	public List<Account> findAccountByAccount(String account) {
		accountExample.clear();
		Criteria criteria= accountExample.createCriteria();
		criteria.andAccountEqualTo(account);
		List<Account> list=accountMapper.selectByExample(accountExample);
		return list;
	}
	

	
		
	
	
}
