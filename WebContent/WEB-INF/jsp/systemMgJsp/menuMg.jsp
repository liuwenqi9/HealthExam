<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>菜单管理</title>
<style type="text/css">
	th {
	text-align: center;
}
</style>
</head>
<body class="no-skin">
		<%@ include file="menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i></li>
						<li class="active">系统管理</li><li>菜单管理</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<%--这里添加代码  --%>
				<div class="page-content" id="dataBind">
					<div class="page-header">
				<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
				<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
				
				<div class="pull-right"><!-- 查询细项 -->
					<form class="form-inline">
					  <div class="form-group">
					    <input name = "menuname" id = "menunamed" type="text" placeholder="菜单名称" class="form-control" v-model="searchModel.S_workerName">
					  </div>
					  <button id="querymuMg" class="btn btn-sm btn-success" v-on:click="selectBtn" ><i class="glyphicon  glyphicon-search bigger-110"></i>查询</button>
					</form>	
				</div>
				<div style="text-align: center;" class="row">
				<div  class="col-xs-12">
					<table style="text-align: center;" id="grid-table" class="table table-striped table-bordered table-hover">
						<thead >
							<tr style="text-align: center;">
								  <th  width="5%">
								   	序号
								  </th>
								  <th width="15%">
								   	 菜单名称
								  </th>
								  <th width="25%">
								  	二级菜单路径
								  </th>
								  <th width="15%">
								   	对应一级菜单名称
								  </th>
								  <th width="25%">
									  操作
								  </th>
							</tr>
						</thead>

						<tbody >
						<c:forEach var="menu" items="${muList}" varStatus="number">
								<tr class="tr_ofMenu" title="${menu.getMenuid()}">
								<td class = "menuid" value="" style="display: none">${menu.getMenuid()}</td>
								 <td>${number.index+1}</td>
								<td>${menu.getMenuname()}</td>
								<c:choose>
									<c:when test="${menu.getUrl() == null}">
										<td style="color: red;">该路径为最高路径</td>
									</c:when>
									<c:otherwise>
									 <td  style="color:green;">${menu.getUrl()}</td>
									</c:otherwise>
								</c:choose>
							 <c:choose>
								 <c:when test="${menu.getParentid() eq '0'}">
								 	<td style="color: red">暂无</td>
								 </c:when>
								 <c:when test="${menu.getParentid() eq '2'}">
								 	<td style="color:blue;">系统管理</td>
								 </c:when>
								 <c:when test="${menu.getParentid() eq '3'}">
								 	<td  style="color:fuchsia;">体检工作</td>
								 </c:when>
								 <c:when test="${menu.getParentid() eq '4'}">
								 	<td  style="color:green;">统计查询</td>
								 </c:when>
								 <c:when test="${menu.getParentid() eq '5'}">
								 	<td  style="color:maroon;">医生工作站</td>
								 </c:when>
								 <c:when test="${menu.getParentid() eq '6'}">
								 	<td  style="color:purple;">辅助功能</td>
								 </c:when>
								</c:choose>
								
								 
								 <td>
									<div class="btn-group" style="text-align: center;">
										    
										<button class="btn btn-xs btn-info" title="修改" name="${menu.menuid}" menuID="${menu.getMenuid()}" onclick="updataMenu(this)">
											修改
										</button>
										<button class="btn btn-xs btn-danger" title="删除"  onclick="deleteMenu(this)" >
											删除
										</button>
																									
									</div>
								</td>
							</tr>
						</c:forEach>
						
						</tbody>
						<c:if test="${muList==null}">
							<tbody>
								<tr>
									<td colspan="7"  class="center">没有数据</td>
								</tr>
							</tbody>
							</c:if>
						
					</table>

					<ul class="pagination">
					    <li v-on:click="pageItem(pageNum-1)" v-if="pageNum > 1"><a href="#">&laquo;</a></li>
					    <li class="disabled" v-if="pageNum == 1"><a href="#">&laquo;</a></li>
					    <li class="" v-for="todo in pageCount" v-bind:class="{active:todo==pageNum}" v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
					    <li v-on:click="pageItem(pageNum+1)" v-if="pageNum < pageCount.length"><a href="#">&raquo;</a></li>
					    <li class="disabled" v-if="pageNum == pageCount.length"><a href="#">&raquo;</a></li>
					</ul>
					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		   
		</div> 
		<!-- /.page-content -->
		<div id="update-modal" class="modal fade in" tabindex="-1" style="display: none;">
			<form id="update-form" role="form">
					<div class="modal-dialog" style="margin-top: 120px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">修改人员信息</h3>
							</div>

							<div class="modal-body" style="height: 300px;"> 
								<div class="row">
								<div class="form-group">
						    	</div>
						    	<label style="margin-left: 15px;font-size: 20px;">菜单名称:</label>
								<br>
								<input type="text" style="margin-left: 15px" class="col-xs-10 col-sm-5" id="form-input-readonly">
								<br><br>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal" onclick="updatamenu(this)">确定修改</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					
					<!-- 禁用。。。。。。。 -->
					<div id="disable-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="disable-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">禁用提示</h3>
							</div>

							<div class="modal-body" style="height: 150px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;color: red;">温馨提示！<br><br>您是否要禁用{{菜单名称}}这个菜单?</h2>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定禁用</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					<!-- 启用。。。。。。 -->
					<div id="enable-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="enable-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">启用提示</h3>
							</div>

							<div class="modal-body" style="height: 150px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;">温馨提示！<br><br>您是否要启用{{菜单名称}}这个菜单?</h2>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定启用</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
						<!-- 删除。。。。。。 -->
					<div id="delete-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="delete-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">删除</h3>
							</div>
							<div class="modal-body" style="height: 250px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;">温馨提示！<br><br>您是否要删除{{本行的姓名}}这位工作人员的<br>所有信息?</h2>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">删除</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
						<!-- 重置密码。。。。。。 -->
					<div id="resetpassword-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="resetpassword-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">重置密码</h3>
							</div>
							<div class="modal-body" style="height: 250px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;color: red;">温馨提示！<br><br>您是否要对{{本行的姓名}}这位工作人员的<br>密码进行重置?<br>重置密码为'123456'。</h2>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">重置密码</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
				</div>

			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							ShuaiFanDare © 2017 - 2018
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		


		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<%@ include file="footer.jsp"%>
		<script type="text/javascript">
		$(function(){
			$("a[href='menuMg.action']").parent().parent().parent().addClass("active");
			$("a[href='menuMg.action']").parent().parent().parent().addClass("open");
			$("a[href='menuMg.action']").parent().addClass("active");
			
			$("#querymuMg").click(function(){
			var n = $("#menunamed").val()=="";
					$.ajax({
						url : "menuMg.action",
						type : "post",
						dataType : "text",
						data : {
						}
					});
					
		});
		});
		function deleteMenu(node) {
			var con;
			con = confirm("此操作为永久删除，您确定要进行删除菜单吗?")
			if (con) {
				var chileArr = node.parentElement.parentElement.parentElement;  //获取当前节点的所需要的父级节点
				var nodes = filterSpaceNode(chileArr); 
				var rowNum = nodes.rowIndex;  //当前点击行号
				var menuname = document.getElementById('grid-table').rows[rowNum].cells[2].innerText;
				$.ajax({
					url : "deleteMenuMg.action",
					type : "POST",
					dataType : "text",
					data : {
						"menuname" : menuname
					},
					success : function (data) {
						if (data == "OK") {
							alert("删除成功");
							parent.location.reload();
						} else {
							alert("删除失败,请检查网络连接状况");
						}
					}
				});
				
			}
			
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
	var updatamenuid;
	function updatamenu() {
		$.ajax({
			url : "updatamenuMg.action",
			type : "POST",
			dataType : "text",
			data : {
				"menuname" : $("#form-input-readonly").val(),
				"menuid" : updatamenuid
				
			},
			success : function(data) {
				if (data=="OK") {
					alert("修改成功");
					parent.location.reload();
				} else {
					alert("修改失败");
				}
			}
			
		});
	}
	function updataMenu(node){	
 		updatamenuid = node.getAttribute("name");
 		$('#update-modal').modal('show')
	}
			
		</script>
</html>