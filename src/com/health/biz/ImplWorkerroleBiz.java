package com.health.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Workerrole;
import com.health.mapper.WorkerroleMapper;
@Service
public class ImplWorkerroleBiz implements WorkerroleMgBiz {
	@Resource
	WorkerroleMapper workerroleMapper;
	@Override
	public int insert(Workerrole workerrole) {
		int i = workerroleMapper.insert(workerrole);
		return i;
	}

}
