package com.health.biz;
/**
 * 角色设置
 * @author 范帅
 * @date 6月19日
 *
 */

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Role;
@Service
public interface RoleMgBiz {
	/*
	 * 查询
	 */
	public ArrayList<Role> queryRoleList();
	
	/*
	 *删除 
	 */
	public int deleteRole(String roleid);
	/*
	 * 增加
	 */
	public int insertRole(Role Role);
	/*
	 * 代替自增
	 */
	public int lengthId();
	

}
