
package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.AccountMgBiz;
import com.health.biz.ImplAccountMg;
import com.health.biz.ImplPrintPaperBiz;
import com.health.biz.PrintPaperBiz;
import com.health.clientBiz.ImplTeamOpenBiz;
import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Account;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;

/**
 * 用于打印导检单、体检报告等功能
 * 
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

	@RequestMapping("printGuide.action")
	public ModelAndView getPrintGuidePage(HttpServletRequest request) {
		// 获取所有的企业名称列表，发到前端使用
		ArrayList<Account> accountList = implAccountMg.queryAccountList();
		ModelAndView mav = new ModelAndView("jsp/examJsp/printGuide");
		mav.addObject(accountList);

		// 如果前端有根据账号进行选择，获取所有的已经预定的体检项目信息，发送到前端
		String currentAcID = request.getParameter("accountOption");
		if (currentAcID != null) {
			ArrayList<Viewpersonguideitemdept> orderList = implTeamOpenBiz.getOrderInfo(currentAcID);
			mav.addObject("orderList", orderList);

			Account currentAccount = implAccountMg.queryAccountById(currentAcID);
			System.out.println(currentAccount);
			mav.addObject("currentAccount", currentAccount);
		}
		return mav;
	}

}
