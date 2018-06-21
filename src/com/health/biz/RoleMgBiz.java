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

	public ArrayList<Role> queryRoleList();
	

}
