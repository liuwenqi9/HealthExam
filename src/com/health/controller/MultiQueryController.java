package com.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.github.pagehelper.PageHelper;
import com.health.biz.AccountMgBiz;
import com.health.biz.IntMultiQueryBiz;
import com.health.entity.Account;
import com.health.entity.Viewmultiquery;
import com.health.entity.ViewmultiqueryExample;
import com.health.entity.Viewpersonguidepack;
import com.health.util.PageUtil;

import net.sf.json.JSONObject;

/*
 * 体检综合查询的后台控制
 * @author 罗杭春 6月25日
 */
@Controller
public class MultiQueryController {
	
	@Resource
	private IntMultiQueryBiz implMultiQueryBiz;
	@Resource
	private AccountMgBiz implAccountMg;
	
	private int dataNum = 10;
	private HashMap<String, Object> examInfoMap = new HashMap<>();
	
	
	/*
	 * 请求获取综合查询的页面的方法
	 * @author 罗杭春 6月25日
	 * @return 返回 转发到综合查询页面
	 */
	@RequestMapping("allQuery.action")
	public String getAllQueryPage() {
		 return "jsp/examJsp/multiQuery";
	}

	/*
	 * 请求获取综合查询的页面的方法
	 * @author 罗杭春 6月25日
	 * @return 返回 转发到综合查询页面
	 */
	@RequestMapping(value = "getMultiExamInfo.action")
	public @ResponseBody HashMap<String, Object> getMultiExamInfo() {
		PageHelper.startPage(1, dataNum);
		
		List<Viewmultiquery> multiInfoList = implMultiQueryBiz.getMultiExamInfo(); //获取所有的体检综合查询信息
		List<Object> pageContanier = PageUtil.displayPage(multiInfoList, 1); // 分页
		List<Account> accountList = implAccountMg.queryAccountList();   // 获取所有的企业名称列表，发到前端使用
		
		examInfoMap.put("multiInfoList", multiInfoList);
		examInfoMap.put("accountList", accountList);
		examInfoMap.put("pageContanier", pageContanier);
		
		return examInfoMap;
	}
	
	
	
	/*
	 * 根据条件请求来发送查询到的数据，条件包含：企业账号、姓名、电话号码、体检状态 
	 * @author 罗杭春 6月26日
	 * @return 返回 转发到综合查询页面
	 */
	@RequestMapping(value = "getExamInfoByCondition.action")
		public @ResponseBody HashMap<String, Object> getExamInfoByCondition(@RequestBody Viewmultiquery multiCondition) {
		
		System.out.println(multiCondition.getAccount());
		System.out.println(multiCondition.getName());
		System.out.println(multiCondition.getTelephone());
		
		PageHelper.startPage(1, dataNum);
		List<Viewmultiquery> multiInfoList = implMultiQueryBiz.getExamInfoByCondition(multiCondition); //获取所有的体检综合查询信息
		List<Object> pageContanier = PageUtil.displayPage(multiInfoList, 1); // 分页
		
		examInfoMap.clear();
		examInfoMap.put("pageContanier", pageContanier);
		examInfoMap.put("multiInfoList", multiInfoList);
		return examInfoMap;
	}
	
	
	/*
	 * 根据条件请求的页码来发送查询到的数据 
	 * @author 罗杭春 6月27日
	 * @return 返回 转发到综合查询页面
	 */
	@RequestMapping(value = "getExamInfoByPage.action")
		public @ResponseBody HashMap<String, Object> getExamInfoByPage(String multiCondition,int currentPage) {
		System.out.println("请求页码为" + currentPage);
		System.out.println(multiCondition);
		
		JSONObject jsonobject = JSONObject.fromObject(multiCondition);
		Viewmultiquery condition= (Viewmultiquery)JSONObject.toBean(jsonobject,Viewmultiquery.class);
		
		System.out.println(condition.getAccount());
		System.out.println(condition.getName());
		System.out.println(condition.getTelephone());
		
		PageHelper.startPage(currentPage, dataNum);
		List<Viewmultiquery> multiInfoList = implMultiQueryBiz.getExamInfoByCondition(condition); //获取所有的体检综合查询信息
		List<Object> pageContanier = PageUtil.displayPage(multiInfoList, currentPage); // 分页
		
		examInfoMap.clear();
		examInfoMap.put("pageContanier", pageContanier);
		examInfoMap.put("multiInfoList", multiInfoList);
		return examInfoMap;
	}
	

}
