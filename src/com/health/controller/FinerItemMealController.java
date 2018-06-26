package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.health.biz.FinerItemMealBiz;
import com.health.entity.Dept;
import com.health.entity.Detail;
import com.health.entity.Items;
import com.health.entity.Parameter;
import com.health.util.PageUtil;

import net.sf.json.JSONObject;

/*
 * 细项项目套餐控制类
 * @author PYC
 * @date 6月19日
 */

@Controller
public class FinerItemMealController {
	
	@Resource
	FinerItemMealBiz implFinerItemMealBiz;
	
	Map<String, Object> reqMsg = new HashMap<String, Object>(); //ajax数据回传
	

	@RequestMapping("detailMg.action")
	public ModelAndView detailMg() {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/detailMg");
		return mav;
	}
	
	@RequestMapping("itemMg.action")
	public ModelAndView itemMg() {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/itemMg");
		return mav;
	}
	
	@RequestMapping("mealMg.action")
	public ModelAndView mealMg() {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/mealMg");
		return mav;
	}
	
	/*
	 * method: 获取细项分页数据，带条件
	 */
	@RequestMapping("detailMgPage.action")
	public @ResponseBody Map<String, Object> detailMgPage(int page,String sItemName) {
		
		PageHelper.startPage(1, 10);
		List<Detail> list = implFinerItemMealBiz.selectDetailPage(sItemName);	
		
		//获取参数列表
		List<Parameter> pList = implFinerItemMealBiz.selectAllParameter();
		
		
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, page);		
		reqMsg.clear();
//				//数据
		reqMsg.put("req", list);
		reqMsg.put("pageCount", pageContanier);	
		reqMsg.put("pageNum", page);	
		reqMsg.put("paramList", pList);	
	    
		return reqMsg;
	}
	
	@RequestMapping("detailMgUpdate.action")
	public @ResponseBody Map<String, Object> detailMgUpdate(Detail detail) {
		reqMsg.clear();
		reqMsg.put("status", implFinerItemMealBiz.updateByDetail(detail)==1?"修改成功":"修改失败");	
		return reqMsg;
	}
	
	@RequestMapping("detailMgInsert.action")
	public @ResponseBody Map<String, Object> detailMgInsert(Detail detail) {
		reqMsg.clear();
		reqMsg.put("status", implFinerItemMealBiz.insertDetail(detail)==1?"添加成功":"添加失败");	
		return reqMsg;
	}
	
	@RequestMapping("detailMgDelete.action")
	public @ResponseBody Map<String, Object> detailMgDelete(Integer detailid) {
		reqMsg.clear();
		reqMsg.put("status", implFinerItemMealBiz.deleteDetailById(detailid)==1?"删除成功":"删除失败");	
		return reqMsg;
	}
	
	@RequestMapping("itemMgPage.action")
	public @ResponseBody Map<String, Object> itemMgPage(int page,String sItemName) {
		PageHelper.startPage(1, 10);
		List<Items> list = implFinerItemMealBiz.selectItemPage(sItemName);	
		
		//获取科室列表
		List<Dept> dList = implFinerItemMealBiz.selectAllDept();
		
		//分页
		List<Object> pageContanier = PageUtil.displayPage(list, page);		
		reqMsg.clear();
//				//数据
		reqMsg.put("req", list);
		reqMsg.put("pageCount", pageContanier);	
		reqMsg.put("pageNum", page);	
		reqMsg.put("deptList", dList);
	    
		return reqMsg;
	}
	
	@RequestMapping("itemSelectDetailList.action")
	public @ResponseBody Map<String, Object> itemSelectDetailList(Integer itemid) {
		List<Detail> dList = implFinerItemMealBiz.selectDetailByItemId(itemid);
		reqMsg.clear();
		reqMsg.put("detailList", dList);
	    
		return reqMsg;
	}
}
