package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlInvoke {
	
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
	 * @author罗杭春，6月14日
	 */
	@RequestMapping("AccountMg.action")
	public ModelAndView accountMg() {
		System.out.println("调用系统管理界面");
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/accountMg");
		return mav;
	}

}
