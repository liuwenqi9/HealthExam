package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.WorkerMgBiz;
import com.health.entity.Worker;

/**
 * 工作人员管理
 * @author 范帅
 * @date 6月18日
 *
 */
@Controller

public class WorkControl {
	@Resource
	WorkerMgBiz implWorkerMg;
	/**
	 * 主界面点击系统管理->人员设置选项的时候进行的页面跳转
	 * @author 范帅
	 * @date 6月18日
	 * 
	 */
	@RequestMapping("workerMg.action")
	public ModelAndView getWorkerMg() {
		ArrayList<Worker>wkList = implWorkerMg.queryWorkerList();
		System.out.println(wkList);
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/workerMg");
		mav.addObject("wkList",wkList);
		return mav;
	}
	/**
	 * 修改用户状态启用/禁用
	 * Ajax
	 * @author 范帅
	 * @date 6月20日
	 */
	@RequestMapping("changeWorkerState.action")
	public void changeWorkerState(HttpServletResponse response,String workerid,String state) throws IOException	 {
		System.out.println(state+"前");
		state = (state.equals("1"))?"0":"1";   //修改要设置的状态		
		HashMap<String, String>dataMap = new HashMap<>();
		dataMap.put("workerid", workerid);
		dataMap.put("state", state);
		int result = implWorkerMg.changeWorkerState(dataMap);
		System.out.println(result);
		
		//以打印流输出
		PrintWriter out = null;
		out = response.getWriter();
		out.print(result);
		out.close();
		
	}
	

}
