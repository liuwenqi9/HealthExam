package com.health.biz;

import org.springframework.stereotype.Service;

import com.health.entity.Workerrole;
@Service
public interface WorkerroleMgBiz {
	
	//增加数据
	public int insert(Workerrole workerrole);

}
