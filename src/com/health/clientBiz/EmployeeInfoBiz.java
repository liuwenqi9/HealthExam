package com.health.clientBiz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.health.entity.Personinfo;

/**
 * 企业端的员工信息
 * @date 6月27日
 * @author 毛聪
 */
@Service
public interface EmployeeInfoBiz {

	public List<Personinfo> employeeList(String account);  //员工信息列表- account企业账号
	
}
