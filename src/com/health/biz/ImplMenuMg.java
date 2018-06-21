package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Menu;
import com.health.entity.MenuExample;
import com.health.mapper.MenuMapper;
/**
 * 后台菜单管理BIZ的实现类
 * @author 范帅
 * @date 6月19日
 *
 */
@Service
public class ImplMenuMg implements MenuMgBiz {
	
	@Resource
	MenuMapper menuMapper;

	
	/**
	 * 实现查询所有菜单的信息
	 * @author 范帅
	 * @date 6月19日
	 */
	@Override
	public ArrayList<Menu> queryMenuList() {
		MenuExample example = new MenuExample();
		ArrayList<Menu>muList = (ArrayList<Menu>) menuMapper.selectByExample(example);
		return muList;
	}

}
