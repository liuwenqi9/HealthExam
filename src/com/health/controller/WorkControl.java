package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.WorkerMgBiz;
import com.health.entity.Worker;
import com.health.entity.WorkerExample.Criteria;
import com.health.util.PageUtil;

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
	PrintWriter printWriter;
	
	private int dataNum = 10; //每页显示数据
	@Resource
	private Map<String, Object> billMsg; //ajax数据回传
	/**
	 * 主界面点击系统管理->人员设置选项的时候进行的页面跳转
	 * @author 范帅
	 * @date 6月18日
	 * 
	 */
	@RequestMapping("workerMg.action")
	public ModelAndView getWorkerMg( String name) {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/workerMg");;
		if (name==null) {
			ArrayList<Worker>wkList = implWorkerMg.queryWorkerList();
			mav.addObject("wkList",wkList);
		} else {
			ArrayList<Worker>resultList = implWorkerMg.queryWorker("%"+name+"%");
			mav.addObject("wkList",resultList);
		}
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
		//以打印流输出
		PrintWriter out = null;
		out = response.getWriter();
		out.print(result);
		out.close();
		
	}
	/**
	 * 新增人员功能
	 * @author 范帅
	 * @date 6月25日
	 */
	@RequestMapping("insertworkerMg.action")
	public void  insertWorker(HttpServletResponse response, Worker worker) throws IOException {
		printWriter = response.getWriter();
		int lengthid = implWorkerMg.lengthid();
		worker.setWorkerid(lengthid+1);
		int i = implWorkerMg.insertWorker(worker);
		if (i!=-1) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("增加成功");
		} else {
			printWriter.println("FAIL");
			printWriter.flush();
			printWriter.close();
			System.out.println("增加失败");
		}
		
	}
	/**
	 * 删除员工
	 * @author 范帅
	 * @date 6月25日
	 */
	@RequestMapping("deletworkerMg.action")
	public void deleteWorker(HttpServletResponse response, String name) throws IOException {
		int delResult = 0;
		delResult = implWorkerMg.deleteWork(name);
		System.out.println(delResult);
		printWriter = response.getWriter();
		if (delResult>0) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("ok");
		} else {
			printWriter.println("FAIL");
			printWriter.flush();
			printWriter.close();
			System.out.println("fail");
			
		}
	}
	@RequestMapping("selectWorkerByState.action")
	public ModelAndView selectWorkerByState( String state) {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/workerMg");
		System.out.println("状态名字为："+state);
		ArrayList<Worker>resultList = implWorkerMg.queryWorkerState("%"+state+"%");
		mav.addObject("wkList",resultList);
		return mav;
	}


}
