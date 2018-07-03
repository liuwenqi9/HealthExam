package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

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
	@Resource
	RoleExample example;
	
	@Override
	public ArrayList<Role> queryRoleList() {
		ArrayList<Role> rlList = (ArrayList<Role>) roleMapper.selectByExample(example);
		return rlList;
	}

	@Override
	public int deleteRole(String rolename) {
		int i = roleMapper.deleteRole(rolename);
		return i;
	}

	@Override
	public int insertRole(Role role) {
		int i = roleMapper.insertRole(role);
		return i;
	}

	@Override
	public int lengthId() {
		int i = roleMapper.lengthId();
		return 0;
	}

	@Override
	public int updateRole(HashMap<String, String>map) {
		int i = roleMapper.updateRole (map);
		return i ;
	}

}
