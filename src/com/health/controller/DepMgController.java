package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.health.biz.DeptService;
import com.health.entity.Dept;

import org.springframework.ui.Model;

@Controller
public class DepMgController {

	@Resource
	private DeptService deptService;
	
	@Resource
	private Dept dept;
	
	private int dataNum = 1; //每页显示数据
	private Map<String, Object> deptMsg = new HashMap<String, Object>();
	
	@RequestMapping(value = "/deptMg.action")
	public String depMg() {
		
		return "jsp/systemMgJsp/deptMg";		
	}
	
	@RequestMapping(value = "/loadDept.action")
	public @ResponseBody Map<String, Object> loadDept() {		
		//显示科室
		PageHelper.startPage(1, dataNum);
		List<Dept> list = deptService.checkDepts();		
		PageInfo pageInfo = new PageInfo<>(list);
		
		deptMsg.clear();
		//数据
		deptMsg = new HashMap<String, Object>();
		deptMsg.put("depModel", list);
		deptMsg.put("pageInfo", pageInfo);	
		
	    long totalCount = pageInfo.getTotal();  
	    System.out.println("总记录数："+totalCount);  
	    int pages = pageInfo.getPages();  
	    System.out.println("总页数："+pages);  
	    int pageSize = pageInfo.getPageSize();  
	    System.out.println("每页展示数："+pageSize);  
	    int lastPage = pageInfo.getNavigateFirstPage();  
	    System.out.println("首页："+lastPage);  
	    int nextPage = pageInfo.getNextPage();  
	    System.out.println("下一页："+nextPage);
	    
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
		
		deptMsg.clear();
		//判断是否携带搜索条件
		if(deptname.equals("")) {
			
			PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
			List<Dept> list = deptService.checkDepts();
			PageInfo pageInfo = new PageInfo<>(list);
			deptMsg.put("depModel", list);
			deptMsg.put("pageInfo", pageInfo);
			
		}else {
			
			PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
			List<Dept> list = deptService.serachDept(deptname);
			PageInfo pageInfo = new PageInfo<>(list);
			deptMsg.put("depModel", list);
			deptMsg.put("pageInfo", pageInfo);	
		}
		return deptMsg;
	}
	
}
