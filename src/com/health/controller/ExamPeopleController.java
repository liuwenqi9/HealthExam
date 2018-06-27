package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.health.biz.ExamPeopleBiz;
import com.health.entity.Exampeople;
import com.health.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class ExamPeopleController {

	@Resource
	ExamPeopleBiz examPeopleBiz;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> pplMsg = new HashMap<String, Object>(); //ajax数据回传
	
	//获取体检人信息
	public Map<String, Object> loadingPeople() {
		
		//显示体检人
		PageHelper.startPage(1, dataNum);
		List<Exampeople> list = examPeopleBiz.getPeople();	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		pplMsg.clear();
		//数据
		pplMsg.put("depModel", list);
		pplMsg.put("pageContanier", pageContanier);
		
		return pplMsg;
	}
	
	@RequestMapping(value = "examPersonQuery.action")
	public String examPeopleSys() { //页面分发
		return "/jsp/examJsp/personQuery";
	}
	
	@RequestMapping(value = "getExamPeople.action") //获取体检人数据
	public @ResponseBody Map<String, Object> getPeopleMsg(){
		pplMsg = loadingPeople();
		return pplMsg;
	}
	
	@RequestMapping(value = "showPeopelDetail.action") //获取全部订单数据
	public @ResponseBody Map<String, Object> currentNameMsg(String name){
		
		//显示体检人
		PageHelper.startPage(1, dataNum);
		List<Exampeople> list = examPeopleBiz.peopleDetail(name);
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		pplMsg.clear();
		//数据
		pplMsg.put("peopleDetail", list);
		pplMsg.put("DetailContanier", pageContanier);
		
		return pplMsg;
	}
	
	@RequestMapping(value = "pageAndsearch.action")
	public @ResponseBody Map<String, Object> pageAndsearch(Integer currentPage, String searchModel, boolean isSearch){
		
		JSONObject voObj = JSONObject.fromObject(searchModel);
		
		PageHelper.startPage(currentPage, dataNum);
		List<Exampeople> list = examPeopleBiz.search(voObj.getString("name"), voObj.getString("phone"), voObj.getString("barcode"), voObj.getString("startTime"), voObj.getString("endTime"));
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		pplMsg.clear();
		//数据
		pplMsg.put("depModel", list);
		pplMsg.put("pageContanier", pageContanier);
		return pplMsg;
	}
}
