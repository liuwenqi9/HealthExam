package com.health.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Menu;

/**
 * 菜单管理模块接口
 * @author 范帅
 * @date 6月19日
 *  
 */
@Service
public interface MenuMgBiz {
	
	
	public ArrayList<Menu> queryMenuList();//对菜单列表进行查询

}
