package com.health.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.health.entity.Parameter;

/*
 * 参数管理接口
 * @author 毛聪
 * @date 6.19 
 */

public interface ParameterMgBiz {

	public List<Parameter>  queryParameter();
	
	public int insertParameter(Parameter parameter);
	
	public int lengthId();  //获取表ID长度，代替自增
	
	public int deleteParameter(String paramname);  
	
	public int updataParameter(Parameter paramname);
	
}
