package com.health.biz;

import java.util.ArrayList;
import java.util.List;

import com.health.entity.Viewpersonguideitemdept;

public interface PrintPaperBiz {
	
	public ArrayList<Viewpersonguideitemdept> getGuideListByAccount();  //根据企业账号获取导检单列表

	public List<Viewpersonguideitemdept> getGuideDataByAccount(String accountId);  //根据企业id获取导检信息



}
