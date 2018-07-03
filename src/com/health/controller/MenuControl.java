package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.health.biz.MenuMgBiz;
import com.health.entity.Menu;
import com.health.entity.Rolepower;
import com.health.entity.Worker;
import com.health.entity.Workerrole;

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
	/*@RequestMapping("getDept.action")
	public void getDept(HttpServletResponse response,String name) throws IOException {
		System.out.println(name);
	    response.setCharacterEncoding("UTF-8");
		//通过菜单上面的姓名进行查询worker对象，
		
		ArrayList<Worker> workers = new ArrayList<Worker>();
		workers = implMenuMg.queryWorker(name);
		System.out.println(workers);
		printWriter =response.getWriter();
		Worker worker = implMenuMg.queryWorker(name);
		if (worker!=null) {
			//进行查询workerrole
			int workerid = worker.getWorkerid();
			Workerrole workerrole = implMenuMg.queryWorkerrole(workerid);
			if (workerrole != null) {
				//进行查询到roleid对应的menuid，再rolepower表中
				int roleid = workerrole.getRoleid();
				ArrayList<Rolepower> rolepowers = new ArrayList<>();
				rolepowers = implMenuMg.queryRolePower(roleid);
				//查到对应权限的菜单id，在进行下发有改id的menu表
				ArrayList<Menu>mList = new ArrayList<>();
				if (rolepowers != null) {
					for (Rolepower rolepower : rolepowers) {
						int menuid = rolepower.getMenuid();
						Menu menus =null;
						menus = implMenuMg.queryMenuid(menuid);
						System.out.println(menus);
						mList.add(menus);
						Gson gson = new Gson();
						String gson_mList = gson.toJson(mList);
						System.out.println(gson_mList);
						
						
					}
				}
				System.out.println("菜单的大小"+mList.size());
				printWriter.print(mList);
				printWriter.flush();
				printWriter.close();
			}
		}else {
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
		}
	}
*/
}
