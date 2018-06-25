<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<style type="text/css">
			td,th {
	text-align: center;
}
		</style>
<title>菜单管理</title>
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
						<li class="active">系统管理</li><li>角色设置</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<%--这里添加代码  --%>
				<div class="page-content" id="dataBind">
					<div class="page-header">
				<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
				<!-- 绑定模态框 -->
				<div id="dialog-form"  class="btn btn-sm btn-success" onclick="$('#edit-modal').modal('show');"><i class="glyphicon glyphicon-plus bigger-110"></i>新增角色</div>
				<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
				
				<div class="pull-right"><!-- 查询细项 -->
					<form class="form-inline">
					  <div class="form-group">
					    <input type="text" placeholder="角色名称" class="form-control" >
					  </div>
					 
					 
					  <a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn" ><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
					</form>	
				</div>
				<!-- 蓝色框框 -->
				<div class="widget-box widget-color-blue ui-sortable-handle">
						<div class="widget-header" >
							<h5 class="widget-title bigger lighter">
							<font style="vertical-align: inherit;">
								角色管理
								<span style="float:right" id="sp_sysTime"></span>
							</font>
							</h5>
							</div>
				<div class="row">
				<div class="col-xs-12" style="text-align: center;">
					<table style="font-size: 20px;" id="grid-table" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								  <th width="10%">
								   	序号
								  </th>
								  <th width="40%">
								   	 角色名称
								  </th>
								  <th width="40%">
								  	操作
								  </th>
							</tr>
						</thead>

						<tbody >
							<c:forEach var = "role" items="${rlList}" varStatus="number" >
								<tr id="tr_ofRole">
									<td><c:out value="${number.index+1}"></c:out></td>
									<td><c:out value="${role.getRolename()}"></c:out></td>
									<td>
										<div class="btn-group" style="text-align: center;">
											    
											<button class="btn btn-info" title="修改" onclick="$('#update-modal').modal('show');">
												修改
											</button>
											<button class="btn btn-purple" title="删除"  onclick="deleteRole(this)">
												删除
											</button>
										</div>
								</td>
								</tr>
								
							
							</c:forEach  >
								
							
						</tbody>
						<c:if test="${rlList==null }">
							<tbody>
								<tr>
									<td colspan="3"  class="center">暂无数据</td>
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
						    	<label style="margin-left: 15px;font-size: 20px;">角色名称:</label>
								<br>
								<input type="text" style="margin-left: 15px" class="col-xs-10 col-sm-5" id="form-input-readonly">
								<br><br>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定修改</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					
					
					</div><!-- /.modal-dialog -->
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">删除</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					
				</div>
		<!-- 增加菜单的模态框  -->
		 <div id="edit-modal" class="modal fade in" tabindex="-1" style="display: none;">
			<form id="edit-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">新增角色</h3>
							</div>

							<div class="modal-body" style="height: 200px;"> 
								<div class="row">
									<div class="col-xs-6">
										<span class="col-xs-8"><input id="rolename" type="text" title="角色名称" placeholder="角色名称" class="form-control"  style="margin-left: 15px;width: 480px;"></span>
									</div>
									<br><br>
									
								</div>
								<div class="hr hr-14 hr-dotted"></div><!-- 横线，单行 -->
								<div class="row">
									
								<div class="form-group">
						    	</div>
							

								
							</div>
						</div>
						<div class="modal-footer">
							<button  onclick="addRole();" type="button" class="btn btn-success" data-dismiss="modal">确定提交</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
						</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</form>
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
			$("a[href='roleMg.action']").parent().parent().parent().addClass("active");
			$("a[href='roleMg.action']").parent().parent().parent().addClass("open");
			$("a[href='roleMg.action']").parent().addClass("active");
			//获取系统时间
			setInterval('sysTime()',1000);
		});
		
		function sysTime() {
			var today = new Date();// 系统时间（今天）
			var dateAndTime = today.toLocaleString();
			$("#sp_sysTime").html(dateAndTime+"&nbsp;&nbsp;"); 
		}
		function deleteRole(node) {

			var con;
			con = confirm("确定要删除吗？"); // 在页面上弹出对话框
			
			 if (con == true) {
				var chileArr = node.parentElement.parentElement.parentElement;  //获取当前节点的所需要的父级节点
				var nodes = filterSpaceNode(chileArr); 
				var rowNum = nodes.rowIndex;  //当前点击行号
				var rolename = document.getElementById('grid-table').rows[rowNum].cells[1].innerText;
				$.ajax({
					url : "deleteRoleMg.action",
					type : "POST",
					dataType : "text",
					data : {
						"rolename":rolename,
					},
					success : function(data) {
						if (data == "OK") {
							
							alert("删除成功");
							parent.location.reload();
						} else if (data == "FAIL") {

							alert("该数据可能被使用中，无法删除!");
							parent.location.reload();
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
		
		function addRole() {
			alert("增加");
			$.ajax({
				url:"insertroleMg.action",
				type:"POST",
				dataType:"text",
				data:{
					"rolename":$("#rolename").val()
				},
				success : function(data) {
					if (data="OK") {
						alert("增加成功");
						parent.location.reload();
					} else {
						alert("增加失败,可能已存在或网络异常!")
					}
				}
			});
		}	
			
		
	
			
		</script>
</html>