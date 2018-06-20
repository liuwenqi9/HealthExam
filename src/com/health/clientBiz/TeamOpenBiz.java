package com.health.clientBiz;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.health.entity.Charge;
import com.health.entity.Chargepack;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;

/**
 * 处理团队开单业务的接口
 * 
 * @date 6月18日
 * @author 罗杭春
 */

public interface TeamOpenBiz {

	public ArrayList<Personinfo> getPersonList(String account); // 查询特定账户下的所有员工信息

	public ArrayList<Packages> getAllPackages(); // 用于插叙所有的套餐信息

	public String[] getItemIdsByPackageId(String packageId);

	public int getMaxGuideId(); // 获取导检表中现在ID号的最大值

	public int insertGuide(Guide currentGuide); // 插入一条导检信息

	public int insertCharge(Charge currentCharge); // 用户插入一条订单记账信息

	public String getMaxChargeId(); 

	public String insertGuideItem(Guideitem guideitem);

	public Packages getPackageById(String packageId);

	public void insertChargePack(Chargepack chargepack);

	public String getPriceByPackageId(String packageId);

	public void updateAmountOfCharge(HashMap<String, Object> updateCostMap); //更新记账表某个记录的价格

	public ArrayList<Viewpersonguideitemdept> getOrderInfo(String account);   //获取所有的已经预定体检的项目详细信息

}
