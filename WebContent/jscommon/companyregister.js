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
		                    url:"../register/checkName.action", //请求地址  
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
		                    url:"../register/checkAccount.action", //请求地址  
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
			    	
			    	locationid: "required",//地址
			    	 agree: "required",//同意
			 
			    		 
			    		 
			    		 
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
			    	locationid: "请选择地址"
				
			    },
			    submitHandler:function(form){
			    	//密码加密
			    /*	var encryption= hex_md5($("#company_pwd").val());*/
			    /*	console.log("--加密后的注册密码："+encryption);*/
			    	
			    console.log("运行到提交注册了");
			    	$.ajax({
			    		url: "../register/addAccount.action",  
			    		 type: 'post',  
			    		 	    					    
			    		 success: function(result){  
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
			},"*请输入正确的公司账号"); 
			
			$.validator.addMethod("pwd",function(value,element,params){  
				 var reg3 = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$/;//5~10位字母+数字混合
				return this.optional(element)||(reg3.test(value));  
			},"*请输入正确的密码"); 
			  
	
		 
		 
		 
	
			//公司名称失去焦点
		/* $("#company_name").blur(function () {
			 var textFormat = /^[^ ]+$/;//不能带空格符
				var company_name=$(this).val();
				if(!textFormat.test(company_name)){
					$("#span_name").css("color","#FF5722");	
					$("#span_name").html("公司名称不符合规范（或带空格）");
					console.log("----注册公司全称输入为空----");
				}
				else{
					console.log("----注册公司全称----"+company_name);
					checkname(company_name);//调用方法
					
				}			
				});*/
		 
				//账号失去焦点
		/* $("#company_account").blur(function () {
			 var textFormat = /^[0-9a-zA-Z]{4,9}$/;//不能带空格符
					var company_account=$(this).val();
					if(!textFormat.test(company_account)){
						console.log("----注册公司账号输入为空----");
						console.log("--公司注册账号为空---");
						$("#span_account").css("color","#FF5722");	
						$("#span_account").html("公司名称不符合规范（字母/数字/字母+数字）");
					}else{
						console.log("----注册公司账号----"+company_account);
						checkAccount(company_account);
					}
					});*/
		 //密码框失去焦点,验证是否符合正则
		/* $("#company_pwd").blur(function () {
			 var company_pwd=$(this).val();
			 var regpwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$/;//5~10位字母+数字混合
			 if(!regpwd.test(company_pwd)){
					console.log("--公司注册密码为空---");
					$("#span_pwd").css("color","#FF5722");	
					$("#span_pwd").html("密码不符合规范（5~10位字母+数字混合）");
				}
			 
		});*/
		 //确认密码失去焦点，验证是否与密码相同
	/*	 $("#company_repwd").blur(function () {
			 if( $("#company_pwd").val()!=""){
				 
				 if($("#company_repwd").val()!=""){
					if( $("#company_pwd").val()!=$("#company_repwd").val()){//密码输入不同
						console.log("--公司注册确认密码与初次密码不同---");
						$("#span_repwd").css("color","#FF5722");	
						$("#span_repwd").html("密码不一致");
					}else{
						console.log("--公司注册确认密码与初次密码相同---");
						$("#span_repwd").css("color","#5FB878");	
						$("#span_repwd").html("密码一致");
					}
					 
					 
				 }
				 
			 }
			 
		});*/
		 
		 
	/*
	 * 点击注册时，判断是否已勾上接受合同，再判断各个是否符合规则
	 * 然后再进行注册
	 */
	//公司唯一性方法			 
/*	function checkname(company_name) {
		//走AJAX
		$.ajax({
			url:"../register/checkName.action",
			type:"POST",
			data:{
				"companyName":company_name
			},
			success:function(msg){
				if(msg!=""){
					if(msg=="该公司可以注册!"){
						$("#span_name").css("color","#5FB878");	
					}else{
						$("#span_name").css("color","#FF5722");		
					}
					$("#span_name").html(msg);
					console.log("收到的结果"+msg);
				}else{
					$("#span_name").css("color","#FF5722");	
					
					$("#span_name").html("后台查询出错");
					console.log("收到的结果"+msg);
				}	
			}
		});
	};*/
	//公司账号唯一性方法					 
/*function checkAccount(company_account) {
	//走AJAX
	$.ajax({
		url:"../register/checkAccount.action",
		type:"POST",
		data:{
			"companyAccount":company_account
		},
		success:function(msg){
			if(msg!=""){
				if(msg=="该账号可以注册!"){
					$("#span_account").css("color","#5FB878");	
					
				}else{
					$("#span_account").css("color","#FF5722");		
				}
				$("#span_account").html(msg);
				console.log("收到的结果"+msg);
			}else{
				$("#span_account").css("color","#FF5722");	
				
				$("#span_account").html("后台查询出错");
				console.log("收到的结果"+msg);
			}		
		}
	});
};	*/



//注册账号
/*function addAccount(name,account,pwd,address) {
	//走AJAX
	$.ajax({
		url:"../register/checkAccount.action",
		type:"POST",
		data:{
			"name":name,
			"account":account,
			"password":pwd	
		},
		success:function(msg){
			if(msg!=""){
				alert(msg);
				//注册成功,提示跳转页面
			}		
		}
	});
};*/




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
		
	
				 
				 
/*$("#register_btn").click(function () {
	console.log("---执行点击注册按钮");
	$("#span_name").html("");  //移除提示
	$("#span_account").html("");  
	$("#span_pwd").html("");  
	$("#span_repwd").html(""); 
	$("#span_addre").html("");  
	
	//判断是否接受条款,判断公司名称是否合法，判断
if($("#companyaccept").prop("checked")==true){
	console.log("--用户已接受注册条款---");
	//判断各个输入框是否为空
	 var textFormat = /^[^ ]+$/;//不能带空格符
	 var reg=/^[0-9a-zA-Z]{4,9}$/;//匹配4~9位：字母/数字/字母+数字
	 var regpwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$/;//5~10位字母+数字混合
	if(!textFormat.test($("#company_name").val())){
		console.log("--公司注册名为空---");
		$("#span_name").css("color","#FF5722");	
		$("#span_name").html("公司名不符合规范");
		
	}
	if(!reg.test($("#company_account").val())){
		console.log("--公司注册账号为空---");
		$("#span_account").css("color","#FF5722");	
		$("#span_account").html("账号不符合规范");
		 
	}
	if(!regpwd.test($("#company_pwd").val())){
		console.log("--公司注册密码为空---");
		$("#span_pwd").css("color","#FF5722");	
		$("#span_pwd").html("密码不符合规范");
		
	}
	if($("#company_repwd").val()==""){
		console.log("--公司注册确认密码为空---");
		$("#span_repwd").css("color","#FF5722");	
		$("#span_repwd").html("请输入确认密码");
		 
	}
	if($("#company_address").find("option:selected").text()=="选择企业地址"){
		console.log("--公司地址为空---");
		$("#span_addre").css("color","#FF5722");	
		$("#span_addre").html("请选择企业地址");	
		
	}
	if($("#company_pwd").val()!=""){
		if($("#company_repwd").val()!=$("#company_pwd").val()){
			console.log("--公司注册确认密码与第一次密码不同---");
			$("#span_repwd").css("color","#FF5722");	
			$("#span_repwd").html("密码不一致");
		}
	}
	
	
	
	
	
	
	//ajax验证
	
	
	
	
	
	
	
}else{
	alert("请阅读并接收条款");
	console.log("--用户未接受注册条款---");
	
}

	
	
	
	
});*/
	
	
	
	
	
	
});