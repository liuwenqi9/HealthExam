package com.health.biz;

import java.math.BigDecimal;
import java.util.List;

import com.health.entity.Detail;
import com.health.entity.Detaildataview;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Guideitemsview;
import com.health.entity.Itemdetail;
import com.health.entity.Items;
import com.health.entity.Personinfo;


/**
 * 
 * @author JSY
 * @date 6月23日
 */
public interface DoctorWorkBiz {
				//查找导诊表byid
			public Guide findGuideById(Integer id);
				//查找体检者byid
			public Personinfo findPersoninfoById(Integer id);
			//根据体检表id查找导检项目关系表项目id
			public List<Guideitem> findItemIdByid(Integer id);
			//根据体检项目表ID查找体检项目表对象
			public 	List<Guideitemsview> findGuideItemsViewByid(Integer guideId);
			//根据体检项目表ID修改体检项目关系表中的体检时间
			public int updateExamTimeByid(Integer guideitemId,Integer itemId, String time);
			//根据体检项目表ID修改体检项目关系表中的体检小结
			public int updateSummaryByid(Integer guideitemId,Integer itemId, String summary);
			//根据部门id查找体检项目关系表对象
			public List<Guideitemsview> findGuideItemsViewByDeptId(Integer deptId);
			//插入数据到细项数据表
			public int insertDetaildata(Integer guideitemid,Integer detailid,BigDecimal detaildata );
			//根据体检项目ID查找细项配置表ID
			public List<Itemdetail> findItemdetail(Integer itemid);
			//根据细项配置表ID查找细项配置对象
			public Detail findDetailById(Integer detailid);
			//通过体检项目iD和导检项目关系表id查找细项视图对象
			public List<Detaildataview> findDetaildataViewbyid(Integer itemid,Integer guideitemid);
			//插入导检卡对象
			public int insertGuidebyid(Integer guideId,String allsummary,String overtime);
			
			
}

