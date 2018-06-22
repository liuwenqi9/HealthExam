package com.health.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.biz.SettleAccountBiz;

@Controller
public class SettleAccountControler {

	@Resource
	SettleAccountBiz settleAccountBiz;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> billMsg = new HashMap<String, Object>(); //ajax数据回传
	
	@RequestMapping(value = "settleAccount.action")
	public String backToPage() { //页面分发
		return"settleAccount.jsp";
	}
	
	@RequestMapping(value = "loadingMig.action")
	public @ResponseBody Map<String, Object> loadingMis(){ //数据加载
		
		return billMsg;
	}
}
