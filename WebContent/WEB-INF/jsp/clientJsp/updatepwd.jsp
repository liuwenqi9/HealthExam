<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body class="no-skin">
	<%@include file="menu.jsp"%>
	<div class="main-content">
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

		
			
			<div align="center" >
			     <p>原密码:  &emsp;&nbsp;  <input type="text" style="height: 50px;"></p>
			     <p>新密码:  &emsp;&nbsp; <input type="password"  style="height: 50px;"></p>
			     <p>确认密码:&emsp;<input type="password"  style="height: 50px;"></p>
			     <p><button type="submit"  style="width: 60px;">确定</button>  &emsp;<button type="button"  style="width: 60px;" >重置</button></p>
			</div>
		</div>

		<%--这里添加代码  --%>
	

	</div>

	<!-- /.main-content -->

	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder">Ace</span>
					小潘 © 2017 - 2018
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>

	<%@include file="footer.jsp"%>
		<script type="text/javascript">
$(function(){
	$("a[href='uploadNameList.action']").parent().parent().parent().addClass("active");
	$("a[href='uploadNameList.action']").parent().parent().parent().addClass("open");
	$("a[href='uploadNameList.action']").parent().addClass("active");
	
});
</script>
	<script src="<%=request.getContextPath()%>/js/parameter.js"></script>
</body>
</html>