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
	var itemid;//接收体检项目ID
	var req= new Vue({
		  el: '#showview_div',
		  data: {
			  promptmessage:"", //提示信息
			 person: {
			
				 
			 },//体检者对象
			 itemsList:[]//体检项目集合
		  },
		  methods:{
			  showModal:function(name,itemsid){
				  $("#accept-modal").modal('show');
				  $("#item_h4").html(name);
				  itemid=itemsid;
			  },
			  hideModal:function(){
				  console.log("----执行了接收项目");
			
				if(itemid!=null){
					console.log("itemid:"+itemid);
				  //ajax
					$.ajax({
			    		url: "updateGuideItemTime.action",  
			    		 type: 'post',  
			    		 data:{'items_id': itemid},
			    		 
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

			                } 	
			    		
			    	}); 
			      }
				  
				  
			  }
			
		  }
		});
	
	
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
		   var  reg = /^[^ ]+$/;//非空验证
			return this.optional(element)||(reg.test(value));  
		},"*请输入正确的卡号"); 
	 //点击接收按钮
	
	 
	 

});