package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.RegisterBiz;
import com.health.entity.Account;
/**
 * 
 * @author JSY
 *
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
	@RequestMapping("resigster.action")
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
	@RequestMapping("addAccount.action")
	public void addAccount(HttpServletRequest req,HttpServletResponse res) {
	//获取前端界面数据
	String companyName=	req.getParameter("companyName");
	System.out.println("查询的公司名称：--"+companyName);
		if(companyName!=null) {//不为空时,查询数据库
			
	 List<Account>  accountList=impRegister.findAccountByName(companyName);
			if(accountList!=null) {//找到该对象
				sendMesg="该公司已注册，请直接登录！";
			}else {
				sendMesg="该公司可以注册！";
			}
			feedBackData(res,sendMesg);	
		}
	
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
