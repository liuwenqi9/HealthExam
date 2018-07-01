/**
 * @author JSY
 * @date 6 月23日
 * 
 */
$(function () {
	
	 
	

	//分界
	$("#message_div").hide();
	$("#person_div").hide();
	$("#hr_div").hide();
	$("#show_items_div").hide();
	//定义vue
	var itemId;//接收体检项目id
	var guideItemid;//导检表id
	var req= new Vue({
		  el: '#showview_div',
		  data: {
			  promptmessage:"", //提示信息
			 person: {
			
				 
			 },//体检者对象
			 itemsList:[],//体检项目集合
			 detailList:[]//体检细项项目集合
		  },
		  methods:{
			  showModal:function(name,itemsid,guideitemid){//显示模态框1
				  $("#accept-modal").modal('show');
				  $("#item_h4").html(name);
				  itemId=itemsid;
				  guideItemid=guideitemid;
				  console.log("--项目名称："+name);
				  console.log("--体检项目id:"+itemsid);
				  console.log("--导检表id："+guideItemid);
			  },
			  showModal2:function(itemsid,guideitemid){//显示模态框2
				  console.log("点击了显示模态框2");
				  $("#summary-modal1").modal('show');
				  itemId=itemsid;
				  guideItemid=guideitemid;
				  
			  },
			  showModal3:function(){//显示模态框3
				  console.log("点击了显示模态框3");
				  $("#summary-modal2").modal('show');
				
				  
			  },
			  showModal4:function(itemsid){//显示模态框3
				  console.log("点击了显示模态框4");
				  $("#summary-modal3").modal('show');
				  if(itemsid!=null){
				  //发送AJAX到后台管理
					$.ajax({
			    		url: "",  
			    		 type: 'post',  
			    		 data:{'itemId': itemsid			    			
			    			 },			    		 
			    		 success: function(result){
			    			 if(result.failure!=null){//无细项对象	0629
				    			
				    				req.detailList = result.detailList;  
				    			}

			                },
			    			 error:function(){
									alert("获取失败，请确认是否联网");
									console.log("接受项目获取失败");									
								}		
			    });
			  }
				  
				  
				  
			  },
			  
			  //体检小结
			/*  summaryUp1:function(){//点击提交体检小结
				  console.log("----执行了提交体检小结");
				  var descriptiontext=$("#description_text").val();
				  var doctor_name=$("#doctorname").val();
				  console.log("接收的体检小结："+descriptiontext);
				  console.log("接收的医生姓名："+doctor_name);
				  //ajax
					$.ajax({
			    		url: "updateSummary.action",  
			    		 type: 'post',  
			    		 data:{ 
			    			 'itemId': itemId,
			    			 'guideItemid':guideItemid,
			    			 'descriptionText': descriptiontext,
			    			 'doctorName':doctor_name
			    			 },
			    		 
			    		 success: function(result){
			    			  console.log("-----接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----接收成功");
			                	  alert("接收成功");
			                	  $("#summary-modal1").modal('hide');
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("接收失败");
			                	  $("#summary-modal1").modal('hide');
			                	  console.log("-----接收失败");
			                  }

			                } 	
			    		
			    	}); 
				  
				  
				  
			  },*/
			  
			  hideModal:function(){//隐藏模态框
				  console.log("----执行了接收项目");
				 
				if(itemId!=null&&guideItemid!=null){
					console.log("itemid:"+itemId);
				  //ajax
					$.ajax({
			    		url: "updateGuideItemTime.action",  
			    		 type: 'post',  
			    		 data:{'itemId': itemId,
			    			 'guideItemid':guideItemid
			    			 },
			    		 
			    		 success: function(result){
			    			  console.log("-----接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----接收成功");
			                	  alert("接收成功");
			                	  $("#accept-modal").modal('hide');
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("接收失败");
			                	  $("#accept-modal").modal('hide');
			                	  console.log("-----接收失败");
			                  }

			                },
			    			 error:function(){
									alert("获取失败，请确认是否联网");
									console.log("接受项目获取失败");
									
								}
			    		
			    	}); 
			      }
				  
				  
			  }
			
			
		  }
		});
	
	//搜索卡号
	$("#search_form").validate({
		
		 rules: {//规则
			 guide_id:{//导检卡号
				 required:true,
				 guide_id:true
			 }
			
		 },
		  messages: {//提示内容
			  guide_id:{
				  required:"请输入导检卡号！"
			  }
			  	  
		  },
		   submitHandler:function(form){//符合规则提交
			   //序列化
			  
			   var formdata=$(form).serialize();
		    	  $.param(formdata);  
		    	
		    	  console.log("运行到提交查找卡号了");
		    		$.ajax({
			    		url: "searchDetails.action",  
			    		 type: 'post',  
			    		 data:formdata,	    					    			    	
			    		 success: function(result){
			    			 
			    			 if(result!=null){
			    				 console.log("-----接收到返回的数据");
			    			if(result.failure!=null){//无导检表对象	
			    				$("#person_div").hide();
			    				$("#message_div").show();
			    				$("#hr_div").show();
			    				req.promptmessage = result.failure;  
			    			}	 
			    				 
			    			if(result.notPerson!=null){//无体检者对象
			    				$("#person_div").hide();
			    				$("#message_div").show();
			    				$("#hr_div").show();
			    				req.promptmessage = result.notPerson;  
			    			}	 
			    			if(result.person!=null){//找到体检者对象
			    				$("#message_div").hide();
			    				$("#person_div").show();
			    				$("#hr_div").show();
			    				req.person = result.person;  
			    			}	
			    			if(result.itemsList!=null){//找到体检项目表集合
			    				$("#show_items_div").show();			    				
		    				req.itemsList = result.itemsList;  
			    			}	
			 
			    			 }
			    			 
			    			
			                },
			                error:function(){
								alert("获取失败，请确认是否联网");
								console.log("获取失败");
								
							}
			    		
			    	});
		    	  
		    	  
		    	  
			   
			   
		   },
		   errorPlacement: function(error, element) {//错误提示位置  
	            /* error.appendTo(element.parent());  */
	             error.insertAfter(element.parent());
	     } 
		
		
	});
	 //自定义 验证
	 $.validator.addMethod("guide_id",function(value,element,params){  
		   var  reg = /^\+?[1-9][0-9]*$/;//非空验证
			return this.optional(element)||(reg.test(value));  
		},"*请输入正确的卡号(正整数)"); 
	
	 
	 //6月29
	 //普通体检小结表单验证
	 $("#summary_form1").validate({
		 rules: {//规则
			 description_text:{//体检小结
				 textLength:false
			 }, 
			 doctorname:{//医生名称
				 required:true,
		
		  }
	 	
	 
		 },
		  messages: {//提示内容
			  doctorname:{
				  required:"请签名！"
			  }
			
			  
		  },
		  submitHandler:function(form){ //符合规则提交
			 //将表单序列化，提交
			
			  console.log("运行到普通文字小结提交");
		    	  var descriptiontext=$("#description_text").val();
				  var doctor_name=$("#doctorname").val();
				  console.log("接收的体检小结："+descriptiontext);
				  console.log("接收的医生姓名："+doctor_name);		    			    	  
		    	  $.ajax({
			    		url: "updateSummary.action",  
			    		 type: 'post',  
			    		 data: { 
			    			 'itemId': itemId,
			    			 'guideItemid':guideItemid,
			    			 'descriptionText': descriptiontext,
			    			 'doctorName':doctor_name
			    			 },
			    		 success: function(result){
			    			  console.log("-----普通小结接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----普通小结接收成功");
			                	  alert("提交成功");
			                	  $("#summary-modal1").modal('hide');
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("提交失败");
			                	  $("#summary-modal1").modal('hide');
			                	  console.log("-----普通小结接收失败");
			                  }

			                } 	
			    		
			    	}); 
		    	  
		    	  
			  
			  
			  
			    
		  },
		  errorPlacement: function(error, element) {//错误提示位置  
	             error.appendTo(element.parent());  
	            /* error.insertAfter(element.parent());*/
	     }
		 
	
	
});
	 //自定义 体检小结长度：1~300字符
	 $.validator.addMethod("textLength",function(value,element,params){  
		   var  reg = /^.{1,300}$/;//非空验证
			return this.optional(element)||(reg.test(value));  
		},"*体检小结1~300字");
	 
	 
	 //图片体检小结表单验证
	 $("#summary-modal2").validate({
		 rules: {//规则
			 description_text2:{//体检小结
				 textLength:false
			 }, 
			 doctorname2:{//医生名称
				 required:true,		
		  }
		 },
		  messages: {//提示内容
			  doctorname2:{
				  required:"请签名！"
			  }
			
			  
		  },
		  submitHandler:function(form){ //符合规则提交
			 //将表单序列化，提交
			
			  console.log("运行到普通文字小结提交");
		    	  var descriptiontext=$("#description_text2").val();
				  var doctor_name=$("#doctorname2").val();
				  console.log("接收的体检小结："+descriptiontext);
				  console.log("接收的医生姓名："+doctor_name);		    			    	  
		    	  $.ajax({
			    		url: "updateSummary.action",  
			    		 type: 'post',  
			    		 data: { 
			    			 'itemId': itemId,
			    			 'guideItemid':guideItemid,
			    			 'descriptionText': descriptiontext,
			    			 'doctorName':doctor_name
			    			 },
			    		 success: function(result){
			    			  console.log("-----普通小结接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----普通小结接收成功");
			                	  alert("提交成功");
			                	  $("#summary-modal2").modal('hide');
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("提交失败");
			                	  $("#summary-modal2").modal('hide');
			                	  console.log("-----普通小结接收失败");
			                  }

			                } 	
			    		
			    	}); 
		    	  
		    	  
			  
			  
			  
			    
		  },
		  errorPlacement: function(error, element) {//错误提示位置  
	             error.appendTo(element.parent());  
	            /* error.insertAfter(element.parent());*/
	     }
		 
	
	
});
	 
	 //细项体检小结表单验证
	 $("#summary-modal3").validate({
		 
		 
		 
		 
		 
		 
	 });
	 
	 
	 
	 
	 

});