<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
		<title>套餐配置</title>

	</head>
	<body class="no-skin">
		<%@ include file="menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="toIndex.action">首页</a></li>
						<li>系统管理</li>
					<li class="active">套餐配置</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<%--这里添加代码  --%>
				<div></div>

			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							小潘 © 2017 - 2018
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>


		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<%@ include file="footer.jsp"%>
		<script type="text/javascript">
		$(function(){
			$("a[href='mealMg.action']").parent().parent().parent().addClass("active");
			$("a[href='mealMg.action']").parent().parent().parent().addClass("open");
			$("a[href='mealMg.action']").parent().addClass("active");
		});
		</script>
</html>
