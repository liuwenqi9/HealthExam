package com.health.biz;

import org.springframework.stereotype.Service;

import com.health.entity.Personinfo;


/**
 * 
 * @author JSY
 * @date 6月25日
 */
@Service
public interface PersoninfoBiz {
				//添加人员
			public int addPersoninfo(Personinfo personinfo);
				
}
