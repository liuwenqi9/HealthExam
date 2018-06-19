<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志查看窗口</title>
</head>
<body class="no-skin">
<%@ include file="menu.jsp"%>
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
					<li class="active">日志查看</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<!--面包线结束  -->
		<!-- 内容开始 -->
		<div class="page-content" id="">
				<div class="page-header">	
								<div class="pull-left">
							
							<a href="javascript:window.location.reload();"
						class="btn btn-sm btn-purple"><i
						class="ace-icon fa fa-undo bigger-110"></i>刷新</a>	
							&nbsp;&nbsp;&nbsp;
							</div>	
							
				<div class="pull-center ">
						
						<form class="form-inline">
						
							<div class="form-group">
							<label class="control-label" for=""> 查询时间： </label>
								<input type="date" placeholder="" class="form-control"
									v-model="">
							</div>
							<div class="form-group">
							<label class="control-label" for=""> 至 </label>
								<input type="date" placeholder="" class="form-control"
									v-model="">
							</div>
							<div class="form-group">
							&nbsp;
							<label class="control-label" for=""> 操作事项： </label>
								<input type="text" placeholder="事项" class="form-control"
									v-model="">
							</div>
							<div class="form-group">
							&nbsp;
							<label class="control-label" for=""> 操作人： </label>
								<input type="text" placeholder="姓名" class="form-control"
									v-model="">
									&nbsp;
							</div>
							<a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn"><i
								class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
						</form>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12">
								
								<div>
									<table id="dynamic-table" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th class="center">
													<label class="pos-rel"> 
														<input type="checkbox" class="ace" /> 
														<span class="lbl"></span>
													</label>
												</th>
												<th class="hidden">序号</th>
												<th>操作事项</th>
												<th>操作时间</th>
												<th>操作人</th>
											</tr>
										</thead>
										
										<!-- 表格体 -->
										<tbody>
											
										</tbody>
									</table>
								</div>
							</div>					
						</div>
					</div>
				</div>	

			<!-- /.row -->
		</div>
		<!-- /.page-content -->
		<!-- 内容结束 -->
	</div>
	<!-- /.main-content -->
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
	<%@ include file="footer.jsp"%>
<script type="text/javascript">
if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

</body>
</html>