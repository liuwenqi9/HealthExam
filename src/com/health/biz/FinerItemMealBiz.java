package com.health.biz;

import java.util.List;

import com.health.entity.Dept;
import com.health.entity.Detail;
import com.health.entity.Itemdetail;
import com.health.entity.Items;
import com.health.entity.Parameter;

/*
 * 细项项目套餐业务层接口
 * @author PYC
 * @date 6月19日
 */

public interface FinerItemMealBiz {
	
	public List<Detail> selectDetailPage(String sItemName);
	
	public Detail selectById(int id);

	public int updateByDetail(Detail detail);
	
	public List<Parameter> selectAllParameter();
	
	public int insertDetail(Detail detail);
	
	public int deleteDetailById(Integer detailid);

	public List<Items> selectItemPage(String sItemName);
	
	public List<Dept> selectAllDept();
	
	public List<Detail> selectDetailByItemId(Integer itemId);
	
	public int updateByItem(Items item);
	
	public int deleteItemById(Integer itemId);
	
	public int insertItem(Items item);
	
	public int insertItemdetail(Itemdetail itemdetail);
	
	public int selectItemidByItemname(String itemname);
	
}