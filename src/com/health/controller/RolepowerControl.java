package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.RolepowerMgBiz;
import com.health.entity.Rolepower;

/**
 * 权限管理
 * @author 范帅
 * @date 6月19日
 *
 */
@Controller
public class RolepowerControl {
	@Resource
	RolepowerMgBiz implRolepowerMg;
	/**
	 * 主界面点击系统管理->权限设置选项的时候进行的页面跳转
	 * @author 范帅
	 * @date 6月19日
	 * 
	 */
	@RequestMapping("powerMg.action")
	public ModelAndView getRolepowerMg() {
		ArrayList<Rolepower>rpList = implRolepowerMg.queryRolepowerList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/powerMg");
		mav.addObject("rpList",rpList);
		return mav;
		
	}
	

}
