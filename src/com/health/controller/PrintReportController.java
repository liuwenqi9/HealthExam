package com.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.biz.ExamPeopleBiz;
import com.health.biz.ExamReportBiz;
import com.health.entity.Exampeople;
import com.health.entity.Examreport;
import com.health.entity.ItemDetailPojo;

@Controller
public class PrintReportController {

	@Resource
	ExamReportBiz examreportBiz;
	
	@Resource
	ExamPeopleBiz examPeopleBiz;
	
	
	Map<String, Object> dataSource = new HashMap<String, Object>();
	
	@RequestMapping(value = "printReport.action")
	public String getReport() {
		
		return "/jsp/examJsp/printReport";
	}
	
	@RequestMapping(value = "searchGuideCode.action")
	public @ResponseBody Map<String, Object> getReport(Integer guideCode){
		
		List<Examreport> items = examreportBiz.getItems(guideCode);
		
		if(items.size() == 0) {
			dataSource.put("noData", -1);
		}else {
			dataSource.put("noData", 1);
			Exampeople ppsMsg = examPeopleBiz.pplMsg(guideCode);
			dataSource.put("peopleMsg", ppsMsg);//体检人信息
			List<Examreport> allSummary = examreportBiz.getAllSummary(guideCode);
			dataSource.put("allSummary", allSummary);//医生总结
			dataSource.put("items", items);//项目列表
			
			List<ItemDetailPojo> itemList = new ArrayList<>(); 
			
			for (int i = 0; i < items.size(); i++) {
				
				ItemDetailPojo idp = new ItemDetailPojo();
				List<Examreport> detialsByItem = examreportBiz.getDetail(guideCode, items.get(i).getItemname()); //每个项目的检测报告
				idp.setList(detialsByItem);
				idp.setId(i);
				idp.setItemName(items.get(i).getItemname());
				itemList.add(idp);
			}
				dataSource.put("list", itemList); //项目详情
		}
		return dataSource;		
	}
}
