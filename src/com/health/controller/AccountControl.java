package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * 
	 * @author罗杭春
	 * 
	 * @date 6月14日
	 * 
	 * 
	 * 增加团检单位 模糊查询  当name不为null时，进行模糊查询
	 * @author 毛聪
	 * @date 6月22日
	 */
	
	@RequestMapping("AccountMg.action")
	public ModelAndView getAccountMg(String name) {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");	
	    System.out.println(name);
		if (name==null) {
			ArrayList<Account> acList = implAccountMg.queryAccountList();
			mav.addObject("acList", acList);
		} else {

			ArrayList<Account> resultList = implAccountMg.queryAccount("%"+name+"%");
			mav.addObject("acList", resultList);
		}
		return mav;
	}

	/*
	 * 团检单位设置功能的修改账户状态
	 * 
	 * @author罗杭春
	 * 
	 * @date 6月14日
	 */
	@RequestMapping("changeAccountState.action")
	public void changeAccountState(HttpServletResponse response, String accountId, String state) throws IOException {
		state = (state.equals("1")) ? "0" : "1"; // 修改要设置的状态
		HashMap<String, String> dataMap = new HashMap<>();
		dataMap.put("accountId", accountId);
		dataMap.put("state", state);

		int result = implAccountMg.changeAccountState(dataMap);

		PrintWriter out = null;
		out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	/*
	 * 团检单位设置功能的条件查询
	 * 
	 * @author毛聪
	 * 
	 * @date 6月21日
	 */
	@RequestMapping("queryAccount.action")
	public ModelAndView queryAccount(Account account) {
//		System.out.println("团检单位设置功能的条件查询:" + account.getName());
//		ArrayList<Account> resultList = implAccountMg.queryAccount(account.getName());
//		if (resultList.size() > 0) {
//			ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");
//			mav.addObject("acList", resultList);
//			return mav;
//		}
		return null;
	}
}
