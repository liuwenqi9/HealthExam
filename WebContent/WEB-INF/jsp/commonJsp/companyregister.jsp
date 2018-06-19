0<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<link  rel="stylesheet" href=<%=path+"/csscommon/companyregister.css" %> /> 	
		

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

											<form id="register_form">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text"  id="company_name" class="form-control" placeholder="公司全称" autocomplete="off" />
															<i class="ace-icon glyphicon glyphicon-home"></i>
														</span>
															<span class="block input-icon input-icon-right" id="span_name">
															&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" id="company_account" class="form-control" placeholder="公司账号(4~9位：字母/数字/字母+数字)" />
															<i class="ace-icon fa fa-user"></i>
														</span>
														<span class="block input-icon input-icon-right" id="span_account">
															&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="company_pwd" class="form-control" placeholder="密码为5~14位非空字符" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
														<span class="block input-icon input-icon-right" id="span_pwd">
																&nbsp;
															</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="company_repwd" class="form-control" placeholder="确认密码" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
														<span class="block input-icon input-icon-right" id="span_repwd">
																&nbsp;
															</span>
													</label>
													<!--地址选择  -->
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input class="form-control" name="" id="city" type="text" placeholder="点击请选择地址" autocomplete="off" readonly="true"/>
														
															<i class="ace-icon fa fa-angle-down"></i>
														<!-- 	<i class="ace-icon fa fa-globe"></i> -->
														</span>
														<span class="block input-icon input-icon-right" id="span_addre">
																&nbsp;
															</span>
													</label>
													
													<label class="block">
														<input type="checkbox" id="companyaccept" class="ace" autocomplete="off" />
														<span class="lbl">
															我接受
															<a href="#" id="readterms_a" data-toggle="modal">注册条款</a>
														</span>
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">重置</span>
														</button>

														<button type="button" class="width-65 pull-right btn btn-sm btn-success" id="register_btn">
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
		<!-- 阅读注册条款modal -->
		 <div id="read-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form id="read-form" role="form" >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">注册条款</h3>
						</div>

						<div class="modal-body" style="height: 300px"> 
							<div class="row">
								<div class="col-xs-12">
								<h4>用户接收本医院体检规则</h4>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="accept_btn">确定</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
		<!--modal结束  -->





		<%@include file="footer.jsp" %>
		<script type="text/javascript"  src=<%=path+"/jscommon/companyregister.js" %>></script>
		
			<script type="text/javascript" src=<%=path+"/js/Popt.js" %>></script>
			<script type="text/javascript" src=<%=path+"/js/city.json.js" %>></script>
			<script type="text/javascript" src=<%=path+"/js/citySet.js" %>></script>


		<script type="text/javascript">
		if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		
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
		
		$("#city").click(function (e) {
			SelCity(this,e);
		});
		$("s").click(function (e) {
			SelCity(document.getElementById("city"),e);
		});
		
		
		
		</script>
		
		
		

</body>
</html>