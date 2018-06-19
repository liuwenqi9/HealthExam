package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author JSY
 * @date:6月19日
 */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogController {
	
	/**
	 * 跳转至日志查看界面 
	 */
	@RequestMapping("queryLog.action")
	public ModelAndView checkLogView() {
		System.out.println("展开日志查看");
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/check_log_record");
		return mav;
	}
	/**
	 * 查询日志内容
	 */
	
	
	
	
	
}
