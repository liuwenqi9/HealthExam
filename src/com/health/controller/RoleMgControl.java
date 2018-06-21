package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return mav;
	}

}
