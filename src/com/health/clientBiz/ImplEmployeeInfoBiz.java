package com.health.clientBiz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Personinfo;
import com.health.mapper.PersoninfoMapper;

@Service
public class ImplEmployeeInfoBiz implements EmployeeInfoBiz {

	@Resource
	PersoninfoMapper personinfoMapper;

	@Override
	public List<Personinfo> employeeList(String account) {
		List<Personinfo> resultList = personinfoMapper.employeeList(account);

		return resultList;
	}

}
