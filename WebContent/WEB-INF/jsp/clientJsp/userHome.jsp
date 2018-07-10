<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%
	//获取路径		
	request.setAttribute("basePath", request.getContextPath());
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>首页</title>
<style type="text/css">
/*示例1*/
    #move_port{
      position: fixed;
      width: 15%;
      min-height: 80px;
      left: 0;
      top:0;
      cursor: pointer;
      background: #2aabd2;
      z-index: 10000;//调整层级
/*       background-image:url(../images/hot.jpg); */
    }
</style>
</head>
<body class="no-skin">

	<%@ include file="menu.jsp"%>

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
				<li class="active">首页</li>
			</ul>

			<!-- /.breadcrumb -->
		</div>

		<%--这里添加代码  --%>
		<div></div>

	</div>
	<!-- /.main-content -->
<%-- <div id=img1 style="Z-INDEX: 100; LEFT: 2px; WIDTH: 59px; POSITION: absolute; TOP: 43px; HEIGHT: 61px;visibility: visible;">
        <a href="#" target="_blank">
             <img src="${basePath}/images/hot.jpg" width="160" height="80" border="0">
        </a>
  </div> --%>
  <div class="scroll_end"></div>

<div id="move_port" style="width:160px; height:40px; background:url(${basePath}/images/hot.jpg);">
  <!--   move_obj("#move_port"); -->
  <a href="getTeamOpenJsp.action"><h3 style="color: red;">内科检查套餐当前最火！！！</h3></a>
</div>
	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder">Ace</span>
					健康体检团检 © 2017 - 2018
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
			$("a[href='index.action']").parent().addClass("active");

		 move_obj("#move_port");
		});
	</script>
	
</html>
