<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参数设置</title>
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
				<li>系统管理</li>
				<li class="active">参数管理</li>
			</ul>

			<!-- /.breadcrumb -->
		</div>

		<%--这里添加代码  --%>
		<div class="page-content" id="dataBind">
			<div class="page-header">
				<a href="" class="btn btn-sm btn-purple"> <i
					class="ace-icon fa fa-undo bigger-110"></i>刷新
				</a> <a data-toggle="modal" href="#drug-stop"
					class="btn btn-sm btn-success"
					onclick="$('#add-modal').modal('show');"> <i
					class="glyphicon glyphicon-plus bigger-110"></i>添加参数
				</a>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">

							<div>
								<table id="dynamic-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center"><label class="pos-rel"> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
													<button class="btn btn-xs btn-danger">
														<i class="ace-icon fa fa-trash-o bigger-120"></i>
													</button>
											</label></th>
											<th class="hidden">ID</th>
											<th>参数名称</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="account" begin="0" items="${paList}" varStatus="idx">
											<tr id="tr_ofAccount" align="center">
												<td class="pid" ><c:out value="${account.getParameterid()}"></c:out></td>
												<td><c:out value="${account.getParamname()}"></c:out></td>
												<td>
													<div class="btn-group">
<!-- 													$('#change-modal').modal('show');  -->
														<button id="updataParam"  onclick="updataParam(this)"  class="btn btn-xs btn-info">
															<i class="ace-icon fa fa-pencil bigger-120"></i>
														</button>
														<button id="deleteParam" onclick="deleteParam(this)" class="btn btn-xs btn-danger">
															<i class="ace-icon fa fa-trash-o bigger-120"></i>
														</button>
													</div>
												</td>
											</tr>
										</c:forEach>

									</tbody>

									<!-- 表格体 -->
									<tbody>
<%-- 										<c:forEach items="${list}" var="list"> --%>
<!-- 											<tr> -->
<!-- 												<th class="center"><label class="pos-rel"> <input -->
<!-- 														type="checkbox" class="ace" /> <span class="lbl"></span> -->
<!-- 												</label></th> -->
<%-- 												<th class="hidden" title="${list.getDeptid()}">ID</th> --%>
<%-- 												<th>${list.getDeptname()}</th> --%>
<!-- 												<th> -->
<!-- 													<button class="btn btn-xs btn-danger delBtn"> -->
<!-- 														<i class="ace-icon fa fa-trash-o bigger-120"></i> -->
<!-- 													</button> -->
<!-- 													<button class="btn btn-xs btn-info changeBtn"> -->
<!-- 														<i class="ace-icon fa fa-pencil bigger-120"></i> -->
<!-- 													</button> -->
<!-- 												</th> -->
<!-- 											</tr> -->
<%-- 										</c:forEach> --%>
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

		<div id="add-modal" class="modal fade in" tabindex="-1"
			style="display: none;">
			<form id="add-form" role="form" action="insertparamMg.action">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">添加参数</h3>
						</div>

						<div class="modal-body" style="height: 300px">
							<div class="row">
								<div class="col-xs-12">
									<span class="col-xs-4">参数名称:</span> <input type="text"
										name="paramname" id="paramname" />
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="insertDept">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</form>
		</div>

		<div id="change-modal" class="modal fade in" tabindex="-1"
			style="display: none;">
			<form id="change-form" role="form" action=""
				method="post">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">更改参数名称</h3>
						</div>

						<div class="modal-body" style="height: 300px">
							<div class="row">
								<div class="col-xs-12">
									<span class="col-xs-4">参数名称:</span> <input type="text"
										name="changeName" id="changeName" />
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="changeDept">提交</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</form>
		</div>

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
	<script src="<%=request.getContextPath()%>/js/parameter.js"></script>
</body>
</html>