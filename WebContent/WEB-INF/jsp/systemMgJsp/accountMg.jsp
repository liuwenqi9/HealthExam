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
				<li>系统管理</li>
				<li class="active">团检单位设置</li>
			</ul>
			<div class="page-content" id="dataBind">
				<div class="page-header">
					<a href="javascript:window.location.reload();"
						class="btn btn-sm btn-purple"><i
						class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
					<!-- <span class="text-error" data-bind="text:errormsg"></span> -->

					<div class="pull-right">
						<form class="form-inline">
							<div class="form-group">
								<input type="text" placeholder="账户名称" class="form-control"
									v-model="searchModel.S_cardNum">
							</div>
							<div class="form-group">
								<select class="form-control" v-model="searchModel.S_cardStatus">
									<option value="" selected="selected">账户状态</option>
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
							<a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn"><i
								class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
						</form>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="grid-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="5%">序号</th>
										<th width="20%">企业账号</th>
										<th width="20%">企业名称</th>
										<th width="20%">账户状态</th>
										<th width="20%">账户余额</th>
										<th width="15%">操作</th>
									</tr>
								</thead>

								<tbody>

									<c:forEach var="account" items="${acList}">
										<tr id="tr_ofAccount">
											<td><c:out value="${account.getState()}"></c:out></td>
											<td><c:out value="${account.getAccount()}"></c:out></td>

											<td><c:out value="${account.getName()}"></c:out></td>

											<c:choose>
												<c:when test="${account.getState() eq '1'}">
													<td><c:out value="在用状态 "></c:out></td>
												</c:when>
												<c:otherwise>
													<td><c:out value="禁用状态"></c:out></td>
												</c:otherwise>
											</c:choose>

											<td><c:out value="${account.getAmount()}"></c:out></td>
											<td>
												<div class="btn-group">

													<c:choose>
														<c:when test="${account.getState() eq '1'}">
															<button value="${account.getAccount()}"
																title="${account.getState()}"
																class="btn btn-xs btn-success changeState">禁用</button>
														</c:when>
														<c:otherwise>
															<button value="${account.getAccount()}"
																title="${account.getState()}"
																class="btn btn-xs btn-success changeState">启用</button>
														</c:otherwise>
													</c:choose>

													<button class="btn btn-xs btn-info">
														<i class="ace-icon fa fa-pencil bigger-120"></i>
													</button>
													<button class="btn btn-xs btn-danger">
														<i class="ace-icon fa fa-trash-o bigger-120"></i>
													</button>
												</div>
											</td>
										</tr>
									</c:forEach>

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
								<li v-on:click="pageItem(pageNum-1)" v-if="pageNum > 1"><a
									href="#">&laquo;</a></li>
								<li class="disabled" v-if="pageNum == 1"><a href="#">&laquo;</a></li>
								<li class="" v-for="todo in pageCount"
									v-bind:class="{active:todo==pageNum}"
									v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
								<li v-on:click="pageItem(pageNum+1)"
									v-if="pageNum < pageCount.length"><a href="#">&raquo;</a></li>
								<li class="disabled" v-if="pageNum == pageCount.length"><a
									href="#">&raquo;</a></li>
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
		<div id="edit-modal" class="modal fade in" tabindex="-1"
			style="display: none;">
			<form id="edit-form" role="form">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">查询卡</h3>
						</div>

						<div class="modal-body" style="height: 300px">
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">卡号:</span> <span class="col-xs-8">{{dat.CARD_INFO_PREFIX}}{{dat.CARD_INFO_NUM}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">卡余额:</span> <span class="col-xs-8">{{dat.PATIENT_BALANCE}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">卡状态:</span> <span class="col-xs-8">{{dat.PARAMETER_ID==0?"待领用":dat.PARAMETER_ID==1?"待销售":dat.PARAMETER_ID==2?"已售卡":dat.PARAMETER_ID==3?"已退卡":dat.PARAMETER_ID==4?"已注销":"未知"}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">就诊人:</span> <span class="col-xs-8">{{dat.PATIENT_NAME}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">领用人:</span> <span class="col-xs-8">{{dat.OPTION_PERSON}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">领用时间:</span> <span class="col-xs-8">{{dat.OPTION_TIME}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">售卡人:</span> <span class="col-xs-8">{{dat.SALE_TIME==null||dat.SALE_TIME==""?"":dat.OPTION_PERSON}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">售卡时间:</span> <span class="col-xs-8">{{dat.SALE_TIME}}</span>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
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
			$(".changeState").click(function() {
				var currentState = $(this).attr("title");
				$.ajax({
					type : "POST",
					url : "changeAccountState.action",
					data : {
						"accountId" : $(this).attr("value"),
						"state" : $(this).attr("title")
					},

					success : function(result) {
						if (result == 1) {
							if (currentState == 1) {
								alert("即将禁用");
								alert($(this));
								$(this).text("禁用");
							} else {
								alert("即将启用");
								//$(this).innerText("启用");
							}
						} else {
							alert("修改状态失败，请重新设置");
						}

					}

				});
			});
		});
	</script>
</body>
</html>
