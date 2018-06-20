package com.health.clientBiz;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.health.entity.Charge;
import com.health.entity.Chargepack;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;
import com.health.mapper.ChargeMapper;
import com.health.mapper.ChargepackMapper;
import com.health.mapper.GuideMapper;
import com.health.mapper.GuideitemMapper;
import com.health.mapper.PackagesMapper;
import com.health.mapper.PackitemMapper;
import com.health.mapper.PersoninfoMapper;
import com.health.mapper.ViewpersonguideitemdeptMapper;

/**
 * TeamOpenBiz接口的实现类
 * @author 罗杭春
 * @date 6月18日
 */
@Service
public class ImplTeamOpenBiz implements TeamOpenBiz {

	@Resource 
	private PersoninfoMapper personinfoMapper;
	@Resource
	private PackagesMapper packagesMapper;
	@Resource
	private PackitemMapper packitemMapper;
	@Resource 
	private GuideMapper guideMapper;
	@Resource
	private ChargeMapper chargeMapper;
	@Resource
	private GuideitemMapper guideitemMapper;
	@Resource
	private ChargepackMapper chargepackMapper;
	@Resource
	private ViewpersonguideitemdeptMapper viewPgidMapper;
	
	/**
	 * 实现获取特定账户下的所有员工列表
	 * @param 一个特定的账户ID号
	 * @author 罗杭春  6月18日
	 * @return 返回一个员工信息列表
	 */
	@Override
	public ArrayList<Personinfo> getPersonList(String account) {
		ArrayList<Personinfo> personList = personinfoMapper.getPersonList(account);
		return personList;
	}

	/**
	 * 用于插叙所有的套餐信息
	 * @author 罗杭春  6月18日
	 */
	@Override
	public ArrayList<Packages> getAllPackages() {
		ArrayList<Packages> packageList = packagesMapper.getAllPackages();
		return packageList;
	}

	/**
	 * 根据套餐ID号来查询该套餐包含的所有的项目ID号
	 * @author 罗杭春  6月19日
	 * @return 返回一个字符串数组
	 */
	@Override
	public String[] getItemIdsByPackageId(String packageId) {
		String[] currentList = packitemMapper.getItemIdsByPackageId(packageId);
		return currentList;
	}
	
	/**
	 * 获取导检表中现在ID号的最大值
	 * @author 罗杭春  6月19日
	 * @return 返回一个id号
	 */
	@Override
	public int getMaxGuideId() {
		return guideMapper.getMaxGuideId();
	}

	/**
	 * 用于插入一条导检信息记录
	 * @author 罗杭春  6月19日
	 * @return 返回一个结果（整数）
	 */
	@Override
	public int insertGuide(Guide currentGuide) {
		return guideMapper.insertGuide(currentGuide);
	}

	/**
	 * 用于建立一条订单记账信息
	 * @author 罗杭春  6月19日
	 * @return 返回一个结果（整数）
	 */
	@Override
	public int insertCharge(Charge currentCharge) {
		return chargeMapper.insertCharge(currentCharge);
	}

	/**
	 * 获取现在订单记账的ID最大值
	 * @author 罗杭春  6月19日
	 * @return 返回一个结果（整数）
	 */
	@Override
	public String getMaxChargeId() {
		return chargeMapper.getMaxChargeId();
	}

	/**
	 * 插入数据到导检项目关系表
	 * @author 罗杭春  6月19日
	 * @return 返回一个结果（整数）
	 */
	@Override
	public String insertGuideItem(Guideitem guideitem) {
		return guideitemMapper.insertGuideItem(guideitem);
	}

	/**
	 * 根据ID号获取套餐对象
	 * @author 罗杭春  6月19日
	 * @return 返回一个结果（整数）
	 */
	@Override
	public Packages getPackageById(String packageId) {
		return packagesMapper.getPackageById(packageId);
	}

	/**
	 * 插入一条记录到订单套餐关系表中
	 * @author 罗杭春  6月19日
	 */
	@Override
	public void insertChargePack(Chargepack chargepack) {
		chargepackMapper.insertChargePack(chargepack);
		
	}

	/**
	 * 根据套餐ID号来获取该套餐的价格
	 * @author 罗杭春  6月19日
	 */
	@Override
	public String getPriceByPackageId(String packageId) {
		 
		return packagesMapper.getPriceByPackageId(packageId);
	}

	/**
	 * 用于修改订单记账表的账目额度
	 * @param 接收一个hashmap为参数，包含了chargeId和金额allCost
	 * @author 罗杭春  6月19日
	 */
	@Override
	public void updateAmountOfCharge(HashMap<String, Object> updateCostMap) {
		chargeMapper.updateAmountOfCharge(updateCostMap);
	}

	/**
	 * 用于获取指定企业账号下所有体检预定信息
	 * @param 接收一个企业账号作为参数
	 * @author 罗杭春  6月20日
	 */
	@Override
	public ArrayList<Viewpersonguideitemdept> getOrderInfo(String account) {
		return viewPgidMapper.getOrderInfo(account);
	}
	

}