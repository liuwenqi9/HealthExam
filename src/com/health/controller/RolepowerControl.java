package com.health.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.health.biz.RolepowerMgBiz;
import com.health.entity.Role;
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
		//左边的	职业menu，拉取role表
		ArrayList<Role> roles = implRolepowerMg.queryRole();
		String oo = new Gson().toJson(roles);
		System.out.println(oo);
		mav.addObject("rpList",rpList);
		mav.addObject("rlList",roles);
		return mav;
		
	}
	@RequestMapping("queryHavePower.action")
	public void queryHavePower(HttpServletRequest request , String roleid) throws IOException {
		
		System.out.println(roleid+"我的名字叫范帅");
		if (roleid != null) {
			System.out.println("我要进行用request下发下去了");
		}
		
	}

}
