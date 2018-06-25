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
				<li>体检开单</li>
				<li class="active">团检开单</li>
			</ul>
			<div class="page-content" id="teamOpenDataBind">
				<div class="page-header">
					<form id="teamOpenFormId" action="makeCharge.action">
						<div class="row">
							<div class="col-xs-4">
								<table id="grid-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="50%">选择</th>
											<th width="50%">员工</th>
										</tr>
									</thead>

									<tbody>

										<tr class="" v-for="(todo, index) in personList">
											<td class="center"><input type="checkbox"
												name="personIdList" v-bind:value="todo.personinfoid"
												v-model="personIdList" /></td>
											<td class="center">{{todo.name}}</td>
										</tr>

									</tbody>

									<tbody>
										<c:if test="${personList.size() < 1}">
											<tr>
												<td colspan="8" class="center">没有人员数据</td>
											</tr>
										</c:if>
									</tbody>

								</table>

								<!-- 								PAGE CONTENT ENDS -->
							</div>
							<!-- 							/.col -->
							<div class="col-xs-7">
								<table id="person-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="25%">选择</th>
											<th width="50%">套餐名称</th>
											<th width="25%">套餐价格</th>
										</tr>
									</thead>

									<tbody>

										<tr class="" v-for="(todo, index) in packageList">
											<td class="center"><input type="checkbox"
												name="packageIdList" v-bind:value="todo.packageid"
												v-model="packageIdList" /></td>
											<td class="center">{{todo.packname}}</td>
											<td class="center">{{todo.price}} 元</td>
										</tr>
									</tbody>

									<tbody>
										<c:if test="${packageList.size() < 1}">
											<tr>
												<td colspan="8" class="center">没有套餐数据</td>
											</tr>
										</c:if>
									</tbody>


								</table>

								<!-- 								PAGE CONTENT ENDS -->
							</div>
							<!-- 							/.col -->
							<div class="col-xs-1">
								<button type="button" class="btn btn-success"
									v-on:click="sureOpen()">确认下单</button>

								<!-- 								PAGE CONTENT ENDS -->
							</div>
							<!-- 							/.col -->

						</div>
					</form>
					<!-- 					/.row -->

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

	<%@ include file="footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/teamOpen.js"></script>
	<script>
		
	</script>
</body>
</html>
