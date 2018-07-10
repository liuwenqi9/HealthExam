package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Hotpack;
import com.health.mapper.HotpackMapper;
@Service
public class ImplGuidPack implements GuidPackBiz {

	/**
	 * @author 范帅
	 * 进行热度的查询
	 */
	@Resource
	HotpackMapper hotpackMapper;
	
	@Override
	public ArrayList<Hotpack> queryHot() {
		 ArrayList<Hotpack> hotpacks = hotpackMapper.queryHot();
		return hotpacks;
	}

}
