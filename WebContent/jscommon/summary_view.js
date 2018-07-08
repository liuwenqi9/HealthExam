/**
 * testdemo
 */

$(function () {
	//加载搜索
/*	console.log("session里面的部门id:"+req.sessionDeptid);*/
	var dep=$("#workdeptid_h2").html();
	console.log("session里面的部门id:"+dep);
	$.ajax({
		url: "findGuideItemByDept.action",
		method: "POST",
		data: {page:1,
			 dept:dep//0703
			},
		success: function(msg){
			
			console.log("--加载信息返回了0701");
			console.log(msg.pageNum);
			req.itemsList = msg.itemsList;
			req.pageCount = msg.pageCount;
			req.pageNum = msg.pageNum;
			
		},
		error: function(){
			alert("获取失败");
		}
	});
	//普通文字表单验证
	 //普通体检小结表单验证
	 $("#summary_form1").validate({
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
				  required:"请做小结"
			  },
			  
			  doctorname:{
				  required:"请签名！"
			  }
			
			  
		  },
		  submitHandler:function(form){ //符合规则提交
			 //将表单序列化，提交
			
			  console.log("--运行到普通文字小结提交");
		    	      			    	  
		    	  $.ajax({
			    		url: "updateSummary.action",  
			    		 type: 'post',  
			    		 data: { 
			    			 'itemId': req.itemId,
			    			 'guideItemid': req.guideItemid,
			    			 'descriptionText': req.descriptionText,
			    			 'doctorName':req.docName
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

			                },
			    			 error:function(){
									alert("获取失败，请确认是否联网");
									console.log("获取失败");
									
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
//----界线 
	 //细项体检小结表单验证
	 $("#summary_form3").validate({
		 rules: {//规则
			 description_text3:{//细项体检小结
				 required:true,
				 textLength:false
			 }, 
			 doctorname3:{//细项医生名称
				 required:true,
		
		  }
	 	
	 
		 },
		 messages: {//提示内容
			 description_text3:{
				  required:"请做小结"
			  },
			  
			  doctorname3:{
				  required:"请签名！"
			  }
			
			  
		  },
		  submitHandler:function(form){ //符合规则提交
				 //将表单序列化，提交
				
				  console.log("--运行到细项小结提交");
			    	      			    	  
			    	  $.ajax({
				    		url: "updateSummary.action",  
				    		 type: 'post',  
				    		 data: { 
				    			 'itemId': req.itemId,
				    			 'guideItemid': req.guideItemid,
				    			 'descriptionText': req.descriptionText3,
				    			 'doctorName':req.docName3
				    			 },
				    		 success: function(result){
				    			  console.log("-----细项小结接收反馈结果"+result);
				                  if(result=="success"){//注册成功
				                	  console.log("-----细项小结接收成功");
				                	  alert("提交成功");
				                	  $("#summary-modal3").modal('hide');
				                	
				                	  
				                	  
				                	  
				                  }else{//注册失败
				                	  alert("提交失败");
				                	  $("#summary-modal3").modal('hide');
				                	  console.log("-----细项小结接收失败");
				                  }
				                 //刷新界面 	
				                  window.location.reload();
				                  				          
				                },
				                error:function(){
									alert("获取失败，请确认是否联网");
									console.log("获取失败");
									
								}	 
				    	}); 
			    	  			    	    
			  },
			  errorPlacement: function(error, element) {//错误提示位置  
		             error.appendTo(element.parent());  
		            /* error.insertAfter(element.parent());*/
		     }
		 
		 
		
		 
		 
	 });
//图片小结模态框
	 $("#summary_form2").validate({
		 rules: {//规则
			 description_text2:{//细项体检小结
				 required:true,
				 textLength:false
			 }, 
			 doctorname2:{//细项医生名称
				 required:true,
		
		  }
	 	
	 
		 },
		 messages: {//提示内容
			 description_text2:{
				  required:"请做小结"
			  },
			  
			  doctorname2:{
				  required:"请签名！"
			  }
			
			  
		  },
		  submitHandler:function(form){ //符合规则提交
				 //将表单序列化，提交
				
				  console.log("--运行到图片小结提交");
			    	      			    	  
			    	  $.ajax({
				    		url: "",  
				    		 type: 'post',  
				    		 data: { 
				    			 'itemId': req.itemId,
				    			 'guideItemid': req.guideItemid,
				    			 'descriptionText': req.descriptionText2,
				    			 'doctorName':req.docName2
				    			 },
				    		 success: function(result){
				    			  console.log("-----细项小结接收反馈结果"+result);
				                  if(result=="success"){//注册成功
				                	  console.log("-----细项小结接收成功");
				                	  alert("提交成功");
				                	  $("#summary-modal2").modal('hide');
				                	
				                	  
				                	  
				                	  
				                  }else{//注册失败
				                	  alert("提交失败");
				                	  $("#summary-modal2").modal('hide');
				                	  console.log("-----细项小结接收失败");
				                  }
				                 //刷新界面 	
				                  window.location.reload();
				                  				          
				                },
				                error:function(){
									alert("获取失败，请确认是否联网");
									console.log("获取失败");
									
								}	 
				    	}); 
			    	  			    	    
			  },
			  errorPlacement: function(error, element) {//错误提示位置  
		             error.appendTo(element.parent());  
		            /* error.insertAfter(element.parent());*/
		     }
			  
			  
		 
	 });
	 
	 
	 
	 
});
//定义vue
var req= new Vue({
	  el: '#datapart',
	  data: {		
		 itemsList:[],//体检项目集合
		 ret:[],
		 pageCount:[],
		 pageNum:"",
		 dept:{}, //需加入科室选择
		 itemId:"",
		 guideItemid:"",
	    descriptionText:"根据体检结果 ：\n\n" +
	    				"建议：  \n\n"+
	    				"注意事项：",
	    descriptionText2:"根据体检结果 ：\n\n" +
		    			"建议：  \n\n"+
		    			"注意事项：",				
	    descriptionText3:"根据体检结果 ：\n\n" +
			    		"建议：  \n\n"+
			    		"注意事项：",				
		    			
		docName:"",
		docName2:"",
		docName3:"",
		/*sessionDeptid:4*/
		sessionDeptid:""
	  },
	  
	  methods:{
		  showModal1:function(itemsid,guideitemid){//文字模态框
			  console.log("---普通文字小结模态框");
			  $("#summary-modal1").modal('show');
			  req.itemId=itemsid;
			  req.guideItemid=guideitemid;
			  
		  },
		  showModal2:function(itemsid,guideitemid){//图片模态框
			  console.log("---图片小结模态框");
			  $("#summary-modal2").modal('show');
			  req.itemId=itemsid;
			  req.guideItemid=guideitemid;
			  
		  },
		  showModal3:function(itemsid,guideitemid){//细项模态框
			  console.log("---图片小结模态框");
			  $("#summary-modal3").modal('show');
			  req.itemId=itemsid;
			  req.guideItemid=guideitemid;
			  //通过Ajax发送到服务器
			  $.ajax({
		    		url: "findDetaildataViewbyid.action",  
		    		 type: 'post',  
		    		 data: { 
		    			 'page':1,
		    			 'itemid': req.itemId,
		    			 'guideitemid': req.guideItemid
		    			 },
		    		 success: function(result){
		    			 console.log("--细项数据接收返回");
		    				 req.ret=result.detailList;
		    			
		                },
		                error:function(){
							alert("获取失败，请确认是否联网");
							console.log("获取失败");
							
						}
		    		
		    	});
			  	  
		  }
		    
	  }
	});
