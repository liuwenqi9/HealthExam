package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Exampeople;
import com.health.entity.ExampeopleExample;
import com.health.entity.ExampeopleExample.Criteria;
import com.health.mapper.ExampeopleMapper;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
public class ExamPeopleBiz {

	@Resource
	ExampeopleMapper examPeopleMapper;
	
	@Resource
	ExampeopleExample examPeopleExample;
	
	public List<Exampeople> getPeople(){ //获取体检人数据	
		examPeopleExample.clear();
		List<Exampeople> list = examPeopleMapper.selsectAllPeople(examPeopleExample);
		
		return list;
	}
	
	public List<Exampeople> peopleDetail(String name){ //获取当前体检人明细
		examPeopleExample.clear();
		Criteria criteria = examPeopleExample.createCriteria();
		criteria.andNameEqualTo(name);
		List<Exampeople> list = examPeopleMapper.selectPeopleDetail(examPeopleExample);
		
		return list;
	}
	
	public List<Exampeople> search(String name, String telephone, String barcode, String startTime, String endTime){
		examPeopleExample.clear();
		Criteria criteria = examPeopleExample.createCriteria();
		criteria.andNameLike("%" + name + "%");
		criteria.andTelephoneLike("%" + telephone + "%");
		criteria.andBarcodeLike("%" + barcode + "%");
		
		if(!startTime.equals("") || !endTime.equals("")) {			
			criteria.andGuidetimeBetween(startTime, endTime);
		}
		List<Exampeople> list = examPeopleMapper.selsectAllPeople(examPeopleExample);
		return list;
	}
}
