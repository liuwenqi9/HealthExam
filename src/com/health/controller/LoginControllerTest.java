package com.health.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginControllerTest {

	
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
		ModelAndView mav = new ModelAndView("jsp/index");

		return mav;
	}
	

}
