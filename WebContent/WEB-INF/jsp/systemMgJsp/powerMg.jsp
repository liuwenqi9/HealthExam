<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>权限管理</title>
</head>
<body class="no-skin">
		<%@ include file="menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i></li>
						<li class="active">系统管理</li><li>权限配置</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>
				
				<%--这里添加代码  --%>
				<div class="page-content" id="dataBind">
					<div class="page-header">
						<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
						<!-- 权限管理大div -->
						<div class="widget-box widget-color-blue ui-sortable-handle">
						<div class="widget-header" >
							<h5 class="widget-title bigger lighter">
							<font style="vertical-align: inherit;">
								权限配置
								<span style="float:right" id="sp_sysTime"></span>
							</font>
							</h5>
							</div>
						</div>
<!-- 							<div class="hr hr-14 hr-dotted" ></div>横线，单行 -->
						
							<!-- 再此处加入手风琴菜单 ；总共添加三个，分别对应角色、已经获得的权限、未获得的权限-->
							<!-- 左边角色的手风琴 -->
							<div class="row">
							<div class="col-xs-12">
					<table id="grid-table" style="margin-left: -6px" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								  <th width="33%" style="font-size: 15px;text-align: center;">
								   	角色职位
								  </th>
								  <th width="33%" style="font-size: 15px;text-align: center;">
								   	 已有权限
								  </th>
								  <th width="33%" style="font-size: 15px;text-align: center;">
								  	未拥有的权限
								  </th> 
							</tr>
						</thead>
						
						
						<!-- 表格体中含有手风琴 -->
						<tbody >
							<tr class="" style="color: black;height: 100%;">
								 <td style="height: 480px">
								 
								 <div class="main-container ace-save-state" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.loadState('main-container')
		} catch (e) {
		}
	</script>
</div>
<div id="sidebar" style="width: 100%;"
	class="sidebar responsive ace-save-state"data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
<ul class="nav nav-list" style="top: 0px;">
		<li class="" style="width: 100%;">
		<a href="#" class="dropdown-toggle" style="width: 100%;"> 
		<i class="menu-icon fa fa-list">
		</i> <span class="menu-text">管理员 </span><b class="arrow fa fa-angle-down"></b>
		</a> 
		<b class="arrow"></b>

			<ul class="submenu">

				<li class=""><a href="AccountMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 管理员
				</a> <b class="arrow"></b></li>
			</ul>
		</li>
	</ul>
</div>
								 </td>
								 <td>
								 <div class="main-container ace-save-state" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.loadState('main-container')
		} catch (e) {
		}
	</script>
</div>
<div id="sidebar" style="width: 100%;"
	class="sidebar responsive ace-save-state"data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
<ul class="nav nav-list" style="top: 0px;">
		<li class="" style="width: 100%;">
		<a href="#" class="dropdown-toggle" style="width: 100%;"> 
		<i class="menu-icon fa fa-list">
		</i> <span class="menu-text">辅助功能 </span><b class="arrow fa fa-angle-down"></b>
		</a> 
		<b class="arrow"></b>

			<ul class="submenu">

				<li class=""><a href="AccountMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 修改密码<i title="移除" class="fa fa-arrow-right" style="float: right;margin-right: 60px;"></i>
				</a> <b class="arrow"></b></li>
			</ul>
		</li>
	</ul>
</div>									
								 </td>
								 <td>
												 <div class="main-container ace-save-state" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.loadState('main-container')
		} catch (e) {
		}
	</script>
</div>
<div id="sidebar" style="width: 100%;"
	class="sidebar responsive ace-save-state"data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
<ul class="nav nav-list" style="top: 0px;">
		<li class="" style="width: 100%;">
		<a href="#" class="dropdown-toggle" style="width: 100%;"> 
		<i class="menu-icon fa fa-list">
		</i> <span class="menu-text">辅助功能 </span><b class="arrow fa fa-angle-down"></b>
		</a> 
		<b class="arrow"></b>

			<ul class="submenu">

				<li class=""><a href="AccountMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 修改密码<i title="添加" class="fa fa-arrow-left" style="float: right;margin-right: 60px;"></i>
				</a> <b class="arrow"></b></li>
			</ul>
		</li>
	</ul>
</div>
								 </td>
							</tr>
						</tbody>
						
						</table>
						
							
						
						</div>
						</div>
					</div>
					
					 
		<!-- /.page-content -->
					
						
					
		</div>



			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							ShuaiFanDare © 2017 - 2018
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		


		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<%@ include file="footer.jsp"%>
		<script type="text/javascript">
		$(function(){
			$("a[href='powerMg.action']").parent().parent().parent().addClass("active");
			$("a[href='powerMg.action']").parent().parent().parent().addClass("open");
			$("a[href='powerMg.action']").parent().addClass("active");
			
			//获取系统时间
			setInterval('sysTime()',1000);
			
			
		});
		
		function sysTime() {
			var today = new Date();// 系统时间（今天）
			var dateAndTime = today.toLocaleString();
			$("#sp_sysTime").html(dateAndTime+"&nbsp;&nbsp;"); 
		}

		
				/* //新增人员弹出
		bootbox.setDefaults("locale","zh_CN");  //弹窗设置中文
		bootbox.confirm("投票已结束，是否直接查看投票结果？",function(re){
	 	if(re) {
	       voteResults(id,title); 
	  		}
		});
 */

	
			
		</script>
</html>