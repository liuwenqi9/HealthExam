package com.health.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Viewpersonguideitemdept;
import com.health.entity.ViewpersonguideitemdeptExample;
import com.health.mapper.AccountMapper;
import com.health.mapper.ViewpersonguideitemdeptMapper;

@Service
public class ImplPrintPaperBiz implements PrintPaperBiz {
	
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private ViewpersonguideitemdeptMapper viewPgidMapper;
	@Resource
	private ViewpersonguideitemdeptExample ViewPgidExample;
	
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

	/**
	 * 根据企业账户ID号来获取这个企业下所有的待体检人员的导检信息
	 * @author 罗杭春 6月22日
	 * @return 返回承载数据的Map
	 */
	@Override
	public List<Viewpersonguideitemdept> getGuideDataByAccount(String accountId) {
		ViewPgidExample.clear();
		ViewpersonguideitemdeptExample.Criteria criteria = ViewPgidExample.createCriteria();
		criteria.andAccountEqualTo(accountId);
		List<Viewpersonguideitemdept> list = viewPgidMapper.selectByExample(ViewPgidExample);
		return list;
		
	}


}
