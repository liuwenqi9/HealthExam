package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Dept;
import com.health.entity.DeptExample;
import com.health.entity.DeptExample.Criteria;
import com.health.mapper.DeptMapper;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=false)
public class DeptService {

	@Resource
	private DeptMapper deptMapper;
	@Resource 
	private DeptExample deptExample;
	
	//查询科室
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Dept> checkDepts(){	
		deptExample.clear();//清空Where条件
		deptExample.setOrderByClause("deptid DESC"); //对ID进行倒序排列
		Criteria criteria = deptExample.createCriteria();
		criteria.andStateEqualTo(0);
		List<Dept> list = deptMapper.selectByExample(deptExample);		
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Dept> isDeptReapt(String deptname) { //判断科室是否重复
		deptExample.clear();//清空Where条件
		Criteria criteria = deptExample.createCriteria();
		criteria.andDeptnameEqualTo(deptname);
		criteria.andStateEqualTo(0);
		List<Dept> list = deptMapper.selectByExample(deptExample);
		return list;
	}
	
	//添加科室
	public int addDept(Dept record) {
		int flag = deptMapper.insertSelective(record);
		return flag;	
	}
	
	//更改科室
	public int updateDelt(Dept record) {		
		int flag = deptMapper.updateByPrimaryKeySelective(record);
		return flag;		
	}
	
	//删除科室
	public void delDept(Dept record) {
		deptMapper.updateByPrimaryKeySelective(record);
	}
	
	//搜索科室
	public List<Dept> serachDept(String name) {	
		
		deptExample.clear(); //清空Where条件
		Criteria criteria = deptExample.createCriteria();
		String sql = "%" + name + "%";
		criteria.andDeptnameLike(sql);
		criteria.andStateEqualTo(0);
		deptExample.setOrderByClause("deptid DESC"); //对ID进行倒序排列
		List<Dept> list = deptMapper.selectByExample(deptExample);
		return list;
	}
}
