package com.health.mapper;

import com.health.entity.Menu;
import com.health.entity.MenuExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface MenuMapper {
	ArrayList<Menu>queryAllMenu();
	Menu queryMenuid(int menuid);
	String queryDept(String name);
	int deleteMenu(String menuname);
	int updataMenu(Menu menu);
	public ArrayList<Menu> querymenuName(String menuname);
	
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuid);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}