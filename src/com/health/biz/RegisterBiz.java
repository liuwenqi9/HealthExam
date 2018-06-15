package com.health.biz;

import java.util.List;

import com.health.entity.Account;
/**
 * 
 * @author JSY
 *
 */
public interface RegisterBiz {
		//注册
		public int addAccount(Account account);
		//查找
		public List<Account> findAccountByName(String name);
		
}
