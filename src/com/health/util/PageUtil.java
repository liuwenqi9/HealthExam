package com.health.util;

import java.util.ArrayList;
import java.util.List;
import com.github.pagehelper.PageInfo;

public class PageUtil {

	private static List<Object> pageContainer = new ArrayList<Object>(); //页码存放容器

	public static List<Object> displayPage(List modelList, int currentPage){
		
		PageInfo pageInfo = new PageInfo<>(modelList);
		
		final int  DISPLAYPAGE = 5; //每页显示的页数		
		int totalPage = pageInfo.getPages();  //总页数
		pageContainer.clear(); //情况历史页码
		
		//显示当前页码的前2页码和后两页码 
        //若1 则 1 2 3 4 5, 若2 则 1 2 3 4 5, 若3 则1 2 3 4 5,
        //若4 则 2 3 4 5 6 ,若10  则 8 9 10 11 12
		int indexPage = ((currentPage - 2) > 0) ? (currentPage - 2) : 1;
		for (int i = 0; i < DISPLAYPAGE && indexPage <= totalPage; i++,indexPage++) {			
			pageContainer.add(indexPage);
		}	
		
		return pageContainer;
	}
}
