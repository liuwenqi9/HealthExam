package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Viewpersonguideitemdept;
import com.health.mapper.AccountMapper;

@Service
public class ImplPrintPaperBiz implements PrintPaperBiz {
	
	@Resource
	AccountMapper accountMapper;
	
	
	/**
	 * 用于根据一个企业的账号来查询该账号下的所有的导检单
	 * @param 企业账号 account
	 * @return 返回一个列表
	 * @author 罗杭春 6月21日
	 */
	@Override
	public ArrayList<Viewpersonguideitemdept> getGuideListByAccount() {
		// TODO Auto-generated method stub
		return null;
	}


}
