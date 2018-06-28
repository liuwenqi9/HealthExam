package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Worker;
import com.health.entity.WorkerExample;
import com.health.entity.WorkerExample.Criteria;
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

	@Override
	public int lengthid() {
		int i = workerMapper.lengthId();
		return i;
	}
	/**
	 * 增加接口的实现
	 * @author 范帅
	 * @date 6-25
	 */
	@Override
	public int insertWorker(Worker worker) {
		int i = workerMapper.insertWorker(worker);
		return i;
	}

	@Override
	public int deleteWork(String name) {
		int i = workerMapper.deleteWork(name);
		return i;
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
	}

	@Override
	public ArrayList<Worker> queryWorker(String name) {
		ArrayList<Worker> queryListWorker = workerMapper.queryworkerName(name);
		return queryListWorker;
	}

	@Override
	public ArrayList<Worker> queryWorkerState(String state) {
		ArrayList<Worker> queryListWorker = workerMapper.queryworkerState(state);
		return queryListWorker;
	}


	

}
