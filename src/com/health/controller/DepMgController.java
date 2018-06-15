package com.health.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.biz.DeptService;
import com.health.entity.Dept;

import org.springframework.ui.Model;

@Controller
public class DepMgController {

	@Resource
	private DeptService deptService;
	
	@Resource
	private Dept dept;
	
	@RequestMapping(value = "/deptMg.action")
	public String depMg(Model model) {
		
		//显示科室
		List<Dept> list = deptService.checkDepts();
		model.addAttribute("list", list);
		return "jsp/systemMgJsp/deptMg";		
	}
	
	
	@RequestMapping(value = "/addDeptMg.action")
	public String addDepMg(Model model, String deptname) {
		
		//增加科室
		dept.setDeptname(deptname);
		deptService.addDept(dept);
		//查找科室
		List<Dept> list = deptService.checkDepts();
		model.addAttribute("list", list);
		
		return "jsp/systemMgJsp/deptMg";
	}
	
	@RequestMapping(value = "/changeDepMg.action")
	public @ResponseBody Dept changeName(Dept dept) {
		
		System.out.println("deptname" + dept.getDeptname());
//		dept.setDeptname(deptname);
//		deptService.updateDelt(dept);
		
		return dept;
	}
	
}
