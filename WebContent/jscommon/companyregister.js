/**
 * 企业注册js
 * @date:6月15日
 * @author JSY
 */

$(function () {
	
	/*$("#companyaccept").prop("checked")==false;*/
	//背景切换
	 $('#btn-login-dark').on('click', function(e) {
			$('body').attr('class', 'login-layout');
			$('#id-text2').attr('class', 'white');
			$('#id-company-text').attr('class', 'blue');
			
			e.preventDefault();
		 });
		 $('#btn-login-light').on('click', function(e) {
			$('body').attr('class', 'login-layout light-login');
			$('#id-text2').attr('class', 'grey');
			$('#id-company-text').attr('class', 'blue');
			
			e.preventDefault();
		 });
		 $('#btn-login-blur').on('click', function(e) {
			$('body').attr('class', 'login-layout blur-login');
			$('#id-text2').attr('class', 'white');
			$('#id-company-text').attr('class', 'light-blue');
			
			e.preventDefault();
		 });
		 
		 //表单验证
		 $("#register_form").validate({
			 onkeyup :false,// 是否在敲击键盘时验证 
		     focusInvalid: false, 
			    rules: {
			    	name:{//公司全称
			    		required:true,   
			    		cname:true,
	                	remote:{  
		                    type:"POST",  
		                    url:"../register/checkName.action" //请求地址  
		                  /*  data:{  
		                    	name:function(){
		                    		return $("#company_name").val(); 
		                    		}
		                    }*/ 		 						 			
	               		} 
			    	},
			    	account:{//公司账号
			    		required:true,
			    		caccount:true,
	                	remote:{  
		                    type:"POST",  
		                    url:"../register/checkAccount.action" //请求地址  
		                   /* data:{  
		                    	companyAccount:function(){ return $("#company_account").val(); }  
		                    } */ 
	               		} 
			    	},
			    	
			    	password:{//密码
			    		required:true,
			    		pwd:true
			    	},
			    	company_repwd: {//确认密码
			    		required: true ,
			    		equalTo:"#company_pwd" 
			    	},
			    	
			    	locationname: "required",//地址
			    	 agree: "required"//同意
			 
			    		 
			    		 
			    		 
			    },
			    //提示信息
			    messages: {
			    	name: {
			    		required: "请输入公司全称",			    		
		                remote:"该公司已注册,请直接登录"
			    	},
			    	account: {
			    		required: "请输入公司账号",
		                remote:"该账号已存在,请修改"  
			    	},
			    
			    	password: {
			    		required: "请输入密码" ,
			    		
			    	},
			    	company_repwd: {
			    		required: "请输入确认密码" ,
			    		equalTo:"两次密码不一致" 
			    	},
			    	agree: "请同意注册条款",//同意
			    	locationname: "请选择地址"
				
			    },
			    submitHandler:function(form){
			    	//密码加密
			    /*	var encryption= hex_md5($("#company_pwd").val());*/
			    /*	console.log("--加密后的注册密码："+encryption);*/
			    	/*var formdata=new FormData();*/
			    		
			    	var formdata=$("#register_form").serialize();
			    	  $.param(formdata);  
			    	
			        console.log("表单序列化=============="+formdata);  
			    	
			    console.log("运行到提交注册了");
			    	$.ajax({
			    		url: "../register/addAccount.action",  
			    		 type: 'post',  
			    		 data:formdata,	    					    			    	
			    		 success: function(result){
			    			  console.log("-----注册结果"+result);
			                  if(result=="success"){//注册成功
			                	  console.log("-----注册成功");
			                	  alert("注册成功");
			                	  //跳转至登录界面
			                  }else{//注册失败
			                	  alert("注册失败");
			                	  console.log("-----注册失败");
			                  }

			                },  	
			    		
			    	}); 		
			    	
			    		  },
			    
			    
			    
			     errorPlacement: function(error, element) {  
			             error.appendTo(element.parent());  
			          
			     } 
			});
		 //自定义 验证
		 $.validator.addMethod("cname",function(value,element,params){  
			   var  reg = /^[^ ]+$/;//非空验证
				return this.optional(element)||(reg.test(value));  
			},"*请输入正确的公司全称"); 
		 
		 
		 
		 
			$.validator.addMethod("caccount",function(value,element,params){  
				 var reg2 = /^[0-9a-zA-Z]{4,9}$/;//字母/数字/字母+数字
				return this.optional(element)||(reg2.test(value));  
			},"*公司账号为4~9位字母/数字/字母+数字"); 
			
			$.validator.addMethod("pwd",function(value,element,params){  
				 var reg3 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$/;//5~10位字母+数字混合
				return this.optional(element)||(reg3.test(value));  
			},"*密码为5~10位字母+数字混合"); 
			  
	
		 

	//点击注册条款
	$("#readterms_a").click(function () {
		console.log("--点击了注册条款--");
		$("#read-modal").modal('show');

	});
	//点击接收条款，关闭模态框，接受复选框勾选
	$("#accept_btn").click(function () {
		console.log("--点击了同意注册条款--");
		$("#read-modal").modal('hide');
		
	});
		

});