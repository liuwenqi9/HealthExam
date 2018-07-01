package com.health.biz;

import java.util.List;

import com.health.entity.Viewguideinfo;
import com.health.entity.Viewpersonguidepack;

public interface PrintPaperBiz {

	public List<Viewguideinfo> getGuideDataByGuideId(Integer guideId);

}
