package com.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class dataAnalysisControl {

	@RequestMapping("dataAnalysis.action")
	public ModelAndView dataAnalysis() {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/dataAnalysis");
		return mav;
	}
}
