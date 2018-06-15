package com.health.biz;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.health.entity.Worker;
import com.health.mapper.WorkerMapper;
/*
 * 时间:2018.6.14
 * 登陆接口实现类
 * @author 毛聪
 */

@Service
public class ImplLoginBiz implements IntLoginBiz {
	@Resource
	private WorkerMapper workerMapper;

	@Override
	public Worker loginAdmin(Worker worker) {
		
		List<Worker> wokers= workerMapper.loginAdmin(worker);
		
		
		return wokers.get(0);
	}




}
