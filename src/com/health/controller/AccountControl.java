package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.AccountMgBiz;
import com.health.entity.Account;

@Controller
public class AccountControl {

	@Resource
	AccountMgBiz implAccountMg;
	
	/*
	 * 主界面点击系统设置->“团检单位设置”选项的时候请求的页面
	 * @author罗杭春
	 * @date 6月14日
	 */
	@RequestMapping("AccountMg.action")
	public ModelAndView getAccountMg() {
		ArrayList<Account> acList = implAccountMg.queryAccountList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");
		mav.addObject("acList", acList);
		return mav;
	}
	
	
	/*
	 * 团检单位设置功能的修改账户状态
	 * @author罗杭春
	 * @date 6月14日
	 */
	@RequestMapping("changeAccountState.action")
	public void changeAccountState(HttpServletResponse response,String accountId, String state) throws IOException {
		state = (state.equals("1"))?"0":"1";   //修改要设置的状态
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("accountId", accountId);
		dataMap.put("state", state);
		
		int result = implAccountMg.changeAccountState(dataMap);
		
		PrintWriter out= null;
		out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
	}
}
