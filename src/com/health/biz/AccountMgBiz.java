package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.health.entity.Account;

/*
 * 账户管理模块的接口
 * @author 罗杭春
 * @date 6月14日
 */
@Service
public interface AccountMgBiz {
	
	public int insertAccount(); //用于后台管理员手动开通一个团体账户（企业用户）
	
	public int deleteAccount(String accountId); //用于后台管理员手动删除一个团体账户（企业用户）
	
	public Account queryOneAccount(Account account); //用于后台管理员根据账号或者状态查询一个团体账户（企业用户）
	
	public int updateAccount(String account);   //用于后台管理员根据账号修改一个团体账户（企业用户）
	
	public ArrayList<Account> queryAccountList();
	
	public int changeAccountState(HashMap<String, String> dataMap);

}
