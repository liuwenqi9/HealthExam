package com.health.biz;

import java.util.ArrayList;

import com.health.entity.Viewpersonguideitemdept;

public interface PrintPaperBiz {
	
	public ArrayList<Viewpersonguideitemdept> getGuideListByAccount();  //根据企业账号获取导检单列表

}
