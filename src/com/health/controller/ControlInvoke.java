package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.ImplAccountMg;
import com.health.entity.Account;

@Controller
public class ControlInvoke {
	
	@Resource
	ImplAccountMg ImplAccountMg;
	/*
	 * 跳转模板 用户转发到自己需要的jsp
	 * 自己复制这个模板，修改请求路径action、修改 转发路径
	 * @RequestMapping的action注解为 ：xxxx.action
	 * 注意jsp路径直接使用  jsp/xxxx.jsp
	 */

	@RequestMapping("invokeTest.action")
	public ModelAndView invokeTest() {
		ModelAndView mav = new ModelAndView("jsp/index");
		return mav;
	}
	
	/*
	 * 主界面点击系统设置->“团检单位设置”选项的时候请求的页面
	 * @author罗杭春
	 * @date6月14日
	 */
	@RequestMapping("AccountMg.action")
	public ModelAndView accountMg() {
		System.out.println("切换账户设置界面");
		ArrayList<Account> acList = ImplAccountMg.queryAccountList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");
		mav.addObject("acList", acList);
		return mav;
	}

}
