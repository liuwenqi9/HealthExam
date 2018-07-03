package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Examreport;
import com.health.entity.ExamreportExample;
import com.health.entity.ExamreportExample.Criteria;
import com.health.mapper.ExamreportMapper;

@Service
public class ExamReportBiz {

	@Resource
	ExamreportMapper examreportMapper;
	
	@Resource
	ExamreportExample examreportExample;
	
	//返回项目列表
	public List<Examreport> getItems(Integer guideid) {
		
		examreportExample.clear();
		Criteria criteria = examreportExample.createCriteria();
		criteria.andGuideidEqualTo(guideid);
		List<Examreport> items = examreportMapper.selectItemsByExample(examreportExample);
		return items;
	}
	
	//获取项目报告
	public List<Examreport> getDetail(Integer guideid, Object itemname){
		examreportExample.clear();
		Criteria criteria = examreportExample.createCriteria();
		criteria.andGuideidEqualTo(guideid);
		criteria.andItemnameEqualTo(itemname);
		List<Examreport> details = examreportMapper.selectDetailByExample(examreportExample);
		return details;
	}
	
	//获取总结报告
	public List<Examreport> getAllSummary(Integer guideid){
		examreportExample.clear();
		Criteria criteria = examreportExample.createCriteria();
		criteria.andGuideidEqualTo(guideid);
		List<Examreport> allSummary = examreportMapper.selectAllSummaryByExample(examreportExample);
		return allSummary;
	}
}
