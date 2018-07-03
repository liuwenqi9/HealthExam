/**
 * 总结js
 */
	var req= new Vue({
		  el: '#showview_div',
		  data: {
			 promptmessage:"", //提示信息
			 person: {  },//体检者对象			
			 itemsList:[],//体检项目集合
			 pageCount:[],
			 pageNum:"",
			 itemId:"",
			guideItemid:"",
			guide_id:"",
			descriptionText:"体检总结：",
			docName:""
		  },
		  methods:{
			

		  }
		});
	
	$(function () {
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
				 
			    	  console.log("--运行到总结-查找卡号了");
			    	  console.log("--id:"+req.guide_id);
			    		$.ajax({
				    		url: "searchDetails.action",  
				    		 type: 'post',  
				    		 data: {page:1,
				    			 guide_id:req.guide_id },	    					    			    	
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
				    				$("#page_footer").show();
			    				req.itemsList = result.itemsList;
			    				/*req.pageCount = result.pageCount;
			    				req.pageNum = result.pageNum;
			    				*/
			    				
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
		//提交总检
		 $("#submit_form").validate({
			 rules: {//规则
				 description_text:{//体检小结
					 required:true,
					 textLength:false
				 }, 
				 doctorname:{//医生名称
					 required:true,
			
			  }
		 	
		 
			 },
			 messages: {//提示内容
				  description_text:{
					  required:"请做总结"
				  },
				  
				  doctorname:{
					  required:"请签名！"
				  }
				
				  
			  },
			  
			  submitHandler:function(form){ //符合规则提交
					 //将表单序列化，提交
					  console.log("--运行到总结提交");
					  //判断集合里是否都已小结
					  var TimeCount=0;
					  
					  for (var i = 0; i < req.itemsList.length; i++) {
							if(req.itemsList[i].examtime!=null||req.itemsList[i].summary!=null){
								console.log("体检小结时间"+ req.itemsList[i].examtime);
								console.log("体检小结"+ req.itemsList[i].summary);
								TimeCount++;
							}
							
							
							
					}
					  console.log("计数"+TimeCount);
					  if(TimeCount!=0){
						  console.log("部分项目未接收或未小结");
						  alert("部分项目未接收或未小结");
					  }else{
						  console.log("已全部小结");  
						  //发送数据
						  $.ajax({
					    		url: "receiveAllSummarize.action",  
					    		 type: 'post',  
					    		 data: { 
					    			   'guideId':req.guide_id,
					    			   	'descriptionText':req.descriptionText,
					    			   	'docName':req.docName
					
					    			 },
					    		 success: function(result){
					    			  console.log("-----体检总结接收反馈结果"+result);
					                  if(result=="success"){//注册成功
					                	  console.log("----总结接收成功");
					                	  alert("提交成功");
					                	   window.location.reload();//刷新当前页面
					                	  //跳转至登录界面
					                  }else{//注册失败
					                	  alert("提交失败");					            
					                	  console.log("-----总结接收失败");
					                	
					                  }

					                },
					    			 error:function(){
											alert("获取失败，请确认是否联网");
											console.log("获取失败");									
										}	
					    	});  
					  }	    	      
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
			},"*体检总结1~300字");	
		 
		 

	});	
	
	
	