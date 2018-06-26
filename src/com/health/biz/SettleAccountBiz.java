package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.GuideExample;
import com.health.entity.Mysettleview;
import com.health.entity.MysettleviewExample;
import com.health.entity.MysettleviewExample.Criteria;
import com.health.mapper.GuideMapper;
import com.health.mapper.GuideitemMapper;
import com.health.mapper.MysettleviewMapper;


@Service
@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
public class SettleAccountBiz {

	@Resource
	MysettleviewMapper mysettleviewMapper;
	
	@Resource
	MysettleviewExample mysettleviewExample;

	@Resource
	GuideMapper guideMapper; 
	
	@Resource
	GuideExample guideExample;
	
	public List<Mysettleview> getMsg(){ //读取数据
		mysettleviewExample.clear();
		Criteria criteria = mysettleviewExample.createCriteria();
		criteria.andRecordstateNotEqualTo(2);
		mysettleviewExample.setOrderByClause("chargeid DESC");
		List<Mysettleview> list = mysettleviewMapper.selectAllData(mysettleviewExample);
		return list;
	}
	
	//获取订单详情
	public List<Mysettleview> getBillDetail(Integer chargeid){
		mysettleviewExample.clear();
		Criteria criteria = mysettleviewExample.createCriteria();
		criteria.andChargeidEqualTo(chargeid);
		mysettleviewExample.setOrderByClause("guidestate ASC");
		List<Mysettleview> list = mysettleviewMapper.selectRecorderDetail(mysettleviewExample);
		return list;
	}
	
	public Mysettleview totalPrice(Integer chargeid) {
		mysettleviewExample.clear();
		Criteria criteria = mysettleviewExample.createCriteria();
		criteria.andChargeidEqualTo(chargeid);
		Mysettleview mySettleView = mysettleviewMapper.selectTotalPrice(mysettleviewExample);
		return mySettleView;
	}
	
	//找出未体检的人员
	public List<Mysettleview> getNotGuidePeople(Integer chargeid){
		mysettleviewExample.clear();
		Criteria criteria = mysettleviewExample.createCriteria();
		criteria.andChargeidEqualTo(chargeid);
		criteria.andGuidestateEqualTo(1);
		mysettleviewExample.setDistinct(true);
		List<Mysettleview> list = mysettleviewMapper.selectByExample(mysettleviewExample);
		return list;
	}
	
	//改变导检单状态
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=false)
	public int changeGuide(List<Mysettleview> list) {
		
		int flag = guideMapper.updateBatch(list);		
		return flag;
	}
	
	public List<Mysettleview> getOneRecord(Integer chargeid) {
		mysettleviewExample.clear();
		Criteria criteria = mysettleviewExample.createCriteria();
		criteria.andChargeidEqualTo(chargeid);
		mysettleviewExample.setDistinct(true);
		List<Mysettleview> list = mysettleviewMapper.selectByExample(mysettleviewExample);
		return list;
	}
}
