package com.health.clientController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Charge;
import com.health.entity.Chargepack;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Packages;
import com.health.entity.Personinfo;
import com.health.entity.Viewpersonguideitemdept;

/**
 * 用于前端门户的点击开单
 * @author 罗杭春
 * @date 6月18日
 */
@Controller
// @RequestMapping("/clientAction")
public class TeamOpenControl {

	@Resource
	TeamOpenBiz implTeamOpenBiz;

	/**
	 * 获取团检开单的页面
	 * 
	 * @return 返回一个模型和视图的对象，转发到相应页面
	 */
	@RequestMapping("getTeamOpenJsp.action")
	public ModelAndView getTeamOpenJsp() {

		//此处要根据登录的企业账号来搜索该账号下所有的员工
		ArrayList<Personinfo> personList = implTeamOpenBiz.getPersonList("cykj123");  // 获取所有的员工信息
		//获取所有的套餐信息，发送到前端
		ArrayList<Packages> packageList = implTeamOpenBiz.getAllPackages();
		//获取所有的已经预定的体检项目信息，发送到前端
		ArrayList<Viewpersonguideitemdept> orderList = implTeamOpenBiz.getOrderInfo("cykj123");

		ModelAndView mav = new ModelAndView("jsp/clientJsp/teamOpen");
		mav.addObject("personList", personList);
		mav.addObject("packageList", packageList);
		mav.addObject("orderList", orderList);
		return mav;
	}

	/**
	 * 企业用户对自己员工添加体检套餐
	 * @author 罗杭春 6月19日
	 * @return 返回一个模型和视图的对象，转发到相应页面
	 */
	@RequestMapping("makeCharge.action")
	public ModelAndView makeCharge(HttpServletRequest request) {
		System.out.println("请求makeCharge");

		// 第一步：获取选中的员工的ID号
		String[] personIdList = request.getParameterValues("personIdList");

		// 第二步：获取选中的套餐ID号
		String[] packageIdList = request.getParameterValues("packageIdList");

		String maxChargeId = null;
		int maxGuideId; // 当前最大的导检单ID号
		Short state = 1;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// 第三步：定义一条新的订单记账记录，插入到记账表中，并且如果成功，则查询插入记录的ID号
		Charge currentCharge = new Charge();
		currentCharge.setAccount("cykj123"); // 此时从session中获取账号???????????????????????????????????????
		currentCharge.setAmount(0L);
		currentCharge.setPretime(dateFormat.format(new Date()));
		currentCharge.setState(state);
		int chargeResult = implTeamOpenBiz.insertCharge(currentCharge);
		if (chargeResult == 1) {
			System.out.println("订单记录生成成功");
			maxChargeId = implTeamOpenBiz.getMaxChargeId(); // 获取当前账单最大的ID号，即为刚插入的chargeId
			System.out.println("生成的ChargeId" + maxChargeId);
		} else {
			System.out.println("插入订单记录失败");
		}

		for (int i = 0; i < personIdList.length; i++) {

			// 第四步：遍历相应员工的ID列表，为每个员工插入导检单（生成导检单）
			maxGuideId = implTeamOpenBiz.getMaxGuideId(); // 获取当前最大ID号
			System.out.println("即将插入导检表的数据  " + (maxGuideId + 1) + ":" + personIdList[i]);
			Guide currentGuide = new Guide();
			currentGuide.setGuideid(maxGuideId + 1);
			currentGuide.setState(state);
			currentGuide.setTime(dateFormat.format(new Date()));
			currentGuide.setPersoninfoid(Integer.valueOf(personIdList[i]));
			int result = implTeamOpenBiz.insertGuide(currentGuide);
			System.out.println("插入导检表的结果为---------：" + result);

			// 第五步：插入导检项目关系表：
			for (int k = 0; k < packageIdList.length; k++) {
				String[] ItemIdList = implTeamOpenBiz.getItemIdsByPackageId(packageIdList[k]);
				for (int j = 0; j < ItemIdList.length; j++) {
					Guideitem guideitem = new Guideitem();
					guideitem.setGuideid((maxGuideId + 1));
					guideitem.setItemid(Integer.valueOf(ItemIdList[j]));
					implTeamOpenBiz.insertGuideItem(guideitem); // 插入记录到导检项目表
					System.out.println("插入导检项目表  " + (maxGuideId + 1) + ":" + ItemIdList[j]);
				}
			}
		}

		int allCost = 0;
		// 第六步：根据被选择的ID把所有的套餐信息查询并获取
		// ArrayList<Packages> packageList = new ArrayList<>();
		// packageList.add(implTeamOpenBiz.getPackageById(packageIdList[j]));
		for (int j = 0; j < packageIdList.length; j++) {

			// 第七步：生成订单记账套餐关系记录，用于插入表中
			Chargepack chargepack = new Chargepack();
			chargepack.setChargeid(Integer.valueOf(maxChargeId));
			chargepack.setPackageid(Integer.valueOf(packageIdList[j]));
			chargepack.setNumbers(Integer.valueOf(personIdList.length));

			// 插入到订单记账套餐关系表中
			implTeamOpenBiz.insertChargePack(chargepack);

			// 第八步：根据ID号查询价格
			String price = implTeamOpenBiz.getPriceByPackageId(packageIdList[j]);
			System.out.println("当前价格为：" + price);
			allCost += Integer.valueOf(price); // 加入到总价当中

		}

		HashMap<String, Object> updateCostMap = new HashMap<>();
		updateCostMap.put("chargeId", maxChargeId);
		updateCostMap.put("amount", allCost);
		// 第九步：更新订单记账表的总价
		implTeamOpenBiz.updateAmountOfCharge(updateCostMap);

		ModelAndView mav = new ModelAndView("redirect:getTeamOpenJsp.action");  //重定向到团检开单的页面
		return mav;

	}

}
