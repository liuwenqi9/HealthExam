<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"
	+request.getServerName()+":"+request.getServerPort()
	+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>健康团检注册窗口</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href=<%=path+"/css/bootstrap.min.css" %> />
		<link rel="stylesheet" href=<%=path+"/font-awesome/4.5.0/css/font-awesome.min.css" %> />

		<!-- text fonts -->
		<link rel="stylesheet" href=<%=path+"/css/fonts.googleapis.com.css" %> />

		<!-- ace styles -->
		<link rel="stylesheet" href=<%=path+"/css/ace.min.css" %> />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href=<%=path+"/css/ace-rtl.min.css" %> />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->

</head>
<body class="login-layout">
<div class="main-container">
			<div class="main-content">
			
				<div class="row">
				
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
						
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">注</span>
									<span class="white" id="id-text2">册</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy; 传一人民医院</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
							<!--注册开始  -->
								<div id="signup-box" class="signup-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												企业账号注册
											</h4>

											<div class="space-6"></div>
											<p> 请填入注册信息: </p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="company_name" class="form-control" placeholder="公司全称" />
															<i class="ace-icon glyphicon glyphicon-home"></i>
														</span>
															<span class="block input-icon input-icon-right">
															&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="company_account" class="form-control" placeholder="公司账号(4~10位：字母+数字)" />
															<i class="ace-icon fa fa-user"></i>
														</span>
														<span class="block input-icon input-icon-right">
															&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="company_pwd" class="form-control" placeholder="密码为5~14位非空字符" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
														<span class="block input-icon input-icon-right">
																&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="company_repwd" class="form-control" placeholder="确认密码" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
														<span class="block input-icon input-icon-right">
																&nbsp;
															</span>
													</label>
													<!--地址选择  -->
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<select class="form-control" id="company_address">
															<option value="">选择企业地址</option> 
															<option value="FZ">福州</option>
															<option value="XM">厦门</option>
														</select>
									
														<!-- 	<i class="ace-icon fa fa-globe"></i> -->
														</span>
														
													</label>
													
													<label class="block">
														<input type="checkbox" id="companyaccept" class="ace" />
														<span class="lbl">
															我接受
															<a href="#">注册条款</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">重置</span>
														</button>

														<button type="button" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">注 册</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												返回首页
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
									<!--注册结束 -->
							</div><!-- /.position-relative -->

							<div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">酷黑</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">炫蓝</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">亮白</a>
								&nbsp; &nbsp; &nbsp;
							</div>
						</div>
						
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->



		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src=<%=path+"/js/jquery-2.1.4.min.js" %>></script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="assets/js/jquery-1.11.3.min.js"></script>
		<![endif]-->
		<script type="text/javascript">
		if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
			<%-- if('ontouchstart' in document.documentElement) document.write('<script src='+<%=path+"/js/jquery.mobile.custom.min.js"%>+'>'+'<'+'/script>'); --%>
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			
			//注册信息验证
			jQuery(function($) {
			//公司全称失去焦点AJAX查询
			$("#company_name").blur(function () {
			var company_name=$(this).val();
			if(company_name!=null||company_name!=" "){
			console.log("----注册公司全称----"+company_name);
			//走AJAX
			$.ajax({
				url:"../register/checkName.action",
				type:"POST",
				data:{
					"companyName":company_name
				},
				success:function(msg){
					if(msg!=null||msg!=""){
						
					alert(msg);
					console.log("收到的结果"+data);
					}	
				}
			});
			}else{
				console.log("----注册公司全称为空----");
			}
			
			
			});
			//账号失去焦点
			 $("#company_account").blur(function () {
				var company_account=$(this).val();
				if(company_account!=null||company_account!=""){
				console.log("----注册公司账号----"+company_account);
				//走AJAX
				$.ajax({
					url:"/register/checkAccount.action",
					type:"POST",
					data:{
						"companyAccount":company_account
						
						
						
					},
					success:function(msg){
						console.log("收到的结果"+data);
						
						
						
					}
				});
				}
				
				});
			
			
			
			
			
			
			
			
			});
			
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
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
			 
			});
		//注册验证操作
			
			
			
		</script>
</body>
</html>