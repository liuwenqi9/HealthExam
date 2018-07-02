<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title></title>
<style type="text/css">
.error {
	color: red;
}
</style>

<%@ include file="header.jsp"%>

</head>
<body class="no-skin">
	<%@ include file="menu.jsp"%>

	<div class="main-content" id="empInfo">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a
					href="<%=request.getContextPath()%>/web/index.jsp">首页</a></li>
				<li>系统指南与辅助</li>
				<li class="active">修改密码</li>
			</ul>
			<div class="page-content" id="dataBind">
				<div class="page-header">


					<div class="row">
						<div class="col-xs-12">
							
							<div align="center">
				<p>
					原密码: &emsp;&nbsp; <input id="oldPwd" type="text"
						style="height: 50px;">
				</p>
				<p>
					新密码: &emsp;&nbsp; <input id="newPwd1" type="password"
						style="height: 50px;">
				</p>
				<p>
					确认密码:&emsp;<input id="newPwd2" type="password"
						style="height: 50px;">
				</p>
				<p>
					<button type="button" id="updateBtn" style="width: 60px;">确定</button>
					&emsp;
					<button type="button" style="width: 60px;">重置</button>
				</p>
			</div>
							
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->

				</div>
				<!-- /.page-content -->
			</div>

			<!-- /.breadcrumb -->
		</div>

	</div>



	<!-- /.main-content -->

	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder"></span>

				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<%@ include file="footer.jsp"%>

	<script type="text/javascript">
		$(function() {

			$("#updateBtn").click(function() {
				alert("修改");
				$.ajax({
					url : "updatePwd.action",
					type : "post",
					dataType : "text",
					data : {
						"oldPwd" : $("#oldPwd").val(),
						"newPwd1" : $("#newPwd1").val(),
						"newPwd2" : $("#newPwd2").val()

					},
					success : function(data) {
						if (data == "OK") {
							alert("修改成功");

						} else if (data == "FAIL") {

							alert("原密码错误");

						}
					}

				})
			})

		})
	</script>


</body>
</html>
