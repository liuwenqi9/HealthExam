package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
	PrintWriter printWriter;
	/**
	 * 主界面点击系统管理->菜单配置选项的时候进行的页面跳转
	 * 6-27增加模糊查找功能
	 * @author 范帅
	 * @date 6月19日
	 * 
	 */
	@RequestMapping("menuMg.action")
	public ModelAndView getMenuMg(String menuname) {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/menuMg");
		if (menuname == null) {
			ArrayList<Menu>muList = implMenuMg.queryMenuList();
			mav.addObject("muList",muList);
		} else {
			ArrayList<Menu> resultList = implMenuMg.queryMenu("%"+menuname+"%");
			mav.addObject("muList",resultList);
		}
		return mav;
		
	}
	/**
	 * 删除菜单功能
	 * @author 范帅
	 * @date 6-27
	 * 
	 */
	@RequestMapping("deleteMenuMg.action")
	public void deleteMenu(HttpServletResponse response,String menuname) throws IOException {
		int delResult = 0;
		delResult = implMenuMg.deleteMenu(menuname);
		System.out.println(delResult);
		
		printWriter = response.getWriter();
		if (delResult>0) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
		} else {
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
		}
		
	}
	/**
	 * 菜单名称的修改
	 * @author 范帅
	 * @data 6-27
	 */
	@RequestMapping("updatamenuMg.action")
	public void updataMenu(HttpServletResponse response,Menu menu) throws IOException {
		System.out.println(menu.getMenuname());
		System.out.println(menu.getUrl());
		int resultUp = 0;
		resultUp = implMenuMg.updataMenu(menu);
		
		printWriter = response.getWriter();
		if (resultUp>0) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("修改成功");
		} else {
			printWriter.println("FAIL");
			printWriter.flush();
			printWriter.close();
			
		}
		
	}

}
