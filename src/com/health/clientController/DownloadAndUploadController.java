package com.health.clientController;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.PersoninfoBiz;
import com.health.entity.Personinfo;
import com.health.util.ReadExcelUtil;

/**
 * 
 * @author JSY
 * @date 6月19日
 */
@Controller

public class DownloadAndUploadController {
	@Resource
	private PersoninfoBiz impPersoninfo;//体检人员
	
	private  String sendMesg =null;//接收返回信息
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
		public ModelAndView  fileact(HttpServletRequest req,HttpServletResponse res, @RequestParam("files") MultipartFile files) {
			System.out.println("执行到文件上传");
			if(files!=null) {
		String filePath = req.getSession().getServletContext().getRealPath("/"); 
		System.out.println("测试路径"+filePath);
			String filename = files.getOriginalFilename();
			System.out.println("获取到的文件名:" + filename);
			String newFilePath=filePath + filename;
			try {
				files.transferTo(new File(newFilePath));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println("读取的路径"+newFilePath);
			//读取数据，发往界面
		List<Personinfo> personinfoList=ReadExcelUtil.getPersoninfoList(newFilePath);
			if(personinfoList!=null) {//不为空,发往界面
				for(Personinfo personinfo:personinfoList) {			
//					System.out.print(personinfo.getAccount()+"#");
//					System.out.print(personinfo.getName()+"#");
//					System.out.print(personinfo.getIdentity()+"#");
//					System.out.print(personinfo.getSex()+"#");
//					System.out.print(personinfo.getAge()+"#");
//					System.out.print(personinfo.getTelephone()+"##");
//					System.out.println();
				int result=	impPersoninfo.addPersoninfo(personinfo);
				if(result>0) {
					sendMesg="success";//添加人员成功
				}else {
					sendMesg="failure";//添加人员失败0703
				}
				}
				
			}
			
			}
			
			ModelAndView mav=new ModelAndView("forward:uploadNameList.action");	
			return mav;				
		}
				
		/**
		   * 通过PrintWriter将响应数据写入response
		   * @date 7月3日
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
		
		
		
		//get/set
		public PersoninfoBiz getImpPersoninfo() {
			return impPersoninfo;
		}

		public void setImpPersoninfo(PersoninfoBiz impPersoninfo) {
			this.impPersoninfo = impPersoninfo;
		}

		public String getSendMesg() {
			return sendMesg;
		}

		public void setSendMesg(String sendMesg) {
			this.sendMesg = sendMesg;
		}
		
	
		
		
	
}
