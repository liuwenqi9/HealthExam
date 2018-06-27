package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.health.biz.DeptService;
import com.health.entity.Dept;
import com.health.util.PageUtil;

@Controller
public class DepMgController {

	@Resource
	private DeptService deptService;
	
	@Resource
	private Dept dept;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> deptMsg = new HashMap<String, Object>(); //ajax数据回传
	
	
	//加载科室
	public Map<String, Object> loadingDept() {
		
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
	
	@RequestMapping(value = "/deptMg.action")
	public String depMg() {		
		return "jsp/systemMgJsp/deptMg";		
	}
	
	@RequestMapping(value = "/loadDept.action")
	public @ResponseBody Map<String, Object> loadDept() {		
		//加载科室
		deptMsg = loadingDept();
	    
		return deptMsg;
	}
		
	@RequestMapping(value = "/addDeptMg.action")
	public @ResponseBody Map<String, Object> addDepMg(String deptname) {
		
		//查询是否科室重复
		List<Dept> list = deptService.isDeptReapt(deptname);
		
		if(list.size() == 0) {			
			//增加科室
			dept.setDeptname(deptname);
			dept.setState(0);
			deptService.addDept(dept);
			//重新加载科室
			deptMsg = loadingDept();
			
		}else {
			deptMsg.put("dept", "Exist");
		}
		
		return deptMsg;
	}
	
	@RequestMapping(value = "/changeDepMg.action")
	public @ResponseBody Dept changeName(Dept dept) {
		
		//查询是否科室重复
		String deptname = (String) dept.getDeptname();
		List<Dept> list = deptService.isDeptReapt(deptname);

		if(list.size() == 0) {			
			//科室更改
			deptService.updateDelt(dept);				
		}else {
			dept.setDeptname("Exist");
		}
				
		return dept;
	}
	
	@RequestMapping(value = "/deletDepMg.action")
	public @ResponseBody Map<String, Object> deltDept(Dept dept){
				
		//删除科室
		dept.setState(1);
		deptService.delDept(dept);
		//重新加载科室
		deptMsg = loadingDept();
		return deptMsg;
	}
	
	@RequestMapping(value = "/searchDepMg.action")
	public @ResponseBody Map<String, Object> checkDept(String deptname){			
		//搜索科室	
		PageHelper.startPage(1, dataNum);
		List<Dept> list = deptService.serachDept(deptname);		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		deptMsg.clear();
		//数据
		deptMsg.put("depModel", list);
		deptMsg.put("pageContanier", pageContanier);
		return deptMsg;
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
		List<Object> pageContanier = PageUtil.displayPage(list, Integer.parseInt(currentPage));		
		//数据
		deptMsg.put("depModel", list);
		deptMsg.put("pageContanier", pageContanier);
		
		return deptMsg;
	}
	
}
