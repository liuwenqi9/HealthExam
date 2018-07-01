/**
 * testdemo
 */

$(function () {
	//加载搜索
	$.ajax({
		url: "findGuideItemByDept.action",
		method: "POST",
		data: {page:1,
			 dept:2//暂时写死
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
	 
	 
	 
	 
});
//定义vue
var req= new Vue({
	  el: '#datapart',
	  data: {		
		 itemsList:[],//体检项目集合
		 pageCount:[],
		 pageNum:"",
		 dept:{}, //需加入科室选择
		 itemId:"",
		 guideItemid:"",
	    descriptionText:"根据体检结果 ：\n\n" +
	    				"建议：  \n\n"+
	    				"注意事项：",
		docName:""
	  },
	  methods:{
		  showModal1:function(itemsid,guideitemid){//显示模态框2
			  console.log("点击了显示模态框2");
			  $("#summary-modal1").modal('show');
			  req.itemId=itemsid;
			  req.guideItemid=guideitemid;
			  
		  },
		/*  //体检小结
			summaryUp1:function(){//点击提交体检小结
				  console.log("----执行了提交文字体检小结");
				   var  reg = /^.{1,300}$/;//非空验证
				  if(!reg.test(req.descriptionText)){
					  alert("请描述在1~300字符");
				  } 
				  //ajax
					$.ajax({
			    		url: "updateSummary.action",  
			    		 type: 'post',  
			    		 data:{ 
			    			 'itemId': req.itemId,
			    			 'guideItemid': req.guideItemid,
			    			 'descriptionText': req.descriptionText,
			    			 'doctorName':req.docName
			    			 },
			    		 
			    		 success: function(result){
			    			  console.log("-----体检小结接收"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----体检小结提交成功");
			                	  alert("提交成功");
			                	  $("#summary-modal1").modal('hide');
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("提交失败");
			                	  $("#summary-modal1").modal('hide');
			                	  console.log("-----体检小结提交失败");
			                  }

			                } 	
			    		
			    	}); 
				  
				  
				  
			  },*/
		  
		  
	  }
	});
