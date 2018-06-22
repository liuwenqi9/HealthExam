package com.health.clientController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author JSY
 * @date 6月19日
 */
@Controller
public class DownloadAndUploadController {

	
	/**
	 * @date 6月19日
	 * @return
	 */
	@RequestMapping("openExam.action")
	public ModelAndView showDownloadView() {
		System.out.println("跳转下载界面");
	ModelAndView mav=new ModelAndView("jsp/clientJsp/download_template");	
		return mav;
	}
	
	/**
	 * @date 6月20日
	 * @return
	 */
	@RequestMapping("uploadNameList.action")
	public ModelAndView showUploadView() {
		System.out.println("跳转上传名单界面");
	ModelAndView mav=new ModelAndView("jsp/clientJsp/upload_data");	
		return mav;
	}
	
}
