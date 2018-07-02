package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Veworker;
import com.health.entity.VeworkerExample;
import com.health.mapper.VeworkerMapper;
@Service
public class ImplVeworkerMg implements VeworkerMgBiz {

	@Resource
	VeworkerMapper veworkerMapper;
	@Resource
	VeworkerExample example;

	@Override
	public ArrayList<Veworker> queryWorkerList() {
		example.clear();
		example.setOrderByClause("workerid ASC");
		ArrayList<Veworker>wkList = (ArrayList<Veworker>) veworkerMapper.selectByExample(example);
		return wkList;
	}

}
