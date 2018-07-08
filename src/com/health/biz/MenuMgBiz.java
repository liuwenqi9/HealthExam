package com.health.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Menu;
import com.health.entity.Rolepower;
import com.health.entity.Worker;
import com.health.entity.Workerrole;

/**
 * 菜单管理模块接口
 * @author 范帅
 * @date 6月19日
 *  
 */
@Service
public interface MenuMgBiz {
	public Menu queryMenuid(int menuid);
	public ArrayList<Rolepower> queryRolePower(int roleid);
	public Workerrole queryWorkerrole(int workerid);
	public Worker queryWorker(String name);
	public ArrayList<Menu> queryMenuList();//对菜单列表进行查询
	public int deleteMenu(String menuname);//对菜单进行删除
	public ArrayList<Menu> queryMenu(String menuname);//对菜单进行
	public int updataMenu(Menu menu);//对菜单名称进行修改
	public String queryDept(String name);

}
