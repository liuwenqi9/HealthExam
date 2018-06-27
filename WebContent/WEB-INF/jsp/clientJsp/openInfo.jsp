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
			<div class="page-content" id="dataBind">
				<div class="page-header">
					<form action="makeCharge.action">
						<div class="row">


							<div class="col-xs-12">
								<table id="grid-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center" width="20%">序号</th>
											<th class="center" width="20%">员工</th>
											<th class="center" width="20%">开单时间</th>
											<th class="center" width="20%">体检套餐</th>
											<th class="center" width="20%">套餐价格</th>
										</tr>
									</thead>

									<tbody>

										<c:forEach var="order" items="${orderList}">
											<tr>
												<td class="center"><c:out value="${order.getRownumber()}"></c:out></td>
												<td class="center"><c:out value="${order.getName()}"></c:out></td>
												<td class="center"><c:out value="${order.getTime()}"></c:out></td>
												<td class="center"><c:out value="${order.getPackname()}"></c:out></td>
												<td class="center"><c:out value="￥${order.getPrice()}"></c:out></td>
											</tr>
										</c:forEach>

									</tbody>

									<tbody>
										<c:if test="${orderList.size() < 1}">
											<tr>
												<td colspan="8" class="center">没有人员数据</td>
											</tr>
										</c:if>
									</tbody>


								</table>

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
	<script>
		$(function() {

		});
	</script>
</body>
</html>
