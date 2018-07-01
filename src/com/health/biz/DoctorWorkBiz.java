package com.health.biz;

import java.util.List;

import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Guideitemsview;
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
			public 	List<Guideitemsview> findGuideItemsViewByid(Integer guideId,Integer itemId);
			//根据体检项目表ID修改体检项目关系表中的体检时间
			public int updateExamTimeByid(Integer guideitemId,Integer itemId, String time);
			//根据体检项目表ID修改体检项目关系表中的体检小结
			public int updateSummaryByid(Integer guideitemId,Integer itemId, String summary);
			//根据部门id查找体检项目关系表对象
			public List<Guideitemsview> findGuideItemsViewByDeptId(Integer deptId);
			
}

