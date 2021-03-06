<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>健康团检企业登录</title>

<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<link rel="stylesheet" href=<%=path + "/css/bootstrap.min.css"%> />
<link rel="stylesheet"
	href=<%=path + "/font-awesome/4.5.0/css/font-awesome.min.css"%> />


<link rel="stylesheet" href=<%=path + "/css/fonts.googleapis.com.css"%> />

<link rel="stylesheet" href=<%=path + "/css/ace.min.css"%> />

<link rel="stylesheet" href=<%=path + "/css/ace-rtl.min.css"%> />



</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="ace-icon fa fa-leaf green"></i> <span class="red">健康团检</span>
								<span class="white" id="id-text2">企业登录</span>
							</h1>
							<h4 class="blue" id="id-company-text">&copy; 传一科技JX1711健康团队</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter Your
											Information
										</h4>

										<div class="space-6"></div>

										<form action="loginClietJsp.action" method="post"
											id="loginFrom" path=<%=path%>>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="account" type="text" name="account"
														class="form-control" placeholder="Username" /> <i
														class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="password" type="password" name="password"
														class="form-control" placeholder="Password" /> <i
														class="ace-icon fa fa-lock"></i>
												</span>
												</label> <input type="text" size="10px" id="VerificationCode"
													name="VerificationCode" placeholder="请输入验证码"
													id="VerificationCode" /> <img id="image-code"
													src=<%=path + "/createImage.action"%>
													onclick="changeCodes()" align="middle">



												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> Remember Me</span>
													</label> -
													<button type="button" id="login"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="ace-icon fa fa-key"></i> <span
															class="bigger-110">Login</span>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

										<div class="social-or-login center">
											<span class="bigger-110"><a
												href="<%=request.getContextPath()%>/loginJsp.action"
												data-target="#signup-box" style="font-size: 20px">我是医院工作人员，前往工作人员登录页 </a>
											</span> 
										</div>

										<div class="space-6"></div>

										<div class="social-login center">
											<a class="btn btn-primary"> <i
												class="ace-icon fa fa-facebook"></i>
											</a> <a class="btn btn-info"> <i
												class="ace-icon fa fa-twitter"></i>
											</a> <a class="btn btn-danger"> <i
												class="ace-icon fa fa-google-plus"></i>
											</a>
										</div>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">
										<div></div>

										<div>
											<a
												href="<%=request.getContextPath()%>/register/register.action"
												data-target="#signup-box" class="user-signup-link">
												前往企业注册页面 <i class="ace-icon fa fa-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="ace-icon fa fa-key"></i> Retrieve Password
										</h4>

										<div class="space-6"></div>
										<p>Enter your email and to receive instructions</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="ace-icon fa fa-lightbulb-o"></i> <span
															class="bigger-110">Send Me!</span>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> Back to login <i
											class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="ace-icon fa fa-users blue"></i> New User
											Registration
										</h4>

										<div class="space-6"></div>
										<p>Enter your details to begin:</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" placeholder="Username" />
														<i class="ace-icon fa fa-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Password" /> <i class="ace-icon fa fa-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														placeholder="Repeat password" /> <i
														class="ace-icon fa fa-retweet"></i>
												</span>
												</label> <label class="block"> <input type="checkbox"
													class="ace" /> <span class="lbl"> I accept the <a
														href="#">User Agreement</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="ace-icon fa fa-refresh"></i> <span
															class="bigger-110">Reset</span>
													</button>

													<button type="button"
														class="width-65 pull-right btn btn-sm btn-success">
														<span class="bigger-110">Register</span> <i
															class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> <i
											class="ace-icon fa fa-arrow-left"></i> Back to login
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.signup-box -->
						</div>
						<!-- /.position-relative -->

						<div class="navbar-fixed-top align-right">
							<br /> &nbsp; <a id="btn-login-dark" href="#">Dark</a> &nbsp; <span
								class="blue">/</span> &nbsp; <a id="btn-login-blur" href="#">Blur</a>
							&nbsp; <span class="blue">/</span> &nbsp; <a id="btn-login-light"
								href="#">Light</a> &nbsp; &nbsp; &nbsp;
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>

	<script src=<%=path + "/js/jquery-2.1.4.min.js"%>></script>
	<script src=<%=path + "/js/jquery-1.11.3.min.js"%>></script>
	<script src=<%=path + "/js/jquery.js"%>></script>
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document.write("<script src='/js/jquery.mobile.custom.min.js'>"
					+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$("#login").click(
				function() {
					var account = $("#account").val();
					var password = $("#password").val();
					var veriCode = $("#VerificationCode").val();
					// 			var ret = /^[^\u4e00-\u9fa5]+$/;
					if (account == null || account == "") {
						alert("请输入帐户名")
					} else if (password == null || password == "") {
						alert("请输入密码")
					} else if (veriCode == null || veriCode == "") {
						alert("请输入验证码");
					} else {
						// 				alert($("#userName").val());
						// 				alert($("#password").val());
						$.ajax({
							url : "loginCliet.action",
							type : "post",
							dataType : "text",
							data : {
								"account" : account,
								"password" : password,
								"VerificationCode" : veriCode

							},
							success : function(data) {
								if (data == "OK") {
									alert("登陆成功");
									var formNode = document
											.getElementById("loginFrom");
									var basepath = formNode
											.getAttribute("path");

									formNode.action = 'loginClientThis.action';
									formNode.submit();

								} else if (data == "FAIL") {

									alert("账户或密码错误");

								} else if (data == "FAILCode") {
									alert("验证码错误");
									changeCodes();
								}
							}
						})

					}

				});

		var temp;
		$(function() {

			temp = $("#image-code").attr("src");
		})
		// 更换验证码
		function changeCodes() {
			$("#image-code").attr("src", "");
			$("#image-code")
					.attr("src", temp + "?data=" + new Date().getTime());
		}
	</script>


</body>
</html>
