package com.health.biz;

import java.util.List;

import com.health.entity.Detail;

/*
 * 细项项目套餐业务层接口
 * @author PYC
 * @date 6月19日
 */

public interface FinerItemMealBiz {
	
	public List<Detail> selectPage(int page);

}
