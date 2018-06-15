package com.health.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.ImplLoginBiz;
import com.health.biz.IntLoginBiz;
import com.health.entity.Worker;
import com.health.entity.WorkerExample;
import com.health.entity.WorkerExample.Criteria;

@Controller
public class ControlInvoke {

	/*
	 * 跳转模板 用户转发到自己需要的jsp 自己复制这个模板，修改请求路径action、修改 转发路径
	 * 
	 * @RequestMapping的action注解为 ：xxxx.action 注意jsp路径直接使用 jsp/xxxx.jsp
	 */

	@Resource
	private ImplLoginBiz impLoginBiz;   //后端接口-用于实现登陆
	
	@RequestMapping("invokeTest.action")
	public ModelAndView invokeTest() {
		ModelAndView mav = new ModelAndView("jsp/index");
		return mav;
	}

	/*
	 * 时间：2018.6.14 后台登陆界面显示
	 */
	@RequestMapping("loginJsp.action")
	public ModelAndView loginJsp() {
		System.out.println("1122");
		ModelAndView mav = new ModelAndView("jsp/loginBackend");
		return mav;
	}

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

  
}
