package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Parameter;
import com.health.mapper.ParameterMapper;

@Service
public class ImplParameterBiz implements ParameterMgBiz {
	@Resource
	ParameterMapper parameterMapper;

	@Override
	public List<Parameter> queryParameter() {
		System.out.println("asd");
		List<Parameter> queryList = parameterMapper.queryParameter();

		System.out.println(queryList);
		return queryList;

	}

	@Override
	public int insertParameter(Parameter parameter) {

		int i = parameterMapper.insertParameter(parameter);
		System.out.println("ImplParameterBiz添加参数");
		return i;
	}

	@Override
	public int lengthId() {
           //通过查找读取表数据条数， 返回，实现自增
		int i = parameterMapper.lengthId();

		return i;
	}

	@Override
	public int deleteParameter(String paramname) {
		int i = parameterMapper.deleteParameter(paramname);
		return i;
	}

}
