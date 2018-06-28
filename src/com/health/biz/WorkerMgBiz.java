package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.entity.Worker;
/**
 * 人员设置功能的BIZ
 * @author 范帅
 * @date 6月18日
 *
 */
@Service
public interface WorkerMgBiz {
	
	public int lengthid();//得到表格的id号码
	
	public int insertWorker(Worker worker); //用于后台管理员手动开通一个后台账户
	
	public int deleteWork(String name); //用于后台管理员手动删除一个后台账户
	
	public Worker queryOneWorker(Worker worker); //用于后台管理员根据账号或者状态查询一个后台账户
	
	public int updateWork(String worker);   //用于后台管理员根据账号修改一个后台账户
	
	public ArrayList<Worker> queryWorkerList(); //用于后台管理员进行工作人员的
	
	public int changeWorkerState(HashMap<String, String> dataMap); //用于后台管理员进行管理工作人员的状态

	public ArrayList<Worker> queryWorker(String name);  //用于工作人员的 模糊查询
	public ArrayList<Worker> queryWorkerState(String state);
}
