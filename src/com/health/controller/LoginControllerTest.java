package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.entity.Account;
import com.health.entity.AccountExample;
import com.health.mapper.AccountMapper;

@Controller
public class LoginControllerTest {
	@Resource
	AccountMapper accountMapper;
	
	@RequestMapping("login.action")
	public ModelAndView login(String username,String password) {
		
		System.out.println(username);
		System.out.println(password);
		
		System.out.println("收到登录请求");
		ModelAndView mav = new ModelAndView("commonJsp/index.jsp");

		return mav;
	}
	
	
	@RequestMapping("toIndex.action")
	public ModelAndView toIndex() {
		System.out.println("启动index");
		ModelAndView mav = new ModelAndView("jsp/index");
		return mav;
	}
	

	public void queryAccount(Account account) {
		AccountExample example = new AccountExample();
		ArrayList<Account> acList = (ArrayList<Account>) accountMapper.selectByExample(example);
		System.out.println(acList.size());
		for (Account account2 : acList) {
			account2.getName();
		}
	}
	

}
