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
	public void checkName(HttpServletRequest req,HttpServletResponse res,String name) {
		System.out.println("------执行了公司名称查找");
	//获取前端界面数据
	System.out.println("查询的公司名称：--"+name);
		if(name!=null) {//不为空时,查询数据库
			
	 List<Account>  accountList=impRegister.findAccountByName(name);
			if(accountList.size()==0) {//找到该对象
				sendMesg="true";
			}else {
				sendMesg="false";
			}
			System.out.println("--查找的数量："+accountList.size());
			System.out.println("--返回的消息:"+sendMesg);
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
	public void checkAccount(HttpServletRequest req,HttpServletResponse res,String account) {
		System.out.println("---------执行了公司账号查找");
	//获取前端界面数据
	System.out.println("查询的公司账号：--"+account);
		if(account!=null) {//不为空时,查询数据库
			
	 List<Account>  accountList=impRegister.findAccountByAccount(account);
			if(accountList.size()==0) {//找到该对象
				sendMesg="true";
			}else {
				sendMesg="false";
			}
			System.out.println("--查找的数量："+accountList.size());
			System.out.println("--返回的消息:"+sendMesg);
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
	public void addAccount(HttpServletRequest req,HttpServletResponse res,
			String name,String account,String password,String locationname) {
			
		
		System.out.println("---------执行了企业注册");
		System.out.println("--接收到企业的全称："+name);
		System.out.println("--接收到企业的账号："+account);
		System.out.println("--接收到企业的密码："+password);
		System.out.println("--接收到企业的地址："+locationname);
		if(name!=null&&account!=null&&password!=null&&locationname!=null) {
			
		
		Account companyAccount=new Account();
			
		companyAccount.setName(name);
		companyAccount.setAccount(account);
		companyAccount.setPassword(password);
		companyAccount.setLocationname(locationname);
		companyAccount.setState((short) 1);//状态
		 int result=impRegister.addAccount(companyAccount);
		if(result>0) {//注册成功
			sendMesg="success";
		}else {
			sendMesg="failure";
		}
		feedBackData(res,sendMesg);	
		System.out.println("--注册结果：--"+sendMesg);
		sendMesg=null;
		}
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
