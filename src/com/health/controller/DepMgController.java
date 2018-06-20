package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.biz.DeptService;
import com.health.entity.Dept;
import com.health.util.PageUtil;

import org.springframework.ui.Model;

@Controller
public class DepMgController {

	@Resource
	private DeptService deptService;
	
	@Resource
	private Dept dept;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> deptMsg = new HashMap<String, Object>(); //ajax数据回传
	
	@RequestMapping(value = "/deptMg.action")
	public String depMg() {
		
		return "jsp/systemMgJsp/deptMg";		
	}
	
	@RequestMapping(value = "/loadDept.action")
	public @ResponseBody Map<String, Object> loadDept() {		
		//显示科室
		PageHelper.startPage(1, dataNum);
		List<Dept> list = deptService.checkDepts();	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		deptMsg.clear();
		//数据
		deptMsg.put("depModel", list);
		deptMsg.put("pageContanier", pageContanier);	
	    
		return deptMsg;
	}
		
	@RequestMapping(value = "/addDeptMg.action")
	public @ResponseBody List<Dept> addDepMg(Model model, String deptname) {
		
		//增加科室
		dept.setDeptname(deptname);
		deptService.addDept(dept);
		//查找科室
		List<Dept> list = deptService.checkDepts();
		model.addAttribute("list", list);
		
		return list;
	}
	
	@RequestMapping(value = "/changeDepMg.action")
	public @ResponseBody Dept changeName(Dept dept) {
		//科室更改
		deptService.updateDelt(dept);		
		return dept;
	}
	
	@RequestMapping(value = "/deletDepMg.action")
	public @ResponseBody List<Dept> deltDept(String deptid){
				
		//删除科室
		deptService.delDept(Integer.parseInt(deptid));
		//查找科室
		List<Dept> list = deptService.checkDepts();
		return list;
	}
	
	@RequestMapping(value = "/searchDepMg.action")
	public @ResponseBody List<Dept> checkDept(String deptname){			
		//搜索科室	
		List<Dept> list = deptService.serachDept(deptname);
		return list;
	}
	
	@RequestMapping(value = "/pageItem.action")
	public @ResponseBody Map<String, Object> pageMethod(String deptname, String currentPage){
		
		deptMsg.clear(); //清空历史分页参数
		//判断是否携带搜索条件
		List<Dept> list;
		if(deptname.equals("")) {			
			PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
			list = deptService.checkDepts();
			
		}else {			
			PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
			list = deptService.serachDept(deptname);
		}
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		//数据
		deptMsg.put("depModel", list);
		deptMsg.put("pageContanier", pageContanier);
		
		return deptMsg;
	}
	
}
