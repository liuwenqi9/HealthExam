package com.health.biz;

import java.util.List;

import com.health.entity.Viewmultiquery;

//用于综合查询的接口
public interface IntMultiQueryBiz {
	
	public List<Viewmultiquery> getMultiExamInfo();

//	public List<Viewmultiquery> getExamInfoByCondition(String accountId, String personName, String telephone,
//			String state);

	List<Viewmultiquery> getExamInfoByCondition(Viewmultiquery multiCondition);

}
