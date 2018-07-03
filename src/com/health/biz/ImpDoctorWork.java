package com.health.biz;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Detail;
import com.health.entity.DetailExample;
import com.health.entity.Detaildata;
import com.health.entity.DetaildataExample;
import com.health.entity.Detaildataview;
import com.health.entity.DetaildataviewExample;
import com.health.entity.Guide;
import com.health.entity.GuideExample;
import com.health.entity.Guideitem;
import com.health.entity.GuideitemExample;
import com.health.entity.Guideitemsview;
import com.health.entity.GuideitemsviewExample;
import com.health.entity.Itemdetail;
import com.health.entity.ItemdetailExample;
import com.health.entity.Items;
import com.health.entity.ItemsExample;
import com.health.entity.GuideExample.Criteria;
import com.health.entity.Personinfo;
import com.health.entity.PersoninfoExample;
import com.health.mapper.DetailMapper;
import com.health.mapper.DetaildataMapper;
import com.health.mapper.DetaildataviewMapper;
import com.health.mapper.GuideMapper;
import com.health.mapper.GuideitemMapper;
import com.health.mapper.GuideitemsviewMapper;
import com.health.mapper.ItemdetailMapper;
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
	@Resource
	private GuideitemsviewExample guideitemsviewExample;//导检体检视图
	@Resource
	private GuideitemsviewMapper guideitemsviewMapper;//导检体检mapper
	@Resource
	private DetaildataExample detaildataExample;//细项数据表
	@Resource
	private DetaildataMapper detaildataMapper;//细项数据表mapper
	@Resource
	private ItemdetailExample itemdetailExample;//项目细项关系表
	@Resource
	private ItemdetailMapper itemdetailMapper;//项目细项关系表mapper
	@Resource
	private DetailExample detailExample;//细项配置表
	@Resource
	private DetailMapper detailMapper;//细项配置表mapper
	@Resource
	private DetaildataviewExample detaildataviewExample;//细项数据表视图
	@Resource
	private DetaildataviewMapper detaildataviewMapper;//细项数据mapper
	
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
	
	//根据体检项目表ID查找视图体检项目对象
	@Override
	public 	List<Guideitemsview> findGuideItemsViewByid(Integer guideId) {
		guideitemsviewExample.clear();
		List<Guideitemsview> guideitemsviewList=null;
		com.health.entity.GuideitemsviewExample.Criteria criteria=guideitemsviewExample.createCriteria();
		/*criteria.andGuideitemidEqualTo(guideitemId);*/
		criteria.andGuideidEqualTo(guideId);
		criteria.andAllsummaryIsNull();//0702添加
		criteria.andOvertimeIsNull();//0702添加
		 guideitemsviewList= guideitemsviewMapper.selectByExample(guideitemsviewExample);	
		return guideitemsviewList;
	}
	
	//根据体检项目表ID修改体检项目关系表中的体检时间
	@Override
	public int updateExamTimeByid(Integer guideitemId,Integer itemId,String time) {
		guideitemExample.clear();
		com.health.entity.GuideitemExample.Criteria criteria = guideitemExample.createCriteria();
		criteria.andItemidEqualTo(itemId);
		criteria.andGuideitemidEqualTo(guideitemId);
		Guideitem guideitem=new Guideitem();
		guideitem.setExamtime(time);
		 int result=guideitemMapper.updateByExampleSelective(guideitem, guideitemExample);
		return result;
	}

	
	//根据体检项目表ID修改体检项目关系表中的体检小结
	@Override
	public int updateSummaryByid(Integer guideitemId, Integer itemId, String summary) {
		guideitemExample.clear();
		com.health.entity.GuideitemExample.Criteria criteria = guideitemExample.createCriteria();
		criteria.andItemidEqualTo(itemId);
		criteria.andGuideitemidEqualTo(guideitemId);
		Guideitem guideitem=new Guideitem();
		guideitem.setSummary(summary);
		int result=guideitemMapper.updateByExampleSelective(guideitem, guideitemExample);	
		return result;
	}
	//根据部门id查找体检项目关系表对象
	@Override
	public List<Guideitemsview> findGuideItemsViewByDeptId(Integer deptId) {
		System.out.println("----------" + deptId);
		guideitemsviewExample.clear();
		List<Guideitemsview> guideitemsviewList=null;
		com.health.entity.GuideitemsviewExample.Criteria criteria=guideitemsviewExample.createCriteria();
		criteria.andDeptidEqualTo(deptId);
		criteria.andSummaryIsNull();
		criteria.andExamtimeIsNotNull();
		 guideitemsviewList= guideitemsviewMapper.selectByExample(guideitemsviewExample);	
		return guideitemsviewList;
	}
	//数据插入细项数据表
	@Override
	public int insertDetaildata(Integer guideitemid, Integer detailid, BigDecimal detaildata) {
		
		Detaildata detail=new Detaildata();
		detail.setGuideitemid(guideitemid);
		detail.setDetailid(detailid);
		detail.setDetaildata(detaildata);
	int result=	detaildataMapper.insertSelective(detail);
		return result;
	}
	//查找项目细项关系表
	@Override
	public List<Itemdetail> findItemdetail(Integer itemid) {
		itemdetailExample.clear();
		List<Itemdetail> list=null;
		com.health.entity.ItemdetailExample.Criteria  criteria=itemdetailExample.createCriteria();
		criteria.andItemidEqualTo(itemid);
		list=itemdetailMapper.selectByExample(itemdetailExample);
		return list;
	}
	//根据细项配置表ID查找细项配置对象
	@Override
	public Detail findDetailById(Integer detailid) {
		detailExample.clear();
		com.health.entity.DetailExample.Criteria criteria=	detailExample.createCriteria();
		criteria.andDetailidEqualTo(detailid);
		Detail de=detailMapper.selectByPrimaryKey(detailid);
		return de;
	}
	
	
	//通过体检项目iD和导检项目关系表id查找细项视图对象
	@Override
	public List<Detaildataview> findDetaildataViewbyid(Integer itemid, Integer guideitemid) {
		detaildataviewExample.clear();
		List<Detaildataview> list=null;
		com.health.entity.DetaildataviewExample.Criteria criteria =detaildataviewExample.createCriteria();
		criteria.andItemidEqualTo(itemid);
		criteria.andGuideitemidEqualTo(guideitemid);
		list=  detaildataviewMapper.selectByExample(detaildataviewExample);
		return list;
	}
	//插入导检卡对象
	@Override
	public int insertGuidebyid(Integer guideId, String allsummary, String overtime) {
		Criteria criteria =guideExample.createCriteria();
		criteria.andGuideidEqualTo(guideId);
		Guide guide=new Guide();
		guide.setAllsummary(allsummary);
		guide.setOvertime(overtime);
		int result=guideMapper.insertSelective(guide);
		
		return result;
	}

	
	
	
	

}
