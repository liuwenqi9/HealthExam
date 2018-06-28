package com.health.clientController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.health.clientBiz.EmployeeInfoBiz;
import com.health.entity.Dept;
import com.health.entity.Personinfo;
import com.health.util.PageUtil;

/*
 * 用于前端门户的人员信息查询
 * @author 毛聪
 * @date 6月27日
 */

@Controller
public class EmployeeInfoController {

	@Resource
	EmployeeInfoBiz implEmployeeInfoBiz;

	private int dataNum = 5; // 每页显示数据
	private Map<String, Object> EmpMsg = new HashMap<String, Object>(); // ajax数据回传

	// @RequestMapping(value="/employeeInfo.action")
	// public ModelAndView loginClietJsp() {
	// ModelAndView mav = new ModelAndView("jsp/clientJsp/employeeInfo");
	// List<Personinfo> list= implEmployeeInfoBiz.employeeList();
	// mav.addObject("employeeList", list);
	//
	// return mav;
	// }

//	public List<Personinfo> employeeInfo() {
//		List<Personinfo> list = implEmployeeInfoBiz.employeeList();
//
//		return list;
//	}
	
	String account;

	@RequestMapping(value = "employeeInfo.action")
	public String employeeInfoJsp() {
		
		
		return "jsp/clientJsp/employeeInfo";
	}

	@RequestMapping(value = "loadEmployee.action")
	public @ResponseBody Map<String, Object> loadDept(HttpSession session) {
		// 加载
		PageHelper.startPage(1, dataNum);
		System.out.println("before enter method ");
		account=session.getAttribute("AccountID").toString();
		System.out.println(session.getAttribute("AccountID").toString());
		List<Personinfo> list = implEmployeeInfoBiz.employeeList(account);
		System.out.println("after enter method ");
		// 分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);
		EmpMsg.clear();
		// 数据
		EmpMsg.put("employeeModel", list);
		EmpMsg.put("pageContanier", pageContanier);
		;

		return EmpMsg;
	}

	@RequestMapping(value = "pageItemeInfo.action")
	public @ResponseBody Map<String, Object> pageMethod(String currentPage) {

		EmpMsg.clear(); // 清空历史分页参数
		// 判断是否携带搜索条件
		List<Personinfo> list;

		PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
		list = implEmployeeInfoBiz.employeeList(account);
		// 分页
		List<Object> pageContanier = PageUtil.displayPage(list, Integer.parseInt(currentPage));
		// 数据
		EmpMsg.put("employeeModel", list);
		EmpMsg.put("pageContanier", pageContanier);

		return EmpMsg;
	}
}
