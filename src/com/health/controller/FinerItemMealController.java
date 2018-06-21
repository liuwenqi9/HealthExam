package com.health.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.health.biz.FinerItemMealBiz;
import com.health.entity.Detail;
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
	
	Map<String, Object> deptMsg = new HashMap<String, Object>(); //ajax数据回传

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
	public @ResponseBody List<Detail> detailMgPage() {
		//显示科室
//				PageHelper.startPage(1, 10);
				List<Detail> list = implFinerItemMealBiz.selectDetailPage();	
				
				//分页
//				List<Object> pageContanier = PageUtil.displayPage(list, 1);		
//				deptMsg.clear();
//				//数据
//				deptMsg.put("req", list);
//				deptMsg.put("pageContanier", pageContanier);	
			    
				return list;
	}

}
