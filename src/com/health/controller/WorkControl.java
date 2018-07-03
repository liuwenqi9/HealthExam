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

import com.health.biz.DeptService;
import com.health.biz.RoleMgBiz;
import com.health.biz.WorkerMgBiz;
import com.health.biz.WorkerroleMgBiz;
import com.health.entity.Dept;
import com.health.entity.Role;
import com.health.entity.Worker;
import com.health.entity.WorkerExample.Criteria;
import com.health.entity.Workerrole;
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
	@Resource
	WorkerroleMgBiz implWorkerroleBiz;
	PrintWriter printWriter;
	
	private int dataNum = 10; //每页显示数据
	@Resource
	private Map<String, Object> billMsg; //ajax数据回传
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
	public void  insertWorker(HttpServletResponse response, Worker worker,Integer roleid) throws IOException {
		printWriter = response.getWriter();
		int lengthid = implWorkerMg.lengthid();
		worker.setWorkerid(lengthid+1);
		int i = implWorkerMg.insertWorker(worker);
		//通过查询worker的最大ID号 就是当前插入的ID号 
		int workerid = implWorkerMg.queryMaxId();
		//roleid即使形参 可以获取
		Workerrole wr = new Workerrole();
		wr.setWorkerid(workerid);
		wr.setRoleid(roleid);
		int j = implWorkerroleBiz.insert(wr);
	//	System.out.println(j+"这个的意思是已经把角色人员表添加进去成功了");
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
		int delFk = 0;
		System.out.println(name);
		delFk = implWorkerMg.deleteFkWork(name);
		System.out.println(delFk+"----------------");
		delResult = implWorkerMg.deleteWork(name);
		System.out.println(delResult);
		System.out.println(delResult+"----------------");
		printWriter = response.getWriter();
		if (delFk>0&&delResult>0) {
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
	/**
	 * 更新重置密码功能
	 * @author 范帅
	 * @data 6-30
	 */
	@RequestMapping("resetPwd.action")
	public void resetPassword(HttpServletResponse response , String name) throws IOException {
		int reset = 0;
		reset = implWorkerMg.resetPassword(name);
		printWriter = response.getWriter();
		if (reset>0) {
			System.out.println("成功");
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
		} else {
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
		}
		
	}
	

}
