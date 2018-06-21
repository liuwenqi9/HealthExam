package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Rolepower;
import com.health.entity.RolepowerExample;
import com.health.mapper.RolepowerMapper;
/**
 * 角色权限管理BIZ的实现类
 * @author 范帅
 * @date 6月19日
 *
 */
@Service
public class ImplRolepowerMg implements RolepowerMgBiz {

	@Resource
	RolepowerMapper rolepowerMapper;
	
	/**
	 * 实现查询所有权限
	 * @author 范帅
	 * @date 6月19日
	 */
	@Override
	public ArrayList<Rolepower> queryRolepowerList() {
		RolepowerExample example = new RolepowerExample();
		ArrayList<Rolepower>rpList = (ArrayList<Rolepower>) rolepowerMapper.selectByExample(example);
		return rpList;
	}

}
