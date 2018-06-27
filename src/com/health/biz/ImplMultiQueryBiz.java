package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.health.entity.Viewmultiquery;
import com.health.entity.ViewmultiqueryExample;
import com.health.mapper.ViewmultiqueryMapper;

@Service
public class ImplMultiQueryBiz implements IntMultiQueryBiz {

	@Resource
	private ViewmultiqueryMapper multiqueryMapper;
	@Resource
	private ViewmultiqueryExample multiqueryExample;
	
	
	/**
	 * 用于获取所有的人员体检列表的信息
	 * @author 6月26日，罗杭春
	 * @return 返回一个列表
	 */
	@Override
	public List<Viewmultiquery> getMultiExamInfo() {
		multiqueryExample.clear();
		return multiqueryMapper.selectByExample(multiqueryExample);
	}

	
	/*
	 * 根据条件请求来发送查询到的数据
	 * @param 条件包含：企业账号、姓名、电话号码、体检状态 
	 * @author 罗杭春 6月26日
	 * @return 返回 查询到的信息列表
	 */
	@Override
	public List<Viewmultiquery> getExamInfoByCondition(Viewmultiquery multiCondition) {
		multiqueryExample.clear();
		ViewmultiqueryExample.Criteria criteria = multiqueryExample.createCriteria();
		
		if (!multiCondition.getAccount().equals("")) {
			criteria.andAccountEqualTo(multiCondition.getAccount());
		}
		if (!multiCondition.getName().equals("")) {
			criteria.andNameLike("%" + multiCondition.getName() + "%" );
		}
		if (!multiCondition.getTelephone().equals("")) {
			criteria.andTelephoneLike("%" + multiCondition.getTelephone() + "%" );
		}
		if (multiCondition.getState() != null) {
			criteria.andStateEqualTo(multiCondition.getState());
		}

		return multiqueryMapper.selectByExample(multiqueryExample);
	}


}
