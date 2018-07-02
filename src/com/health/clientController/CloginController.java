package com.health.clientController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.ImplLoginBiz;
import com.health.clientBiz.LoginClientBiz;
import com.health.entity.Account;
import com.health.entity.Worker;

/*
 * 用于前端门户的登陆
 * 
 * @author 毛聪
 * @date 6月14日
 */

@Controller
public class CloginController {

	@Resource
	LoginClientBiz implLoginClientBiz; // 后端接口-用于实现登陆

	PrintWriter printWriter;

	/*
	 * 时间：2018.6.14 打开企业登陆界面
	 * 
	 * @autuor 毛聪
	 */
	@RequestMapping("loginClietJsp.action")
	public ModelAndView loginClietJsp() {
		ModelAndView mav = new ModelAndView("jsp/loginEnterprise");
		return mav;
	}

	/*
	 * 时间：2018.6.14 登陆、验证码
	 * 
	 * @autuor 毛聪
	 */
	@RequestMapping("loginCliet.action")
	public void loginAdmin(HttpSession session, HttpServletResponse response, HttpServletRequest request,
			Account account) throws IOException {
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");

		String verCode = request.getParameter("VerificationCode");
		System.out.println(verCode + "验证码" + session.getAttribute("imageCode"));
		System.out.println(account.getAccount() + "" + account.getPassword());

		printWriter = response.getWriter();
		if (verCode.equalsIgnoreCase(session.getAttribute("imageCode").toString())) {

			Account login = implLoginClientBiz.loginClient(account);
			if (login != null) {
				session.setAttribute("AccountID", account.getAccount());
				session.setAttribute("AccountPwd", account.getPassword());
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("登陆失败");

			}
		} else {
			printWriter.print("FAILCode");
			printWriter.flush();
			printWriter.close();
			System.out.println("验证码错误");
		}
	}

	/*
	 * 时间：2018.6.14 打开企业端界面
	 * 
	 * @autuor 毛聪
	 */
	@RequestMapping("loginClientThis.action")
	public ModelAndView loginClientThis() {
		ModelAndView mav = new ModelAndView("jsp/clientJsp/userHome");

		return mav;
	}

	/*
	 * 
	 * 修改密码界面
	 * 
	 * @data：2018.6.27
	 * 
	 * @autuor 毛聪
	 */
//	@RequestMapping("userUpdatePwd.action")
//	public ModelAndView updatePwdJsp() {
//		ModelAndView mav = new ModelAndView("jsp/clientJsp/updatepwd");		
//		return mav;
//
//	}
	@RequestMapping(value = "userUpdatePwd.action")
	public String employeeInfoJsp() {
		
		
		return "jsp/clientJsp/updatepwd";
	}
	
	
	/*
	 * 
	 * 修改密码
	 * 
	 * @data：2018.6.28
	 * 
	 * @autuor 毛聪
	 */
	@RequestMapping(value ="updatePwd.action")
	public void updatePwd(HttpSession session, HttpServletResponse response,String oldPwd,String newPwd1,String newPwd2) throws IOException {
		String pwd=session.getAttribute("AccountPwd").toString();
		System.out.println(oldPwd+newPwd1+newPwd2+pwd);
		Account account=new Account();
		printWriter = response.getWriter();	
		if(oldPwd.equals(pwd) ){
			account.setAccount(session.getAttribute("AccountID").toString());
			account.setPassword(newPwd1);
			implLoginClientBiz.updatePwd(account);
			printWriter.print("OK");
			printWriter.flush();
			printWriter.close();
			System.out.println("修改成功");
		}else {
			
			printWriter.print("FAIL");
			printWriter.flush();
			printWriter.close();
			System.out.println("原密码错误");

		}
		
		
	}

}
