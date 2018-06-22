package com.health.clientController;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	@RequestMapping("downloadTemp.action")
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
		/**
		 * date 6月20日
		 * @param fileact
		 * @return
		 */
	
		@RequestMapping(value = "/filehandle.action", method = RequestMethod.POST)
		public ModelAndView fileact(MultipartFile files) {
			System.out.println("执行到文件上传");
			if(files!=null) {
				
			
			String filename = files.getOriginalFilename();
			System.out.println("获取到的文件名:" + filename);
			try {
				files.transferTo(new File("F:/" + filename));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			//读取数据，发往界面
			
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("charge");
			return mav;
			}else {
				return null;
			}
			
		}
		
		
		
	
	
}
