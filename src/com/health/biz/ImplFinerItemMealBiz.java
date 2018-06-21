package com.health.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.health.entity.Detail;
import com.health.mapper.DetailMapper;
import com.health.mapper.ItemsMapper;
import com.health.mapper.PackitemMapper;

/*
 * 细项项目套餐业务层实现类
 * @author PYC
 * @date 6月19日
 */
@Service
public class ImplFinerItemMealBiz implements FinerItemMealBiz{
	
	@Resource
	DetailMapper detailMapper;
	@Resource
	ItemsMapper itemsMapper;
	@Resource
	PackitemMapper packitemMapper;
	
	/*
	 * 细项分页查询
	 * param1: page 查询页
	 * param2: type 查询的表
	 * return: List<Object> 列表
	 */
	public List<Detail> selectPage(int page){
		List<Detail> list;
		list = detailMapper.selectPageList(page);
		return list;
	}

}
