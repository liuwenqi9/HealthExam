package com.health.clientBiz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.mapper.PackagesMapper;
import com.health.mapper.PackitemMapper;
import com.health.mapper.PersoninfoMapper;

/**
 * TeamOpenBiz接口的实现类
 * @author 罗杭春
 * @date 6月18日
 */
@Service
public class ImplTeamOpenBiz implements TeamOpenBiz {

	@Resource
	private PersoninfoMapper personinfoMapper;
	@Resource
	private PackagesMapper packagesMapper;
	@Resource
	private PackitemMapper packitemMapper;
	
	/**
	 * 实现获取特定账户下的所有员工列表
	 * @param 一个特定的账户ID号
	 * @author 罗杭春  6月18日
	 * @return 返回一个员工信息列表
	 */
	@Override
	public ArrayList<Personinfo> getPersonList(String account) {
		ArrayList<Personinfo> personList = personinfoMapper.getPersonList(account);
		return personList;
	}

	/**
	 * 用于插叙所有的套餐信息
	 * @author 罗杭春  6月18日
	 */
	@Override
	public ArrayList<Packages> getAllPackages() {
		ArrayList<Packages> packageList = packagesMapper.getAllPackages();
		return packageList;
	}

	/**
	 * 根据套餐ID号来查询该套餐包含的所有的项目ID号
	 * @author 罗杭春  6月18日
	 * @return 返回一个字符串数组
	 */
	@Override
	public String[] getItemIdsByPackageId(String packageId) {
		String[] currentList = packitemMapper.getItemIdsByPackageId(packageId);
		return currentList;
	}

}
