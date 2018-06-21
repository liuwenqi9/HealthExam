package com.health.clientBiz;

import org.springframework.stereotype.Service;

import com.health.entity.Account;

/**
 * 企业端的登陆接口
 * @date 6月20日
 * @author 毛聪
 */
@Service
public interface LoginClientBiz {

	public Account loginClient(Account account);
}
