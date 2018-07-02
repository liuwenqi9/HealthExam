package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.RoleMgBiz;
import com.health.entity.Role;

/**
 * 这个是角色配置
 * @author 范帅
 * @date 6月19日
 *
 */
@Controller
public class RoleMgControl {
	@Resource
	RoleMgBiz implRoleMg;
	PrintWriter printWriter;
	/**
	 * 主界面点击系统管理->角色配置选项的时候进行的页面跳转
	 * @author 范帅
	 * @date 6月19日
	 */
	@RequestMapping("roleMg.action")
	public ModelAndView getRoleMg( ) {
		ArrayList<Role>rlList = implRoleMg.queryRoleList();
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/roleMg");
		mav.addObject("rlList",rlList);
		System.out.println(mav);
		return mav;
	}
	/**
	 * 角色配置的删除操作
	 * @author 范帅
	 * @data 6月21日
	 * 
	 */
	@RequestMapping("deleteRoleMg.action")
	public void deleteRole(HttpServletResponse response, String rolename) throws IOException {
		System.out.println("删除" + rolename);
		int delResult = 0;
		delResult = implRoleMg.deleteRole(rolename);//删除
		printWriter = response.getWriter();
		if (delResult>0) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("返回OK");
		} else {
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
			System.out.println("返回FAIL");
		}
	}
	
	/**
	 * 角色配置的增加操作
	 * @author 范帅
	 * @data 6月22日
	 */
	@RequestMapping("insertroleMg.action")
	public void insertRole(HttpServletResponse response, Role role) throws IOException {
		int lengthid = implRoleMg.lengthId();
		System.out.println(role.getRolename()+"_----------------");
		role.setRoleid(lengthid+1);
		int i = implRoleMg.insertRole(role);
		printWriter = response.getWriter();
		if (i>1) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("增加成功");
		} else {
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
			System.out.println("增加失败");
		}
	}
	
	/**
	 * 修改角色名称
	 * @author 范帅
	 */
	@RequestMapping("updateRole.action")
	public void updateRole(HttpServletResponse response,String roleid,String rolename) throws IOException {
		System.out.println(roleid);
		System.out.println(rolename);
		
		HashMap<String, String>map = new HashMap<>();
		map.put("roleid", roleid);
		map.put("rolename", rolename);
		int updateRole = implRoleMg.updateRole (map);
		printWriter = response.getWriter();
		if (updateRole>0) {
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
		} else {
			printWriter.println("FAIL");
			printWriter.flush();
			printWriter.close();
		}
		
	}
}
