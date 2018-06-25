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
						<form class="form-inline" action="AccountMg.action">
							<div class="form-group">
								<input id="name" name="name" type="text" placeholder="账户名称"
									class="form-control" v-model="searchModel.S_cardNum">
							</div>
							<div class="form-group">
								<select id="opt" class="form-control" v-model="searchModel.S_cardStatus">
									<option value="" selected="selected">账户状态</option>
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
							<button id="queryAcMg" type="button"
								class="btn btn-sm btn-success" v-on:click="selectBtn">
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
										<th width="5%">序号</th>
										<th width="20%">企业账号</th>
										<th width="20%">企业名称</th>
										<th width="20%">账户状态</th>
										<th width="20%">账户余额</th>
										<th width="15%">操作</th>
									</tr>
								</thead>

								<tbody>

									<c:forEach var="account" begin="0" items="${acList}"
										varStatus="idx">
										<tr id="tr_ofAccount">
											<td><c:out value="${idx.index+1}"></c:out></td>
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

													<button id="updataAcc" onclick="updataBtn(this)"
														class="btn btn-xs btn-info">
														<i class="ace-icon fa fa-pencil bigger-120"></i>
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

	<div id="updata-modal" class="modal fade in" tabindex="-1"
		style="display: none;">
		<form id="updata-form" role="form" action="">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 class="smaller lighter blue no-margin">修改企业名称</h3>
					</div>

					<div class="modal-body" style="height: 300px">
						<div class="row">
							<div class="col-xs-12">
								<span class="col-xs-4">企业名称:</span> <input type="text"
									name="name" id="updataName" />
							</div>
						</div>
						<div class="hr hr-14 hr-dotted"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="updataDept">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</form>
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
	var updataAccid ;
		$(function() {
		   $("#queryAcMg").click(function(){
			   alert("查询");
			   
			   var state=document.getElementById("opt").value;
			   alert(state);
			   
			   $.ajax({
					type : "POST",
					url : "AccountMg.action",
					data : {
						'name':$("#name").val(),
					     'state':state
					},
					success : function(result) {
						
					}
			   });
		   })
			
			
			
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

			$("#updataDept").click(
					function() {
						$.ajax({
							url : "upataAccName.action",
							type : "post",
							dataType : "text",
							data : {
                                'account':updataAccid,
								'name' : $("#updataName").val()
								
							},
							success : function(data) {
								if (data == "OK") {
									alert("修改成功")
									var formNode = document.getElementById("updata-form");

									formNode.action = 'AccountMg.action';
									formNode.submit();

								} else if (data == "FAIL") {

									alert("已存在");

								}
							}
						})

					})

		});

		function updataBtn(node) {
			$('#updata-modal').modal('show')
			var chileArr = node.parentElement.parentElement.parentElement; // 获取当前节点的所需要的父级节点
			var nodes = filterSpaceNode(chileArr);
			var rowNum = nodes.rowIndex; // 当前点击行号
			updataAccid = document.getElementById('grid-table').rows[rowNum].cells[1].innerText; //获取要修改的参数名称
		
		}

		function filterSpaceNode(nodes) {
			for (var i = 0; i < nodes.length; i++) {
				if (nodes[i].nodeType == 3 && /^\s+$/.test(nodes[i].nodeValue)) {
					// 得到空白节点之后，移到父节点上，删除子节点
					nodes[i].parentNode.removeChild(nodes[i]);

				}
			}
			return nodes;
		}
	</script>
</body>
</html>
