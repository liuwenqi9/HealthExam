package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.RegisterBiz;
import com.health.entity.Account;
/**
 * 
 * @author JSY
 * @date 20180615
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Resource
	private RegisterBiz impRegister;
	private  String sendMesg =null;
	
	/**
	 * 跳转至注册界面
	 * 
	 */
	@RequestMapping(value ="/register.action")
	public ModelAndView resigsterView() {
		System.out.println("启动注册");
		ModelAndView mav = new ModelAndView("jsp/commonJsp/companyregister");
		return mav;
	}
	/**
	 * 公司名称唯一性查找
	 * @param req
	 * @param res 
	 */
	@RequestMapping(value = "/checkName.action" , method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public void checkName(HttpServletRequest req,HttpServletResponse res,String companyName) {
		System.out.println("------执行了公司名称查找");
	//获取前端界面数据
	System.out.println("查询的公司名称：--"+companyName);
		if(companyName!=null) {//不为空时,查询数据库
			
	 List<Account>  accountList=impRegister.findAccountByName(companyName);
			if(accountList.size()==0) {//找到该对象
				sendMesg="该公司可以注册!";
			}else {
				sendMesg="该公司已注册，请直接登录!";
			}
			System.out.println("--查找的数量："+accountList.size());
			System.out.println("--反回的消息:"+sendMesg);
			feedBackData(res,sendMesg);	
		}
	
		sendMesg=null;
	}
	/**
	 * 公司账号唯一性查找
	 * @param req
	 * @param res 
	 * @param account 6月18日补充
	 */
	@RequestMapping(value = "/checkAccount.action" , method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public void checkAccount(HttpServletRequest req,HttpServletResponse res,String companyAccount) {
		System.out.println("---------执行了公司账号查找");
	//获取前端界面数据
	System.out.println("查询的公司账号：--"+companyAccount);
		if(companyAccount!=null) {//不为空时,查询数据库
			
	 List<Account>  accountList=impRegister.findAccountByAccount(companyAccount);
			if(accountList.size()==0) {//找到该对象
				sendMesg="该账号可以注册!";
			}else {
				sendMesg="该账号已存在，请更改!";
			}
			System.out.println("--查找的数量："+accountList.size());
			System.out.println("--反回的消息:"+sendMesg);
			feedBackData(res,sendMesg);	
		}
	
		sendMesg=null;
	}
	/**
	 * 注册用户
	 * 日期：6月16日
	 * @param req
	 * @param res
	 * @param account 对象 6月18日
	 */
	@RequestMapping(value = "/addAccount.action" , method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public void addAccount(HttpServletRequest req,HttpServletResponse res,Account account) {
		System.out.println("---------执行了企业注册");
		account.setState((short) 1);
		
		 int result=impRegister.addAccount(account);
		if(result>0) {//注册成功
			sendMesg="注册成功!";
		}else {
			sendMesg="注册失败!";
		}
		feedBackData(res,sendMesg);	
		System.out.println("--注册结果：--"+sendMesg);
		sendMesg=null;
	}
	
	
	
	
	 /**
	   * 通过PrintWriter将响应数据写入response
	   * 
	   * @param response
	   * @param data 
	   */
	  private void feedBackData(HttpServletResponse response, String data) {
	    PrintWriter printWriter = null;
	    try {
	      printWriter = response.getWriter();
	      printWriter.print(data);
	    } catch (IOException ex) {
	    } finally {
	      if (null != printWriter) {
	        printWriter.flush();
	        printWriter.close();
	      }
	    }
	  }

	/**
	 * get/set方法
	 * 
	 */
	
	public RegisterBiz getImpRegister() {
		return impRegister;
	}

	public void setImpRegister(RegisterBiz impRegister) {
		this.impRegister = impRegister;
	}
	public String getSendMesg() {
		return sendMesg;
	}
	public void setSendMesg(String sendMesg) {
		this.sendMesg = sendMesg;
	}
	
	
	
	
	
}
