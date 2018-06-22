package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.ImplParameterBiz;
import com.health.biz.ParameterMgBiz;
import com.health.entity.Parameter;

@Controller
public class ParameterController {

	@Resource
	ParameterMgBiz implParameterBiz;
	
	
	/*
	 * 主界面点击系统设置->参数管理  默认查询参数  
	 * @author 毛聪
	 * @date 6月19日
	 */
	PrintWriter printWriter;

	@RequestMapping("paramMg.action")
	public ModelAndView getParameterMg() {
		System.out.println("走到了个体----------------");

		List<Parameter> paList = implParameterBiz.queryParameter();
		System.out.println(paList);
		ModelAndView mav = new ModelAndView("jsp/systemMgJsp/parameterMg");
		mav.addObject("paList", paList);

		return mav;
	}

	/*
	 * 功能:参数管理的添加参数
	 * @author毛聪
	 * @date 6月20日
	 */
	@RequestMapping("insertparamMg.action")
	public void insertParameter(HttpServletResponse response, Parameter parameter) throws IOException {
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		int lengthid = implParameterBiz.lengthId();
		parameter.setParameterid(lengthid + 1);

		System.out.println("添加参数:" + parameter.getParamname() + parameter.getParameterid());
		int resultIn=0;
		try {
			 resultIn = implParameterBiz.insertParameter(parameter);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			printWriter = response.getWriter();
			if (resultIn > 0) {
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
				System.out.println("添加成功");
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("已存在");
			}
		}

	}

	/*
	 * 功能:参数管理的删除参数
	 * @author毛聪
	 * @date 6月20日
	 */
	@RequestMapping("deleteparamMg.action")
	public void deleteParameter(HttpServletResponse response, String paramname) throws IOException {
		System.out.println("删除paramname" + paramname);
		int delResult = 0;
		try {
			delResult = implParameterBiz.deleteParameter(paramname);
			
			System.out.println("走到了try"+delResult);
		} catch (Exception e) {
			System.out.println("走到了catch"+e.getMessage());
			System.out.println(delResult);
		} finally {

			printWriter = response.getWriter();
			if (delResult > 0) {
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
				System.out.println("删除成功");
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("删除失败");
			}
		}
	}
	
	/*
	 * 功能:参数管理的修改参数
	 * @author毛聪
	 * @date 6月21日
	 */
	@RequestMapping("updataparamMg.action")
	public void updataParameter(HttpServletResponse response,Parameter parameter) throws IOException {
		response.setContentType("text/text");
		response.setCharacterEncoding("UTF-8");
		System.out.println(parameter.getParamname()+""+parameter.getParameterid());
		int resultUp=0;
		try {
			 resultUp= implParameterBiz.updataParameter(parameter);
			
		} catch (Exception e) {
			System.out.println("修改:catch模块"+e.getMessage());
		}finally {

			printWriter = response.getWriter();
			if (resultUp > 0) {
				printWriter.print("OK");
				printWriter.flush();
				printWriter.close();
				System.out.println("修改成功");
			} else {
				printWriter.print("FAIL");
				printWriter.flush();
				printWriter.close();
				System.out.println("已存在");
			}
		}
		
	}
}
