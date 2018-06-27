package com.health.biz;

import java.util.List;

import com.health.entity.Viewpersonguidepack;

public interface PrintPaperBiz {
	
	public List<Viewpersonguidepack> getGuideDataByAccount(String accountId);  //根据企业id获取导检信息



}
