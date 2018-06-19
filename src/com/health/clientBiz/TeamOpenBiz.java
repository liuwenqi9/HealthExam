package com.health.clientBiz;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Packages;
import com.health.entity.Personinfo;

/**
 * 处理团队开单业务的接口
 * @date 6月18日
 * @author 罗杭春
 */

public interface TeamOpenBiz {

	public ArrayList<Personinfo> getPersonList(String account); // 查询特定账户下的所有员工信息
	
	public ArrayList<Packages> getAllPackages(); //用于插叙所有的套餐信息

	public String[] getItemIdsByPackageId(String packageId);
}
