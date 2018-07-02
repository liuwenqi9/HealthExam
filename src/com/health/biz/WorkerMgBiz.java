package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.health.entity.Account;
import com.health.entity.Worker;
/**
 * 人员设置功能的BIZ
 * 后期有时间进行更改人员管理的科室和角色字段
 * 进行了创建视图，在VEWORKER的表
 * @author 范帅
 * @date 6月18日
 *
 */
@Service
public interface WorkerMgBiz {
	public int updateWorker(Integer workerid,Integer deptid);
	public int deleteWorkerrole(Integer workerid,Integer roleid);
	
	public int deleteFkWork(String name);//删除workerrole中的关系表，这样才能删除员工表，否则id被占用
	
	public int resetPassword(String name);//重置密码
	
	public int queryMaxId();
	
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
