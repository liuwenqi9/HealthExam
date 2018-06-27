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
								<input id="name" name="name" type="text" placeholder="账户名称" class="form-control"
									v-model="searchModel.S_cardNum">
							</div>
							<div class="form-group">
								<select class="form-control" v-model="searchModel.S_cardStatus">
									<option value="" selected="selected">账户状态</option>
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
							<button id="queryAcMg" type="" class="btn btn-sm btn-success" v-on:click="selectBtn">
								<i class="glyphicon  glyphicon-search bigger-110"></i>查询
							</button>
						</form>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="grid-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="20%">企业账号</th>
										<th width="25%">企业名称</th>
										<th width="20%">账户状态</th>
										<th width="15%">账户余额</th>
										<th width="20%">操作</th>
									</tr>
								</thead>

								<tbody>

									<c:forEach var="account" items="${acList}">
										<tr id="tr_ofAccount">
											
											<td class="center"><c:out value="${account.getAccount()}"></c:out></td>

											<td class="center"><c:out value="${account.getName()}"></c:out></td>

											<c:choose>
												<c:when test="${account.getState() eq '1'}">
													<td class="center"><c:out value="在用状态 "></c:out></td>
												</c:when>
												<c:otherwise>
													<td class="center"><c:out value="禁用状态"></c:out></td>
												</c:otherwise>
											</c:choose>

											<td class="center"><c:out value="${account.getAmount()}"></c:out></td>
											<td class="center">
												<div class="btn-group">

													<c:choose>
														<c:when test="${account.getState() eq '1'}">
															<button value="${account.getAccount()}"
																title="${account.getState()}"
																class="btn btn-xs btn-danger changeState">禁用</button>
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
						window.location.reload(); //刷新
					}

				});
			});
			
			
			$("#queryAcMg").click(function(){					
				$.ajax({
					url : "AccountMg.action",
					type : "post",
					dataType : "text",
					data : {
				

					}
				
				
					
				})
				
			});
		});
	</script>
</body>
</html>
