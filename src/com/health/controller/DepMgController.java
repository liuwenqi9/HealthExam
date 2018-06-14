package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class DepMgController {

	@RequestMapping(value = "depMg.action")
	public String depMg(Model model) {
		
		return "/systemMg/deptMg";		
	}
}
