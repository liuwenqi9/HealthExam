
package com.health.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.health.biz.AccountMgBiz;
import com.health.biz.ImplAccountMg;
import com.health.biz.ImplPrintPaperBiz;
import com.health.biz.PrintPaperBiz;
import com.health.clientBiz.ImplTeamOpenBiz;
import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Account;
import com.health.entity.Charge;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;
import com.health.mapper.ViewpersonguideitemdeptMapper;
import com.health.util.PageUtil;

/**
 * 用于打印导检单、体检报告等功能
 * @author 罗杭春
 * @date 6月21日
 */
@Controller
public class PrintController {
	@Resource
	private TeamOpenBiz implTeamOpenBiz;
	@Resource
	private PrintPaperBiz implPrintPaperBiz;
	@Resource
	private AccountMgBiz implAccountMg;
	
	private int dataNum = 5;

	private HashMap<String, Object> guideInfoMap = new HashMap<String, Object>(); // 导检信息，用于ajax数据回传

	/*
	 * 获取打印导检单的页面，切换到该页面
	 * @author 罗杭春 6月22日修改
	 */
	@RequestMapping(value = "printGuide.action")
	public String getPrintGuidePage() {
		return "jsp/examJsp/printGuide";
	}

	/**
	 * 获取导检数据的方法
	 * @author 罗杭春 6月22日
	 * @return 返回承载数据的Map
	 */
	@RequestMapping(value = "getAccountData.action")
	public @ResponseBody HashMap<String, Object> getAccountData() {
		ArrayList<Account> accountList = implAccountMg.queryAccountList();// 获取所有的企业名称列表，发到前端使用
		guideInfoMap.put("accountList", accountList);
		return guideInfoMap;
	}

	/**
	 * 根据企业账户ID号来获取企业信息 并且查询这个企业下所有的待体检人员的导检信息
	 * @author 罗杭春 6月22日
	 * @return 返回承载数据的Map
	 */
	@RequestMapping(value = "getGuideDataByAccount.action")
	public @ResponseBody HashMap<String, Object> getGuideDataByAccount(String accountId) {

		ArrayList<Account> accountList = implAccountMg.queryAccountList();// 获取所有的企业名称列表，发到前端使用
		guideInfoMap.put("accountList", accountList);
		
		PageHelper.startPage(1, dataNum);
		List<Viewpersonguideitemdept> guideInfolist = implPrintPaperBiz.getGuideDataByAccount(accountId);
		
		List<Object> pageContanier = PageUtil.displayPage(guideInfolist, 1); //分页	 	
		
		guideInfoMap.clear();   //装载数据
		guideInfoMap.put("guideInfolist", guideInfolist);
		guideInfoMap.put("pageContanier", pageContanier);
		
		return guideInfoMap;
	}
	
	@RequestMapping(value = "getGuideInfoByPage.action")
	public @ResponseBody HashMap<String, Object> getGuideInfoByPage(String accountId, int currentPage) {
		guideInfoMap.clear();
		System.out.println("请求页码为" + currentPage);
		PageHelper.startPage(currentPage, dataNum);
		List<Viewpersonguideitemdept> guideInfolist = implPrintPaperBiz.getGuideDataByAccount(accountId);
		List<Object> pageContanier = PageUtil.displayPage(guideInfolist, currentPage); // 分页

		guideInfoMap.clear(); // 装载数据
		guideInfoMap.put("guideInfolist", guideInfolist);
		guideInfoMap.put("pageContanier", pageContanier);

		return guideInfoMap;

	}
	

	
	//加载所有的导检信息
//	public HashMap<String, Object> getAllGuideData(String accountId){
//
//		PageHelper.startPage(1, dataNum);
//		List<Viewpersonguideitemdept> guideInfolist = implPrintPaperBiz.getGuideDataByAccount(accountId);
//		
//		//分页
//		List<Object> pageContanier = PageUtil.displayPage(guideInfolist, 1);		
//		//数据
//		guideInfoMap.clear();
//		guideInfoMap.put("guideInfolist", guideInfolist);
//		guideInfoMap.put("pageContanier", pageContanier);
//		
//		return guideInfoMap;
//	}
	
	
	
	// @RequestMapping("getGuideInfoById.action")
	// public HashMap<String, Object> getGuideInfoById() {
	// // 获取所有的企业名称列表，发到前端使用
	// ArrayList<Account> accountList = implAccountMg.queryAccountList();
	//
	// ModelAndView mav = new ModelAndView("jsp/examJsp/printGuide");
	// mav.addObject(accountList);
	//
	// // 如果前端有根据账号进行选择，获取所有的已经预定的体检项目信息，发送到前端
	// String currentAcID = request.getParameter("accountOption");
	// if (currentAcID != null) {
	// ArrayList<Viewpersonguideitemdept> orderList =
	// implTeamOpenBiz.getOrderInfo(currentAcID);
	// mav.addObject("orderList", orderList);
	//
	// Account currentAccount = implAccountMg.queryAccountById(currentAcID);
	// System.out.println(currentAccount);
	// mav.addObject("currentAccount", currentAccount);
	// }
	// return guideInfoMap;
	// }

	// @RequestMapping("printGuide.action")
	// public ModelAndView getPrintGuidePage(HttpServletRequest request) {
	// // 获取所有的企业名称列表，发到前端使用
	// ArrayList<Account> accountList = implAccountMg.queryAccountList();
	// ModelAndView mav = new ModelAndView("jsp/examJsp/printGuide");
	// mav.addObject(accountList);
	//
	// // 如果前端有根据账号进行选择，获取所有的已经预定的体检项目信息，发送到前端
	// String currentAcID = request.getParameter("accountOption");
	// if (currentAcID != null) {
	// ArrayList<Viewpersonguideitemdept> orderList =
	// implTeamOpenBiz.getOrderInfo(currentAcID);
	// mav.addObject("orderList", orderList);
	//
	// Account currentAccount = implAccountMg.queryAccountById(currentAcID);
	// System.out.println(currentAccount);
	// mav.addObject("currentAccount", currentAccount);
	// }
	// return mav;
	// }

}
