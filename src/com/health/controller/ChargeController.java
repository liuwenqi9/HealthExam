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
import com.health.entity.Charge;
import com.health.util.MyTimeUtil;
import com.health.util.PageUtil;

@Controller
public class ChargeController {

	@Resource
	ChargeBiz chargeBiz;
	
	private int dataNum = 10; //每页显示数据
	private Map<String, Object> billMsg = new HashMap<String, Object>(); //ajax数据回传
	
	
	//加载所有订单
	public Map<String, Object> loadingBill(){
		
		//加载账单
		PageHelper.startPage(1, dataNum);
		List<Charge> list = chargeBiz.getAllBill();	
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		billMsg.clear();
		//数据
		billMsg.put("depModel", list);
		billMsg.put("pageContanier", pageContanier);
		
		return billMsg;
	}
	
	@RequestMapping(value = "charge.action")
	public String goToCharge() {
		return "jsp/examJsp/charge";
	}
	
	@RequestMapping(value = "loadBill.action")
	public @ResponseBody Map<String, Object> loadBill(){		
		billMsg = loadingBill();		
		return billMsg;
	}
	
	@RequestMapping(value = "getOneBill.action") //获取订单信息
	public @ResponseBody Charge getCurrentBill(String chargeid){		
		Charge charge = chargeBiz.getOneBill(Integer.parseInt(chargeid));
		return charge;
	}
	
	@RequestMapping(value = "recoderBill.action")//记账
	public @ResponseBody Charge recoderBill(Charge record) {		
		record.setTime(MyTimeUtil.getTimeNowTogether()); //记账时间
		chargeBiz.updateBill(record); //更新订单
		Charge charge = chargeBiz.getOneBill(record.getChargeid()); 
		return charge;
	}
	
	@RequestMapping(value = "searchBill.action") //查询
	public @ResponseBody Map<String, Object> searchBill(String account){
		
		PageHelper.startPage(1, dataNum);
		List<Charge> list = chargeBiz.searchRecoder(account);
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);		
		billMsg.clear();
		//数据
		billMsg.put("depModel", list);
		billMsg.put("pageContanier", pageContanier);
		return billMsg;
	}
	
	@RequestMapping(value = "pageItemForBill.action")
	public @ResponseBody Map<String, Object> pageMethod(String account, Integer currentPage){
		billMsg.clear();
		
		List<Charge> list;
		if(account.equals("")) {
			PageHelper.startPage(currentPage, dataNum);
			list = chargeBiz.getAllBill();
			
		}else {
			PageHelper.startPage(currentPage, dataNum);
			list = chargeBiz.searchRecoder(account);
		}
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, currentPage);	
		//数据
		billMsg.put("depModel", list);
		billMsg.put("pageContanier", pageContanier);
		return billMsg;
	}
}
