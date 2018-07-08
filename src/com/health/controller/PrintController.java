
package com.health.controller;

import java.util.List;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.biz.AccountMgBiz;
import com.health.biz.PrintPaperBiz;
import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Viewguideinfo;

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

	private int dataNum = 10;
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
	 * 根据前端发送过来的导检ID号来获取对应的导检信息
	 * @author 罗杭春 6月20日
	 * @return 返回承载数据的Map
	 */
	@RequestMapping(value = "getGuideDataByGuideId.action")
	public @ResponseBody List<Viewguideinfo> getGuideDataByGuideId(Integer guideId) {
		
		System.out.println("请求到了打印部分");
		List<Viewguideinfo> guideInfoList = implPrintPaperBiz.getGuideDataByGuideId(guideId);
		
		System.out.println("即将返回到前端");
		return guideInfoList;
	}

}
