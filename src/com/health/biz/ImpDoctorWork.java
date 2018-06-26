package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.health.entity.Guide;
import com.health.entity.GuideExample;
import com.health.entity.Guideitem;
import com.health.entity.GuideitemExample;
import com.health.entity.Items;
import com.health.entity.ItemsExample;
import com.health.entity.GuideExample.Criteria;
import com.health.entity.Personinfo;
import com.health.entity.PersoninfoExample;
import com.health.mapper.GuideMapper;
import com.health.mapper.GuideitemMapper;
import com.health.mapper.ItemsMapper;
import com.health.mapper.PersoninfoMapper;

/**
 * 
 * @author JSY
 * @date 6月23日
 */
@Service
public class ImpDoctorWork  implements DoctorWorkBiz{
	@Resource
	private GuideExample guideExample;//导检表
	@Resource
	private GuideMapper guideMapper;//导检表mapper
	 @Resource
	private PersoninfoExample personinfoExample;//体检者
	 @Resource
    private PersoninfoMapper personinfoMapper;//体检者mapper
	@Resource
	private GuideitemExample guideitemExample;//导检项目关系表
	@Resource
	private GuideitemMapper guideitemMapper;//导检项目关系表mapper
	@Resource
	private ItemsExample itemsExample;//体检项目表
	@Resource
	private ItemsMapper itemsMapper;//体检项目表mapper
	
	
	//通过导诊卡id查找导诊卡对象
	@Override
	public Guide findGuideById(Integer id) {
		guideExample.clear();
		Criteria criteria =guideExample.createCriteria();
		criteria.andGuideidEqualTo(id);
		 Guide list=guideMapper.selectByPrimaryKey(id);
		return list;
	}

	//通过体检者id查找体检者对象
	@Override
	public Personinfo findPersoninfoById(Integer id) {
		personinfoExample.clear();
		com.health.entity.PersoninfoExample.Criteria criteria =personinfoExample.createCriteria();
		criteria.andPersoninfoidEqualTo(id);
		Personinfo list=personinfoMapper.selectByPrimaryKey(id);
		return list;
	}
	//根据体检表id查找导检项目关系表项目对象集合
	@Override
	public List<Guideitem> findItemIdByid(Integer id) {
		guideitemExample.clear();
		com.health.entity.GuideitemExample.Criteria criteria = guideitemExample.createCriteria();
		criteria.andGuideidEqualTo(id);
		List<Guideitem>	guideitemList =guideitemMapper.selectByExample(guideitemExample);
		return guideitemList;
	}
	//根据体检项目表ID查找体检项目表对象
	@Override
	public Items findItemByid(Integer id) {
		itemsExample.clear();
		com.health.entity.ItemsExample.Criteria	criteria=itemsExample.createCriteria();
		criteria.andItemidEqualTo(id);
		Items items=itemsMapper.selectByPrimaryKey(id);
		
		return items;
	}
	//根据体检项目表ID修改体检项目关系表中的体检时间
	@Override
	public int updateExamTimeByid(Integer id,String time) {
		guideitemExample.clear();
		com.health.entity.GuideitemExample.Criteria criteria = guideitemExample.createCriteria();
		criteria.andItemidEqualTo(id);
		Guideitem guideitem=new Guideitem();
		guideitem.setExamtime(time);
		 int result=guideitemMapper.updateByExampleSelective(guideitem, guideitemExample);
		return result;
	}

	
	
	
	

}
