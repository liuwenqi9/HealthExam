package com.health.clientController;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.clientBiz.TeamOpenBiz;
import com.health.entity.Packages;
import com.health.entity.Personinfo;

/**
 * 用于前端门户的用户请求的调度和转发功能
 * 
 * @author 罗杭春
 * @date 6月18日
 */
@Controller
// @RequestMapping("/clientAction")
public class ClientControl {

	@Resource
	TeamOpenBiz implTeamOpenBiz;

	/**
	 * 获取团检开单的页面
	 * 
	 * @return 返回一个模型和视图的对象，转发到相应页面
	 */
	@RequestMapping("getTeamOpenJsp.action")
	public ModelAndView getTeamOpenJsp() {
		System.out.println("请求getTeamOpenJsp---------------");

		ArrayList<Personinfo> personList = implTeamOpenBiz.getPersonList("cykj123"); // 获取所有的员工信息
		ArrayList<Packages> packageList = implTeamOpenBiz.getAllPackages();

		ModelAndView mav = new ModelAndView("jsp/clientJsp/teamOpen");
		mav.addObject("personList", personList);
		mav.addObject("packageList", packageList);

		return mav;
	}

	/**
	 * 企业用户对自己员工添加体检套餐
	 * 
	 * @return 返回一个模型和视图的对象，转发到相应页面
	 */
	@RequestMapping("makeCharge.action")
	public ModelAndView makeCharge(HttpServletRequest request) {
		System.out.println("请求makeCharge");

		// 第一步：获取选中的员工的ID号
		String[] personIdList = request.getParameterValues("personIdList");
		// 第二步：获取选中的套餐ID号
		String[] packageIdList = request.getParameterValues("packageIdList");

		ArrayList<String[]> itemIdList = new ArrayList<>();

		for (int i = 0; i < packageIdList.length; i++) {
			String[] currentList = implTeamOpenBiz.getItemIdsByPackageId(packageIdList[i]);
				for (String string : currentList) {
					System.out.println("该套餐包含的itemsID:" + string);
				}
			itemIdList.add(currentList);  //加入到列表中
		}
		
		
		// 使用packageList来获取的数据，并且加入到ItemIDlist中
		// 使用ArrayList来存储，每个元素是一个String数组，每个数组中存储着每个套餐的项目itemID

		// 第四步：解析出所有套餐ID号下面的项目ID，形成列表：itemIdList

		for (int i = 0; i < personIdList.length; i++) {
			/**
			 * 第三步：获取导检表中最大的ID号的下一位可用ID号，使用personIdList长度作为循环条件，依次插入导检单 //获取导检表的可用ID号
			 * guideID,和personID一并插入到导检表中 //insert into .......
			 */

			for (int j = 0; j < itemIdList.size(); j++) {
				for (int h = 0; h < itemIdList.get(j).length; h++) {
//					System.out.println(itemIdList.get(j)[h]);
					/*
					 * 插入到导检项目关系表中，guideID为当前循环的数据，ItemsID为itemIdList.get(j)[h]
					 */
				}

			}

			// 计算出总额
			// 插入到charge 记账套餐表中
		}

		ArrayList<Packages> packageList = implTeamOpenBiz.getAllPackages();

		ModelAndView mav = new ModelAndView("jsp/clientJsp/teamOpen");

		return mav;

	}

}
