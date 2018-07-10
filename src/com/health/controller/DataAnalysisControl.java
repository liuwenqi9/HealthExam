package com.health.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.health.biz.GuidPackBiz;
import com.health.entity.Hotpack;

@Controller
public class DataAnalysisControl {
	
	@Resource
	GuidPackBiz implGuidPack;

	@RequestMapping("dataAnalysis.action")
	public ModelAndView dataAnalysis() {
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/dataAnalysis");
		/* 进行查询 */
		ArrayList<Hotpack> hotpacks = implGuidPack.queryHot();
		
		//获得横坐标
		StringBuffer a = new StringBuffer("[");
		int i = 0;
		for (i = 0; i < hotpacks.size(); i++) {
			if (i < hotpacks.size()&&i!=hotpacks.size()-1) {
				a.append("\""+hotpacks.get(i).getPackname()+"\""+",");
			} else {
				a.append("\""+hotpacks.get(i).getPackname()+"\"");
			}
		}
		a.append("]");
		//获得纵坐标
		StringBuffer b = new StringBuffer("[");
		int j = 0;
		for ( j = 0; j <hotpacks.size(); j++) {
			if (j < hotpacks.size()&&j!=hotpacks.size()-1) {
				b.append(hotpacks.get(j).getTotal()+",");
			} else {
				b.append(hotpacks.get(j).getTotal());
			}
			
		}
		b.append("]");
		System.out.println(a);
		System.out.println(b);
		mav.getModel().put("hotList",hotpacks);
		mav.addObject("ordinate",a);
		mav.addObject("abscissa",b);
		
		return mav;
	}
}
