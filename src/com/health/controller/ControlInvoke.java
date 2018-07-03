package com.health.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.health.biz.ImplAccountMg;
import com.health.biz.ImplLoginBiz;
import com.health.entity.Account;
import com.health.biz.MenuMgBiz;
import com.health.entity.Menu;
import com.health.entity.Rolepower;
import com.health.entity.Worker;
import com.health.entity.Workerrole;
import com.health.util.ImageUtil;

@Controller
public class ControlInvoke {

	@Resource
	ImplAccountMg ImplAccountMg;
	@Resource
	MenuMgBiz implMenuMg;
	
	PrintWriter printWriter;
	Worker worker;
	/*
	 * 跳转模板 用户转发到自己需要的jsp 自己复制这个模板，修改请求路径action、修改 转发路径
	 * 
	 * @RequestMapping的action注解为 ：xxxx.action 注意jsp路径直接使用 jsp/xxxx.jsp
	 */

	@Resource
	private ImplLoginBiz impLoginBiz; // 后端接口-用于实现登陆

	@RequestMapping("invokeTest.action")
	public ModelAndView invokeTest() {
		ModelAndView mav = new ModelAndView("jsp/index");
		return mav;
	}

	/*
	 * 时间：2018.6.14 后台界面显示
	 */
	@RequestMapping("loginJsp.action")

	public ModelAndView loginJsp() {
		ModelAndView mav = new ModelAndView("jsp/loginBackend");
		return mav;
	}

	@RequestMapping("loginAdmin.action")
	public void loginAdmin(HttpSession session, HttpServletResponse response, HttpServletRequest request, Worker worker)
			throws IOException {
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		this.worker = worker;
		System.out.println(worker.getName() + "" + worker.getPassword());

		String verCode = request.getParameter("VerificationCode");
		System.out.println(verCode + "验证码" + session.getAttribute("imageCode"));

		PrintWriter printWriter = response.getWriter();
		if (verCode.equalsIgnoreCase(session.getAttribute("imageCode").toString())) {

			Worker login = impLoginBiz.loginAdmin(worker);
			if (login != null) {
				session.setAttribute("WorkerName", worker.getName());
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("登陆失败");
			}
		}else {
			
			printWriter.print("FAILCode");
			printWriter.flush();
			printWriter.close();
			System.out.println("验证码错误");
		}


	}

	@RequestMapping("loginThis.action")
	public ModelAndView loginThis(HttpServletRequest request,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("jsp/index");
		/**
		 * 这块为范帅添加
		 * @author 范帅
		 */
		//进行查找 worker表
		Worker wor = implMenuMg.queryWorker((String) worker.getName());
		if (wor != null) {
			//进行再一步查询
			int workerid = wor.getWorkerid();
			Workerrole workerrole = implMenuMg.queryWorkerrole(workerid);
			if (workerrole != null) {
				int roleid = workerrole.getRoleid();
				ArrayList<Rolepower> rolepowers = new ArrayList<>();
				rolepowers = implMenuMg.queryRolePower(roleid);
				ArrayList<Menu> mList = new ArrayList<>();
				if (rolepowers != null) {
					for (Rolepower rolepower : rolepowers) {
						int menuid = rolepower.getMenuid();
						Menu menus =null;
						menus = implMenuMg.queryMenuid(menuid);
						System.out.println(menus);
						mList.add(menus);
					}
					Gson gson = new Gson();
					String gson_mList = gson.toJson(mList);
					System.out.println(gson_mList);
					session.setAttribute("mList", mList);
					/*mav.addObject("mList",mList);*/
				}
				String rp = new Gson().toJson(rolepowers);
				System.out.println(rp);
			}
			String wr = new Gson().toJson(workerrole);
			System.out.println(wr);
		}
		
		Gson gson = new Gson();
		String gson_work = gson.toJson(wor);
		
		System.out.println(gson_work);
		
		return mav;
	}

	/**
	 * 生成验证码
	 * 
	 * @param request
	 * @param tbuser
	 * @return
	 */
	@RequestMapping(value = "/createImage.action", method = RequestMethod.GET)
	public @ResponseBody void createImage(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("111112");
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 生成验证码
		Map<String, BufferedImage> imageMap = ImageUtil.createImage();
		String code = imageMap.keySet().iterator().next();
		request.getSession().setAttribute("imageCode", code);

		// 返回生成的验证码
		BufferedImage image = imageMap.get(code);
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "workerUpdatePwd.action")
	public String employeeInfoJsp() {
		
		
		return "jsp/systemMgJsp/updatepwd";
	}
	
	
	/*
	 * 
	 * 修改密码
	 * 
	 * @data：2018.6.28
	 * 
	 * @autuor 毛聪
	 */
	@RequestMapping(value ="updatePwdWorker.action")
	public void updatePwd(HttpSession session, HttpServletResponse response,String oldPwd,String newPwd1,String newPwd2) throws IOException {
		String pwd=session.getAttribute("WorkerPwd").toString();
		System.out.println(oldPwd+newPwd1+newPwd2+pwd);
		Worker worker=new Worker();
		printWriter = response.getWriter();	
		if(oldPwd.equals(pwd) ){
			worker.setName(session.getAttribute("WorkerName").toString());
			worker.setPassword(newPwd1);
			impLoginBiz.updatePwdWorker(worker);
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
