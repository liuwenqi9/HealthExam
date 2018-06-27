package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.health.biz.ChargeBiz;
import com.health.biz.SettleAccountBiz;
import com.health.entity.Charge;
import com.health.entity.Mysettleview;
import com.health.util.PageUtil;

@Controller
public class SettleAccountControler {

	@Resource
	SettleAccountBiz settleAccountBiz;
	
	@Resource
	ChargeBiz chargeBiz;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> rdMsg = new HashMap<String, Object>(); //ajax数据回传
	
	public Map<String, Object> loadingMsg(){
		
		//加载账单
		PageHelper.startPage(1, dataNum);
		List<Mysettleview> list = settleAccountBiz.getMsg();	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		rdMsg.clear();
		//数据
		rdMsg.put("depModel", list);
		rdMsg.put("pageContanier", pageContanier);
		
		return rdMsg;
	}
	
	@RequestMapping(value = "settleAccount.action")
	public String backToPage() { //页面分发
		return"/jsp/examJsp/settleAccount";
	}
	
	@RequestMapping(value = "getAllMsg.action")
	public @ResponseBody Map<String, Object> getAllMsg(){ //数据加载
		rdMsg = loadingMsg();		
		return rdMsg;
	}
	
	@RequestMapping(value = "getBillDetail.action") //订单详情
	public @ResponseBody Map<String, Object> getBillDetail(Integer chargeid){
		//获取数据
		PageHelper.startPage(1, dataNum);
		List<Mysettleview> list = settleAccountBiz.getBillDetail(chargeid);
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		rdMsg.clear();
		//数据
		rdMsg.put("billDetal", list);
		rdMsg.put("smallContanier", pageContanier);
		return rdMsg;
	}
	
	@RequestMapping(value = "checkCash.action") //结算信息
	public @ResponseBody Mysettleview getTotalPrice(Integer chargeid) {
		
		Mysettleview mySettleView = settleAccountBiz.totalPrice(chargeid);
		
		return mySettleView;
	}
	
	@RequestMapping(value = "comfirmCheck.action")
	public @ResponseBody Mysettleview comfirmCheck(Charge record) {
		
		//第一步：改变订单状态为0
		int result = chargeBiz.changeBill(record);
		
		//第二步：从Mysettleview中找出导检表状态为1的导检单
		if(result != -1) {
			int chargeid = record.getChargeid();
			List<Mysettleview> list = settleAccountBiz.getNotGuidePeople(chargeid);
			
			//第三步：将未检查的导检单状态更改为2
			int flag = settleAccountBiz.changeGuide(list);
			rdMsg.clear();
			if(flag != -1) {
				List<Mysettleview> listMsg = settleAccountBiz.getOneRecord(chargeid);
				Mysettleview mysettleview = listMsg.get(0);
				return mysettleview;
			}
		}
		return null;	
	}
	
	@RequestMapping(value = "changePages.action") //订单分页
	public @ResponseBody Map<String, Object> pagesForRecord(Integer currentPage){
		//加载账单
		PageHelper.startPage(currentPage, dataNum);
		List<Mysettleview> list = settleAccountBiz.getMsg();	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, currentPage);		
		rdMsg.clear();
		//数据
		rdMsg.put("depModel", list);
		rdMsg.put("pageContanier", pageContanier);
		return rdMsg;
	}

	@RequestMapping(value = "detailPages.action") //订单详情分页
	public @ResponseBody Map<String, Object> detailPage(Integer currentPage, Integer chargeid){
		//订单详情
		PageHelper.startPage(currentPage, dataNum);
		List<Mysettleview> list = settleAccountBiz.getBillDetail(chargeid);	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, currentPage);		
		rdMsg.clear();
		//数据
		rdMsg.put("billDetal", list);
		rdMsg.put("smallContanier", pageContanier);
		return rdMsg;
	}
}
