package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.MenuMgBiz;
import com.health.entity.Menu;

/**
 * 菜单管理
 * @author 范帅
 * @date 6月19日 
 *
 */
@Controller
public class MenuControl {
	@Resource
	MenuMgBiz implMenuMg;
	/**
	 * 主界面点击系统管理->菜单配置选项的时候进行的页面跳转
	 * @author 范帅
	 * @date 6月19日
	 * 
	 */
	@RequestMapping("menuMg.action")
	public ModelAndView getMenuMg() {
		ArrayList<Menu>muList = implMenuMg.queryMenuList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/menuMg");
		mav.addObject("muList",muList);
		return mav;
		
	}

}
