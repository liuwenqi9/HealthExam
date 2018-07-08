package com.health.biz;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.NA;

import org.springframework.stereotype.Service;

import com.health.entity.Menu;
import com.health.entity.MenuExample;
import com.health.entity.Rolepower;
import com.health.entity.Worker;
import com.health.entity.Workerrole;
import com.health.mapper.MenuMapper;
import com.health.mapper.RolepowerMapper;
import com.health.mapper.WorkerMapper;
import com.health.mapper.WorkerroleMapper;
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
	@Resource
	WorkerMapper workerMapper;
	@Resource
	WorkerroleMapper workerroleMapper;
	@Resource
	RolepowerMapper rolepowerMapper;

	
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


	@Override
	public String queryDept(String name) {
		String i = menuMapper.queryDept(name);
		return i;
	}


	@Override
	public Worker queryWorker(String name) {
		Worker workers = workerMapper.queryWorkerName(name);
		return workers;
	}


	@Override
	public Workerrole queryWorkerrole(int workerid) {
		Workerrole workerroles = workerroleMapper.queryWorkerrole(workerid);
		return workerroles;
	}


	@Override
	public ArrayList<Rolepower> queryRolePower(int roleid) {
		ArrayList<Rolepower> rolepowers = rolepowerMapper.queryRplePower(roleid);
		return rolepowers;
	}


	@Override
	public Menu queryMenuid(int menuid) {
		Menu menus = menuMapper.queryMenuid(menuid);
		return menus;
	}

}
