package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Viewpersonguidepack;
import com.health.entity.ViewpersonguidepackExample;
import com.health.mapper.AccountMapper;
import com.health.mapper.ViewpersonguidepackMapper;

@Service
public class ImplPrintPaperBiz implements PrintPaperBiz {
	
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private ViewpersonguidepackMapper viewPgidMapper;
	@Resource
	private ViewpersonguidepackExample ViewPgidExample;
	

	/**
	 * 根据企业账户ID号来获取这个企业下所有的待体检人员的导检信息
	 * @author 罗杭春 6月22日
	 * @return 返回承载数据的Map
	 */
	@Override
	public List<Viewpersonguidepack> getGuideDataByAccount(String accountId) {
		ViewPgidExample.clear();
		ViewpersonguidepackExample.Criteria criteria = ViewPgidExample.createCriteria();
		criteria.andAccountEqualTo(accountId);
		List<Viewpersonguidepack> list = viewPgidMapper.selectByExample(ViewPgidExample);
		return list;
		
	}


}
