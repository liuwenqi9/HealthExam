/**
 * 企业注册js
 * @date:6月15日
 * @author JSY
 */

$(function () {
	
	$("#companyaccept").prop("checked")==false;
			//公司名称失去焦点
		 $("#company_name").blur(function () {
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
				});
		 
				//账号失去焦点
		 $("#company_account").blur(function () {
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
					});
		 //密码框失去焦点,验证是否符合正则
		 $("#company_pwd").blur(function () {
			 var company_pwd=$(this).val();
			 var regpwd=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$/;//5~10位字母+数字混合
			 if(!regpwd.test(company_pwd)){
					console.log("--公司注册密码为空---");
					$("#span_pwd").css("color","#FF5722");	
					$("#span_pwd").html("密码不符合规范（5~10位字母+数字混合）");
				}
			 
		});
		 //确认密码失去焦点，验证是否与密码相同
		 $("#company_repwd").blur(function () {
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
			 
		});
		 
		 
	/*
	 * 点击注册时，判断是否已勾上接受合同，再判断各个是否符合规则
	 * 然后再进行注册
	 */
	//公司唯一性方法			 
	function checkname(company_name) {
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
	};
	//公司账号唯一性方法					 
function checkAccount(company_account) {
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
};	
//注册账号
function addAccount(name,account,pwd,address) {
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
};




	//点击注册条款
	$("#readterms_a").click(function () {
		console.log("--点击了注册条款--");
		$("#read_modal").modal('show');

	});
	//点击接收条款，关闭模态框，接受复选框勾选
	$("#accept_btn").click(function () {
		$("#read-modal").modal('hide');
		$("#companyaccept").prop("checked")==true;
		
	});
		
	
				 
				 
$("#register_btn").click(function () {
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

	
	
	
	
});
	
	
	
	
	
	
});