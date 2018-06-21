package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Role;
import com.health.entity.RoleExample;
import com.health.mapper.RoleMapper;

/**
 * 角色配置BIZ的实现类
 * @author 范帅
 * @date 6月19日
 *
 */
@Service
public class ImplRoleMg implements RoleMgBiz {
	
	@Resource
	RoleMapper roleMapper;
	
	@Override
	public ArrayList<Role> queryRoleList() {
		RoleExample example = new RoleExample();
		ArrayList<Role> rlList = (ArrayList<Role>) roleMapper.selectByExample(example);
		return rlList;
	}

}
