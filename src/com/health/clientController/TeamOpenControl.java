package com.health.clientController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Charge;
import com.health.entity.Chargepack;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Guidepack;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;
import com.health.util.MyTimeUtil;

/**
 * 用于前端门户的点击开单
 * 
 * @author 罗杭春
 * @date 6月18日
 */
@Controller
public class TeamOpenControl {

	@Resource
	private TeamOpenBiz implTeamOpenBiz;
	private HashMap<String, Object> teamOpenMap = new HashMap<>();

	/**
	 * 获取团检开单的页面
	 * @return 返回指定的页面
	 */
	@RequestMapping("getTeamOpenJsp.action")
	public String getTeamOpenJsp() {
		return "jsp/clientJsp/teamOpen";
	}

	
	/**
	 * 获取该企业的人员列表和所有的套餐列表
	 * @return 返回装载了数据的map
	 * @author 罗杭春 6月24日
	 */
	@RequestMapping("getOriginalData.action")
	public @ResponseBody HashMap<String, Object> getOriginalData() {
		// 此处要根据登录的企业账号来搜索该账号下所有的员工
		ArrayList<Personinfo> personList = implTeamOpenBiz.getPersonListByAccount("4399kj"); // 获取所有的员工信息
		// 获取所有的套餐信息，发送到前端
		ArrayList<Packages> packageList = implTeamOpenBiz.getAllPackages();

		teamOpenMap.put("personList", personList);
		teamOpenMap.put("packageList", packageList);
		return teamOpenMap;
	}

	/**
	 * 企业用户对自己员工添加体检套餐
	 * @author 罗杭春 6月19日
	 * @return 返回一个模型和视图的对象，转发到相应页面
	 */
	@RequestMapping("makeCharge.action")
	public ModelAndView makeCharge(String[] personIdList,String[] packageIdList) {
		System.out.println("!!!!!--------请求makeCharge");
		for (int i = 0; i < personIdList.length; i++) {
			System.out.println(personIdList[i]);
		}
		for (int i = 0; i < packageIdList.length; i++) {
			System.out.println(packageIdList[i]);
		}

//		// 第一步：获取选中的员工的ID号
//		String[] personIdList = request.getParameterValues("personIdList");
//
//		// 第二步：获取选中的套餐ID号
//		String[] packageIdList = request.getParameterValues("packageIdList");


		String maxChargeId = null; // 当前最大的订单ID号
		int maxGuideId; // 当前最大的导检单ID号
		Short chargeState = 2; // 新账单状态：未接收
		short guideState = 1; // 导检单状态：未检查
		int allCost = 0;
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// 第三步：定义一条新的订单记账记录，插入到记账表中，并且如果成功，则查询插入记录的ID号
		Charge currentCharge = new Charge();
		currentCharge.setAccount("4399kj"); // 此时从session中获取账号???????????????????????????????????????
		currentCharge.setAmount(0L);
		currentCharge.setPretime(MyTimeUtil.getTimeNowTogether());
		currentCharge.setState(chargeState);
		int chargeResult = implTeamOpenBiz.insertCharge(currentCharge);
		if (chargeResult == 1) {
			maxChargeId = implTeamOpenBiz.getMaxChargeId(); // 获取当前账单最大的ID号，即为刚插入的chargeId
			System.out.println("订单记录生成成功，生成的ChargeId" + maxChargeId);
		} else {
			System.out.println("插入订单记录失败");
		}

		for (int i = 0; i < personIdList.length; i++) {

			// 第四步：遍历相应员工的ID列表，为每个员工插入导检单（生成导检单）
			maxGuideId = implTeamOpenBiz.getMaxGuideId(); // 获取当前最大ID号
			System.out.println("即将插入导检表的数据  " + (maxGuideId + 1) + " 体检人ID:" + personIdList[i]);
			Guide currentGuide = new Guide();
			currentGuide.setGuideid(maxGuideId + 1);
			currentGuide.setState(guideState);
			currentGuide.setChargeid(Integer.valueOf(maxChargeId));
			currentGuide.setTime(MyTimeUtil.getTimeNowTogether());
			currentGuide.setPersoninfoid(Integer.valueOf(personIdList[i]));
			int result = implTeamOpenBiz.insertGuide(currentGuide);

			// 第五步：插入导检项目关系表：
			for (int k = 0; k < packageIdList.length; k++) {
				String[] ItemIdList = implTeamOpenBiz.getItemIdsByPackageId(packageIdList[k]);
				for (int j = 0; j < ItemIdList.length; j++) {
					Guideitem guideitem = new Guideitem();
					guideitem.setGuideid((maxGuideId + 1));
					guideitem.setItemid(Integer.valueOf(ItemIdList[j]));
					implTeamOpenBiz.insertGuideItem(guideitem); // 插入记录到导检项目表
					// System.out.println("！！！！！！！插入导检项目表 " + (maxGuideId + 1) + ":" +
					// ItemIdList[j]);
				}

				/**
				 * 6月23日增加代码：插入导检套餐关系表的数据 导检ID和套餐ID是 1：N的关系，通过对套餐列表的遍历来插入数据
				 */
				Guidepack guidepack = new Guidepack();
				guidepack.setGuideid(maxGuideId + 1);
				guidepack.setPackageid(Integer.valueOf(packageIdList[k]));
				result = implTeamOpenBiz.insertGuidePack(guidepack);
				System.out.println("$$$$$$插入导检套餐关系表结果为：" + result);

				/**
				 * 6月24日增加代码：计算出每个套餐的价格，然后加入到总价中，用于记账使用
				 */
				String price = implTeamOpenBiz.getPriceByPackageId(packageIdList[k]);
				// System.out.println("当前套餐价格为：" + price);
				allCost += Integer.valueOf(price); // 加入到总价当中

			}

		}

		// 第六步：根据被选择的ID把所有的套餐信息查询并获取
		// ArrayList<Packages> packageList = new ArrayList<>();
		// packageList.add(implTeamOpenBiz.getPackageById(packageIdList[j]));
		// for (int j = 0; j < packageIdList.length; j++) {
		//
		// // 第七步：生成订单记账套餐关系记录，用于插入表中
		// Chargepack chargepack = new Chargepack();
		// chargepack.setChargeid(Integer.valueOf(maxChargeId));
		// chargepack.setPackageid(Integer.valueOf(packageIdList[j]));
		// chargepack.setNumbers(Integer.valueOf(personIdList.length));
		//
		// // 插入到订单记账套餐关系表中
		// implTeamOpenBiz.insertChargePack(chargepack);
		//
		// // 第八步：根据ID号查询价格
		// String price = implTeamOpenBiz.getPriceByPackageId(packageIdList[j]);
		// System.out.println("当前价格为：" + price);
		// allCost += Integer.valueOf(price); // 加入到总价当中
		//
		// }

		HashMap<String, Object> updateCostMap = new HashMap<>();
		updateCostMap.put("chargeId", maxChargeId);
		updateCostMap.put("amount", allCost);
		// 第九步：更新订单记账表的总价
		implTeamOpenBiz.updateAmountOfCharge(updateCostMap);

		ModelAndView mav = new ModelAndView("redirect:getTeamOpenJsp.action"); // 重定向到团检开单的页面
		return mav;

	}

	/**
	 * 获取查询所有的开单信息页面
	 * 
	 * @author 罗杭春 6月24日
	 * @return 返回一个模型视图到前端页面
	 */
	@RequestMapping("queryOpenInfo.action")
	public ModelAndView getQueryOpenInfoPage() {
		// 获取所有的已经预定的体检项目信息，发送到前端
		ArrayList<Viewpersonguideitemdept> orderList = implTeamOpenBiz.getOrderInfo("cykj123");
		ModelAndView mav = new ModelAndView("jsp/clientJsp/openInfo");
		mav.addObject("orderList", orderList);

		return mav;
	}

}
