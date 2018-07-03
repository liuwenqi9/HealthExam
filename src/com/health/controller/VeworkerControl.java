package com.health.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.DeptService;
import com.health.biz.RoleMgBiz;
import com.health.biz.VeworkerMgBiz;
import com.health.entity.Dept;
import com.health.entity.Role;
import com.health.entity.Veworker;
import com.sun.org.apache.regexp.internal.recompile;
@Controller
public class VeworkerControl {
	
	/**
	 * 工作人员管理再版
	 * @author 范帅
	 */
	@Resource
	VeworkerMgBiz implVeworkerMg;
	@Resource
	DeptService impiDeptMg;
	@Resource
	RoleMgBiz implRoleMg;
	PrintWriter printWriter;
	
	@Resource
	private Map<String,Object> billMsg;
	
	/**
	 * 点击进行跳转
	 * @author 范帅
	 */
	@RequestMapping("workerMg.action")
	public ModelAndView getWorkerMg( String name) {
		System.out.println("新的一个worker。。。。。。。。。。。。。。。。。。。。。。。");
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/workerMg");
		if (name == null) {
			ArrayList<Veworker>wkList = implVeworkerMg.queryWorkerList();
			ArrayList<Dept>dpList = (ArrayList<Dept>) impiDeptMg.checkDepts();
			ArrayList<Role>rlList = implRoleMg.queryRoleList();
			mav.addObject("wkList",wkList);
			mav.addObject("dpList",dpList);
			mav.addObject("rlList",rlList);
		}
		return mav;
	}
	

}
