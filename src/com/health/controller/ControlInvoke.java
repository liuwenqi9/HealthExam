package com.health.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.health.biz.ImplAccountMg;
import com.health.biz.ImplLoginBiz;
import com.health.entity.Account;
import com.health.entity.Worker;


@Controller
public class ControlInvoke {


	@Resource
	ImplAccountMg ImplAccountMg;


	/*
	 * 跳转模板 用户转发到自己需要的jsp 自己复制这个模板，修改请求路径action、修改 转发路径
	 * 
	 * @RequestMapping的action注解为 ：xxxx.action 注意jsp路径直接使用 jsp/xxxx.jsp
	 */

	@Resource
	private ImplLoginBiz impLoginBiz; // 后端接口-用于实现登陆

	@RequestMapping("invokeTest.action")
	public ModelAndView invokeTest() {
		ModelAndView mav = new ModelAndView("jsp/index");
		return mav;
	}

	/*
	 * 主界面点击系统设置->“团检单位设置”选项的时候请求的页面
	 * 
	 * @author罗杭春，6月14 日
	 */
	@RequestMapping("AccountMg.action")
	public ModelAndView accountMg() {
		System.out.println("切换账户设置界面");
		ArrayList<Account> acList = ImplAccountMg.queryAccountList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");
		mav.addObject("acList", acList);
		return mav;
	}


	/*
	 * 时间：2018.6.14 后台界面显示
	 */
	@RequestMapping("loginJsp.action")
	public ModelAndView loginJsp() {
		System.out.println("1122");
		ModelAndView mav = new ModelAndView("jsp/loginBackend");
		return mav;
	}

	 /*
	 * 时间：2018.6.14 后台登陆跳转
	 * 毛聪
	 */
	 @RequestMapping("loginAdmin.action")
	 public ModelAndView loginAdmin(Worker worker) {
	 System.out.println(worker.getName()+""+worker.getPassword());
	 Worker login= impLoginBiz.loginAdmin(worker);
	 if(login!=null) {
	
	 ModelAndView mav = new ModelAndView("jsp/index");
	
	 return mav;
	 }
	 return null;
	
	 }
//	@RequestMapping("loginAdmin.action")
//	public String loginAdmin(HttpServletResponse response,Worker worker) throws IOException {
//		System.out.println(worker.getName() + "" + worker.getPassword());
//		Worker login = impLoginBiz.loginAdmin(worker);
//		PrintWriter printWriter = response.getWriter();
//		if (login != null) {
//			printWriter.print("OK");
//			printWriter.flush();
//			printWriter.close();
//
//			System.out.println("走到了admin");
//		
//		}
//
//		return "FAIL";
//
//	}

}
