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

	<div class="main-content" id="bill">
		
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
					<li class="active">团检单位结款</li>
				</ul>
				<div class="page-content" id="dataBind">
					<div class="page-header">


						<div class="row">
							<div class="col-xs-12">
								<table id="grid-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center" width="5%">序号</th>
											<th class="center" width="5%">账单号</th>
											<th class="center" width="15%">企业账户</th>
											<th class="center" width="15%">记账金额</th>
											<th class="center" width="20%">下单时间</th>
											<th class="center" width="15%">账单状态</th>
											<th class="center" width="15%">操作</th>
										</tr>
									</thead>

									<tbody>

										<tr v-for="(todo, index) in billList"  v-if=(todo.state)==1>
											<td class="center">{{index+1}}</td>
											<td class="center">{{todo.chargeid}}</td>
											<td class="center">{{todo.account}}</td>
											<td class="center">{{todo.amount}}</td>
											<td class="center">{{todo.pretime}}</td>
											<td class="center"><span v-if=(todo.state)==1
												class="label label-lg label-warning arrowed-in arrowed-in-right">待结款</span>



											</td>

											<td class="center">
												<button id="billBtn" class="btn btn-xs btn-primary"
													onclick="settlement(this)">
													<i class="ace-icon fa fa-pencil bigger-110"></i> <span
														class="bigger-100">结款</span>
												</button>
												<button class="btn btn-xs btn-primary"
													v-on:click="showModal(''+todo.chargeid, index, todo.recordstate)">
													<i class="ace-icon fa fa-pencil bigger-110"></i> <span
														class="bigger-100">催单</span>
												</button>

											</td>
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
									<li v-for="todo in pageCount"
										v-bind:class="{active:todo==currentPage}"
										v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
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

	<script src="<%=request.getContextPath()%>/js/bill.js"></script>

</body>
</html>
