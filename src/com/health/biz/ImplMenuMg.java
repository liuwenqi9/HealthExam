package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.NA;

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


	@Override
	public int deleteMenu(String menuname) {
		int i = menuMapper.deleteMenu(menuname);
		return i;
	}


	@Override
	public ArrayList<Menu> queryMenu(String menuname) {
		ArrayList<Menu> queryListMenu = menuMapper.querymenuName(menuname);
		return queryListMenu;
	}


	@Override
	public int updataMenu(Menu menu) {
		int i = menuMapper.updataMenu(menu);
		return i;
	}

}
