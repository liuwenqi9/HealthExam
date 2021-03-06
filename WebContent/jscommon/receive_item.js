/**
 * @date 6月30日
 */

	//定义vue
	
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
			deptid:""
				
		  },
		  methods:{
			  showModal:function(name,itemsid,guideitemid,deptid){//普通接收
				  $("#accept-modal").modal('show');
				  $("#item_h4").html(name);
				  req.itemId=itemsid;
				  req.guideItemid=guideitemid;
				  req.deptid=deptid;
				  console.log("--项目名称："+name);
				  console.log("--体检项目id:"+itemsid);
				  console.log("--导检表id："+guideitemid);
				  console.log("接收的科室"+deptid);
			  },
			  showModal2:function(name,itemsid,guideitemid,deptid){//细项接收
				  $("#accept-modal2").modal('show');
				  $("#item_h44").html(name);
				  req.itemId=itemsid;
				  req.guideItemid=guideitemid;
				  req.deptid=deptid;
				  console.log("--项目名称："+name);
				  console.log("--体检项目id:"+itemsid);
				  console.log("--导检表id："+guideitemid);
				  console.log("接收的科室"+deptid);
			  },
			  
			  hideModal:function(){//隐藏模态框,接收普通图片项目
				  console.log("----执行了接收项目0630");
				  var deid= window.sessionStorage.getItem("deptid");
				 console.log("---session获取的部门id:"+deid);
				 console.log("---session获取的部门id类型:"+typeof (deid));
				/* if(deid== req.deptid){//科室相同则可以
					 //操作
				 }else{//不相同则
					 alert("不可以接收其他科室的项目");
				 }*/
				  //ajax
					$.ajax({
			    		url: "updateGuideItemTime.action",  
			    		 type: 'post',  
			    		 data:{
			    			 'itemId':  req.itemId,
			    			 'guideItemid':req.guideItemid
			    			 },
			    		 
			    		 success: function(result){
			    			  console.log("-----接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----接收成功");
			                	  alert("接收成功");
			                	  $("#accept-modal").modal('hide');
			                	  //刷新
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
			     
			  },	
			  hideModal2:function(){//隐藏模态框,接收细项项目
				  console.log("----执行了接收细项项目");
				  var deid= window.sessionStorage.getItem("deptid");
					 console.log("---session获取的部门id:"+deid);
					 console.log("---session获取的部门id类型:"+typeof (deid));
					/* if(deid== req.deptid){//科室相同则可以
						 //操作
					 }else{//不相同则
						 alert("不可以接收其他科室的项目");
					 }*/
				  //ajax
					$.ajax({
			    		url: "updateGuideItemTimeAndRecord.action",  
			    		 type: 'post',  
			    		 data:{
			    			 'itemId':  req.itemId,
			    			 'guideItemid':req.guideItemid
			    			 },
			    		 
			    		 success: function(result){
			    			  console.log("-----接收反馈结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----接收成功");
			                	  alert("接收成功");
			                	  $("#accept-modal2").modal('hide');
			                	  //刷新AJAX
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
			                	  
			                	  
			                	  
			                	  
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("接收失败");
			                	  $("#accept-modal2").modal('hide');
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
			 
		    	  console.log("运行到提交查找卡号了");
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
	
	
});