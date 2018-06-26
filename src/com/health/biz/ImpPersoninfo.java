package com.health.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Personinfo;
import com.health.mapper.PersoninfoMapper;
/**
 * 
 * @author JSY
 * @date 6月25日
 */

@Service
public class ImpPersoninfo implements PersoninfoBiz {
	@Resource
	private  PersoninfoMapper personinfoMapper;//体检人员mapper
	
	//添加体检人员
	@Override
	public int addPersoninfo(Personinfo personinfo) {
		
		return personinfoMapper.insertSelective(personinfo);
	}

}
