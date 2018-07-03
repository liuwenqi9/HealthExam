package com.health.clientBiz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.mapper.AccountMapper;

/*
 * 时间:2018.6.20
 * 企业端登陆接口实现类
 * @author 毛聪
 */
@Service
public class ImplLoginClientBiz implements LoginClientBiz {
	@Resource
	private AccountMapper accountMapper;
	
	@Override
	public Account loginClient(Account account) {
		Account ac=accountMapper.loginClient(account);
	  
		System.out.println("查找ac："+ac);
		return ac;
	}

	@Override
	public int updatePwd(Account account) {
	   int updateRs	=accountMapper.updatePwd(account);
		return updateRs;
	}

}
