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
				<li>员工信息与建档</li>
				<li class="active">员工信息</li>
			</ul>
			<div class="page-content" id="dataBind">
				<div class="page-header">


					<div class="row">
						<div class="col-xs-12">
							<table id="grid-table"
								class="table table-striped table-bordered table-hover"  >
								<thead>
									<tr >
										<th width="5%">序号</th>
										<th width="20%">姓名</th>
										<th width="20%">年龄</th>
										<th width="20%">性别</th>
										<th width="20%">电话</th>
										<th width="15%">身份证号</th>
									</tr>
								</thead>

								<tbody>

									<tr class="" v-for="(todo, index) in employeeList">
										<td class="center">{{index+1}}</td>
										<td class="center" >{{todo.name}}</td>
										<td class="center">{{todo.age}}</td>
										<td class="center">{{todo.sex}}</td>
										<td class="center">{{todo.telephone}}</td>
										<td class="center">{{todo.identity}}</td>
									</tr>

								</tbody>

								<tbody>
									<c:if test="${acList.size() < 1}">
										<tr>
											<td colspan="8" class="center">没有企业数据</td>
										</tr>
									</c:if>
								</tbody>


							</table>

							<ul class="pagination">
										<li v-on:click=(pageItem(currentPage-1))><a href="#">&laquo;</a></li>
										<li v-for="todo in pageCount" v-bind:class="{active:todo==currentPage}" v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
										<li v-on:click=(pageItem(currentPage+1))><a href="#">&raquo;</a></li>	
									</ul>
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

	<script src="<%=request.getContextPath()%>/js/employeeInfo.js"></script>
	
</body>
</html>
