package com.health.clientController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.ImplLoginBiz;
import com.health.clientBiz.LoginClientBiz;
import com.health.entity.Account;
import com.health.entity.Worker;

@Controller
public class CloginController {


		@Resource
		LoginClientBiz implLoginClientBiz;


		@Resource
		private ImplLoginBiz impLoginBiz; // 后端接口-用于实现登陆

		/*
		 * 时间：2018.6.14 后台界面显示
		 */
		@RequestMapping("loginClietJsp.action")
		public ModelAndView loginClietJsp() {		
			ModelAndView mav = new ModelAndView("jsp/loginEnterprise");
			return mav;
		}

		

		@RequestMapping("loginCliet.action")
		public void loginAdmin(HttpServletResponse response, Account account) throws IOException {
			response.setContentType("text/text");
			response.setCharacterEncoding("UTF-8");
			
			
			System.out.println(account.getAccount() + "" + account.getPassword());
			Account login = implLoginClientBiz.loginClient(account);
			PrintWriter printWriter = response.getWriter();
			if (login != null) {
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();		
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("登陆失败");
			}
			
		}
		
		@RequestMapping("loginClientThis.action")
		public ModelAndView loginClientThis() {
			 ModelAndView mav = new ModelAndView("jsp/clientJsp/userHome");
			
			 return mav;
		}
		
		

	}

