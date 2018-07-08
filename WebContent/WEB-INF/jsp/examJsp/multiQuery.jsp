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
				<li>统计查询</li>
				<li class="active">体检综合查询</li>
			</ul>
			<div class="page-content" id="multiQueryDataBind">
				<div class="page-header">

					<div  class="form-inline">
							<div class="form-group">
								<select class="form-control" v-model="multiCondition.account" >
									<option value="" selected="selected">选择企业账号</option>
									<option v-for="todo in accountList" v-bind:value="todo.account" >{{todo.name}}</option>
								</select> 
								
								<input type="text" placeholder="输入要搜索的姓名" class="form-control" v-model="multiCondition.name"> 
								<input type="text" placeholder="输入要搜索的电话号码" class="form-control"  v-model="multiCondition.telephone"> 
									
								<select class="form-control" v-model="multiCondition.state" >
									<option value="" selected="selected" >所有体检状态</option>
									<option value="1">未检查</option>
									<option value="0">已经检查</option>
								</select>
								
								<button id="multiQueryBtn" class="btn btn-sm btn-success" v-on:click="multiQuery()">
									<i class="glyphicon  glyphicon-search bigger-110"></i>查询
								</button>
							</div>

					</div>
					<form action="makeCharge.action">
						<div class="row">

							<div class="col-xs-12">
								<table id="dynamic-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center" width="10%">姓名</th>
											<th class="center" width="20%">所属公司</th>
											<th class="center" width="10%">联系电话</th>
											<th class="center" width="15%">体检时间</th>
											<th class="center" width="15%">检查项目</th>
											<th class="center" width="15%">体检小结详情</th>
											<th class="center" width="15%">体检总结详情</th>
										</tr>
									</thead>

									<tbody>
										<tr class="" v-for="(todo, index) in multiInfoList">
											<td class="center">{{todo.name}}</td>
											<td class="center">{{todo.accountname}}</td>
											<td class="center">{{todo.telephone}}</td>
											<td class="center">{{todo.time}}</td>
											<td class="center">{{todo.itemname}}</td>
											<td class="center"><a>小结详情</a></td>
											<td class="center"><a>总结详情</a></td>
										</tr>
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
	<script src="<%=request.getContextPath()%>/js/multiquery.js"></script>

</body>
</html>
