package com.health.controller;

import org.junit.Test;
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

}
