package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Worker;
import com.health.entity.WorkerExample;
import com.health.mapper.WorkerMapper;

/**
 * 后台人员设置的BIZ的实现类
 * @author 范帅
 * @date 6月18日
 *
 */
@Service
public class ImplWorkerMg implements WorkerMgBiz{
	@Resource
	WorkerMapper workerMapper;
	@Resource
	WorkerExample example;

	/*@Override
	public int insertWorker() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWork(String workerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Worker queryOneWorker(Worker worker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWork(String worker) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	/**
	 * 实现查询所用工作人员的信息
	 * @author 范帅
	 * @date 6月18号
	 * 
	 */
	@Override
	public ArrayList<Worker> queryWorkerList() {
		//使用WorkerExample进行查询
		example.clear();
		example.setOrderByClause("workerid ASC");
		ArrayList<Worker>wkList = (ArrayList<Worker>) workerMapper.selectByExample(example);
		return wkList;
	}

	@Override
	public int changeWorkerState(HashMap<String, String> dataMap) {
		int result = workerMapper.changeWorkerState(dataMap);
		return result;
	}

	/*@Override
	public int changeWorkerState(HashMap<String, String> dataMap) {
		对工作人员进行禁用与启用
		int result = workerMapper.changeAccountState(dataMap);
		return 0;
	}*/
	

}
