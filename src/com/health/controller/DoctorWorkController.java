package com.health.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.health.biz.DoctorWorkBiz;
import com.health.entity.Guide;
import com.health.entity.Guideitem;
import com.health.entity.Items;
import com.health.entity.Personinfo;
import com.health.util.MyTimeUtil;


/**
 * 
 * @author JSY
 * @date 6月23日
 */
@Controller
public class DoctorWorkController {
	@Resource
	private DoctorWorkBiz impDoctorWork;

	private  String sendMesg =null;//接收反馈信息
	private Map<String, Object> sendMessage = new HashMap<String, Object>(); //ajax数据回传
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/acceptItem.action")
	public ModelAndView showDoctorReceiveItemsView() {
		System.out.println("跳转医生接收项目界面");
	ModelAndView mav=new ModelAndView("jsp/doctorJsp/receive_items");	
		return mav;
	}
	
	/**
	 * 
	 * @param req
	 * @param res
	 * @param guide_id
	 * @author JSY
	 * 根据导诊卡ID查找病人信息
	 */
	@RequestMapping(value = "/searchDetails.action" , method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public @ResponseBody Map<String, Object> checkName(HttpServletRequest req,HttpServletResponse res,String guide_id) {
		sendMessage.clear();//清空map
		System.out.println("------执行了根据导诊卡查找体检者信息");
	//获取前端界面数据
	System.out.println("查询的导诊卡ID：--"+guide_id);
		if(guide_id!=null) {//不为空时,查询病人信息，及病人的体检信息
			System.out.println("-------执行到这了6月23日");
			//根据导诊卡id查找是否存在
			int id = Integer.parseInt(guide_id);//字符串转integer
			Guide guide=impDoctorWork.findGuideById(id);
			if(guide!=null){//查到，则查用户的信息
					 //表示只有一个对象
				 int  personId=0;
						//获取体检者的id
					 personId=guide.getPersoninfoid();
							System.out.println("----体检者id"+personId);
						//根据体检者 id查找体检者信息
				Personinfo  personinfo =impDoctorWork.findPersoninfoById(personId);
					if(personinfo!=null) {//找到对象
						 sendMessage.put("person", personinfo);	
						 System.out.println("----查询到了体检者对象");
						 
		 List<Guideitem> guideitemList= impDoctorWork.findItemIdByid( guide.getGuideid());
						if(guideitemList!=null) { //获得导检项目关系表集合
							//定义一个对象数组
							List<Items> ItemsList=new ArrayList<Items>();
							for (int i = 0; i < guideitemList.size(); i++) {
							
								
					System.out.println("获得体检项目ID"+guideitemList.get(i).getItemid());	//获得体检项目ID
						Items items=impDoctorWork.findItemByid(guideitemList.get(i).getItemid());
						ItemsList.add(items);
								
							}
							System.out.println("-------发送体检项目集合到js");
							 sendMessage.put("itemsList", ItemsList);
							 
						}
						
						 
					}else {
						 sendMessage.put("notPerson", "找不到该体检者信息");
						 System.out.println("----找不到体检者对象");
					}
							
				}else {
					 sendMessage.put("failure", "找不到卡号为"+guide_id+"的导检表");
				}
		}
		System.out.println("--查找导检表信息返回了");
		return sendMessage;
	}
	
	
	
	/**
	 * 
	 * @param req
	 * @param items_id
	 * @return
	 * @date 6月26日
	 */
	@RequestMapping(value = "/updateGuideItemTime.action" , method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	public @ResponseBody String changeStatus(HttpServletRequest req,String items_id ) {
		System.out.println("-----执行到修改导检项目关系表");
		if(items_id!=null) {//不为空
		
		System.out.println("---填入的时间:"+MyTimeUtil.getTimeNowTogether());	
		//字符串转integer
		Integer id=Integer.valueOf(items_id);
		int reuslt=impDoctorWork.updateExamTimeByid(id, MyTimeUtil.getTimeNowTogether());
			if(reuslt>0) {//更新成功
				sendMesg="success";
			}else {
				sendMesg="failure";
			}
			
		}
		
		
		return sendMesg;
		
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
	
	
	
	//get/set
	  
	  
	  
	  
	public String getSendMesg() {
		return sendMesg;
	}

	public DoctorWorkBiz getImpDoctorWork() {
		return impDoctorWork;
	}

	public void setImpDoctorWork(DoctorWorkBiz impDoctorWork) {
		this.impDoctorWork = impDoctorWork;
	}

	public void setSendMesg(String sendMesg) {
		this.sendMesg = sendMesg;
	}
	
	
	
}
