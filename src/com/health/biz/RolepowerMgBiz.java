package com.health.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Rolepower;

/**
 * 权限管理模块接口
 * @author 范帅
 * @date 6月19日
 */
@Service
public interface RolepowerMgBiz {
	
	public ArrayList<Rolepower> queryRolepowerList();

}
