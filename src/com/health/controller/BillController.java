package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.health.biz.ChargeBiz;
import com.health.entity.Account;
import com.health.entity.Charge;
import com.health.util.PageUtil;

/*
 * 团检结款
 * 
 * @autur 毛聪
 * 
 * @data 6.29
 * 
 */
@Controller
public class BillController {

	@Resource
	ChargeBiz chargeBiz;

	private int dataNum = 10; // 每页显示数据

	private Map<String, Object> billListMsg = new HashMap<String, Object>(); // ajax数据回传

	@RequestMapping(value = "squareAccount.action")
	public String billMg() {
		return "jsp/systemMgJsp/bill";
	}

	@RequestMapping(value = "loadBillList.action")
	public @ResponseBody Map<String, Object> loadDept(HttpSession session) {
		// 加载
		PageHelper.startPage(1, dataNum);
		System.out.println("before enter method ");

		List<Charge> list = chargeBiz.queryBillList();
		System.out.println("after enter method ");
		// 分页
		List<Object> pageContanier = PageUtil.displayPage(list, 1);
		billListMsg.clear();
		// 数据
		billListMsg.put("billList", list);
		billListMsg.put("pageContanier", pageContanier);

		return billListMsg;
	}

	@RequestMapping(value = "pageItemeBill.action")
	public @ResponseBody Map<String, Object> pageMethod(String currentPage) {

		billListMsg.clear(); // 清空历史分页参数
		// 判断是否携带搜索条件
		List<Charge> list;

		PageHelper.startPage(Integer.parseInt(currentPage), dataNum);
		list = chargeBiz.queryBillList();
		// 分页
		List<Object> pageContanier = PageUtil.displayPage(list, Integer.parseInt(currentPage));
		// 数据
		billListMsg.put("billList", list);
		billListMsg.put("pageContanier", pageContanier);

		return billListMsg;
	}

	@RequestMapping(value = "settlement.action")
	public void settlement(HttpServletResponse response, Charge charge) throws IOException {
		System.out.println(charge.getChargeid() + "" + charge.getAmount());
		Account account = chargeBiz.queryMoney(charge);
		System.out.println("余额:" + account.getAmount());
		PrintWriter printWriter = response.getWriter();

		double accAmount = account.getAmount().doubleValue();
		
		double chAmount = charge.getAmount().doubleValue();

		double money = accAmount - chAmount;

		if (money >= 0) {

			long balance = new Double(money).longValue();
			System.out.println("money" + money + account.getAccount() + "balance" + balance);

			account.setAmount(balance);
			int result = chargeBiz.updateMoney(account);  //修改账户余额				
			if (result > 0) {
				charge.setState((short)0);
				int i=chargeBiz.updatestate(charge);
				System.out.println("i"+i);
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
				System.out.println("结款成功");
			}

		} else {
			printWriter.print("FALL");
			printWriter.flush();
			printWriter.close();
			System.out.println("余额不足");
		}
	}

}
