package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Viewguideinfo;
import com.health.entity.ViewguideinfoExample;
import com.health.entity.Viewpersonguidepack;
import com.health.entity.ViewpersonguidepackExample;
import com.health.mapper.AccountMapper;
import com.health.mapper.ViewguideinfoMapper;
import com.health.mapper.ViewpersonguidepackMapper;
import com.sun.corba.se.spi.orbutil.fsm.State;

@Service
public class ImplPrintPaperBiz implements PrintPaperBiz {
	
	@Resource
	private AccountMapper accountMapper;
	@Resource
	private ViewpersonguidepackMapper viewPgidMapper;
	@Resource
	private ViewpersonguidepackExample ViewPgidExample;
	@Resource
	private ViewguideinfoMapper guideInfoMapper;
	@Resource
	private ViewguideinfoExample guideInfoExample;
	private static short state = 1;   //选择状态为1，即为已经接收，但是未体检的项目
	
	/**
	 * 根据企业账户ID号来获取这个企业下所有的待体检人员的导检信息
	 * @author 罗杭春 6月29日
	 * @return 返回承载数据的Map
	 */
	@Override
	public List<Viewguideinfo> getGuideDataByGuideId(Integer guideId) {
		guideInfoExample.clear();
		ViewguideinfoExample.Criteria criteria = guideInfoExample.createCriteria();
		criteria.andGuideidEqualTo(guideId);
		criteria.andStateEqualTo(state);
		List<Viewguideinfo> guideInfoList = guideInfoMapper.selectByExample(guideInfoExample);
		return guideInfoList;
	}


}
