package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Dept;
import com.health.entity.DeptExample;
import com.health.mapper.DeptMapper;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=false)
public class DeptService {

	@Resource
	private DeptMapper deptMapper;
	@Resource 
	private DeptExample deptExample;
	
	//查询科室
	@Transactional(isolation=Isolation.REPEATABLE_READ, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Dept> checkDepts(){
		
		List<Dept> list = deptMapper.selectByExample(deptExample);
		
		return list;
	}
	
	//添加科室
	public int addDept(Dept record) {
		int flag = deptMapper.insertSelective(record);
		return flag;	
	}
}
