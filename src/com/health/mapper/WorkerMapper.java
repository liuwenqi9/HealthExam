package com.health.mapper;

import com.health.entity.Worker;
import com.health.entity.WorkerExample;
import com.mysql.fabric.xmlrpc.base.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkerMapper {
	int updateWorker(Integer workerid,Integer deptid);
	int deleteFkWork(String name);
	int resetPassword(String name);
	int insertWorker(Worker worker);
	int queryMaxId();
    int lengthId();
    int deleteWork(String name);
    public ArrayList<Worker> queryworkerName(String name);
    public  ArrayList<Worker> queryworkerState(String state);
	
	public Worker loginAdmin(Worker worker);  //登陆
	
    int countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);

    int deleteByPrimaryKey(Integer workerid);

    int insert(Worker record);

    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);

    Worker selectByPrimaryKey(Integer workerid);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
    
    /**
     * 范帅增加修改工作人员状态接k
     */
    int changeWorkerState(HashMap<String, String> dataMap);
    
    
    
}