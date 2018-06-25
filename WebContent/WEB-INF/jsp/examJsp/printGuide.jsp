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
				<li>体检工作</li>
				<li class="active">打印导检单和条码</li>
			</ul>
			<div class="page-content" id="dataBind">
				<div class="page-header">

					<div class="pull-left">
						<form id="accountForm" action="printGuide.action"
							class="form-inline">
							<div class="form-group">
								<select class="form-control">
									<option value="" selected="selected">选择企业账号</option>
									<option v-for="todo in accountList" v-bind:value="todo.account"
										v-on:click="accountChange(todo.account,todo.name,todo.amount)">{{todo.name}}</option>
								</select> <span id="userName" style="color: green"></span> <span
									id="currentAmount" style="color: green"></span>
							</div>
						</form>
						<button class="btn btn-xs btn-success">打印此企业员工的导检单</button>
						<a
							class="dt-button buttons-print btn btn-white btn-primary btn-bold"
							tabindex="0" aria-controls="dynamic-table" data-original-title=""
							title="">
							<span><i class="fa fa-print bigger-110 grey"></i>
								<span class="hidden">Print</span>
							</span>
						</a>

					</div>
					<form action="makeCharge.action">
						<div class="row">

							<div class="col-xs-12">
								<table id="dynamic-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="20%">序号</th>
											<th width="20%">姓名</th>
											<th width="20%">开单时间</th>
											<th width="20%">检查项目</th>
											<th width="20%">接收科室</th>
										</tr>
									</thead>

									<tbody>
										<tr class="" v-for="(todo, index) in guideInfoList">
											<td class="center">{{todo.rownumber}}</td>
											<td>{{todo.name}}</td>
											<td>{{todo.time}}</td>
											<td>{{todo.itemname}}</td>
											<td>{{todo.deptname}}</td>
										</tr>

									</tbody>

									<tbody>
										<c:if test="${guideInfoList.size() < 1}">
											<tr>
												<td colspan="8" class="center">没有该企业的导检信息</td>
											</tr>
										</c:if>
									</tbody>


								</table>

								<!-- 分页  -->
								<ul class="pagination">
									<li v-on:click=(pageItem(currentPage-1))><a href="#">&laquo;</a></li>
									<li v-for="todo in pageCount"
										v-bind:class="{active:todo==currentPage}"
										v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
									<li v-on:click=(pageItem(currentPage+1))><a href="#">&raquo;</a></li>
								</ul>

								<!-- PAGE CONTENT ENDS -->
							</div>
						</div>
					</form>
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
					罗杭春 © 2017 - 2018
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
	<script src="<%=request.getContextPath()%>/js/printGuide.js"></script>

</body>
</html>
