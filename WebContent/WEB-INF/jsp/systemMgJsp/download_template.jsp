<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载模板窗口</title>
</head>
<body class="no-skin">
<%@ include file="menu.jsp"%>
<!-- 内容开始 -->
<div class="main-content">
<!--面包线开始  -->
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
				<li>系统管理</li>
					<li class="active">下载模板</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<!--面包线结束  -->
		<!-- 表格内容开始 -->
		<div class="page-content" id="">
			<div class="page-header">
			<!--陈述下载说明  -->
		</div>
		<!--添加下载按钮位置  -->
		<!--添加表格模板样式  -->
		
		
		
		</div>
		<!--表格内容结束  -->
</div>
<!--内容结束  -->
<!-- 页脚 -->
<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder"></span>
					JSY © 2017 - 2018
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	<!-- 页脚结束 -->
	<!--外联JS链接  -->
<script type="text/javascript">
if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<%@ include file="footer.jsp"%>
</body>
</html>