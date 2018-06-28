<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%@ include file="header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
		<title>人员管理</title>
		<style type="text/css">
			td,th {
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
						<li class="active">系统管理</li><li>人员管理</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<%--这里添加代码  --%>
				<div class="page-content" id="dataBind">
					<div class="page-header">
				<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
				<!-- 绑定模态框 -->
				<div id="dialog-form"  class="btn btn-sm btn-success" onclick="$('#edit-modal').modal('show');"><i class="glyphicon glyphicon-plus bigger-110"></i>新增人员</div>
				<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
				
				<div class="pull-right">
					<form class="form-inline">
					  <div class="form-group">
					    <input id="namea" name="name" type="text" placeholder="人员姓名" class="form-control" v-model="searchModel.S_workerName">
					  </div>
					 <!--  <div class="form-group">
					    <select id="sdepartment" class="form-control" name="department" v-model="searchModel.S_parameterId" required="required">
					    	<option value="">科室</option>
							<option v-for="todo in departmentList"  v-bind:value="todo.PARAMETER_ID">{{todo.PARAMETER_NAME}}</option>
						</select>
					  </div> -->
					  <!-- <div class="form-group">
					 	<select id="role" class="form-control" name="role" v-model="searchModel.S_roleName" required="required">
					 		<option value="">角色</option>
							<option v-for="(todo, index) in roleList"  v-bind:value="todo.ROLE_NAME" v-if="todo.ROLE_ID!=4">{{todo.ROLE_NAME}}</option>
						</select>
					  </div> -->
					  <div class="form-group">
					    <select id="userstate" name="state" class="form-control" placeholder="用户状态" v-model="searchModel.S_userStatus"> 
					   		<option value="" selected>用户状态</option>
					    	<option value="0">禁用</option>
					    	<option value="1">启用</option>
					    </select>
					 
					  </div>
					  <button id="querywkMg"  class="btn btn-sm btn-success" ><i  class="glyphicon  glyphicon-search bigger-110"></i>查询</button>
					</form>	
				</div>
				
						<div class="widget-box widget-color-blue ui-sortable-handle">
						<div class="widget-header" >
							<h5 class="widget-title bigger lighter">
							<font style="vertical-align: inherit;">
								人员管理
								<span style="float:right" id="sp_sysTime"></span>
							</font>
							</h5>
							</div>
					</div>
				<div class="row">
				<div class="col-xs-12">
					<table id="grid-table" class="table table-striped table-bordered table-hover" style="color: black;">
						<thead>
							<tr>
								  <th width="5%">
								   	序号
								  </th>
								  <th width="15%">
								   	 人员姓名
								  </th>
								  <th width="15%">
								  	账号
								  </th>
								  <th width="15%">
								   	科室
								  </th>
								  <th width="15%">
								   	角色
								  </th>
								  <th width="15%">
								   	状态
								  </th>
								  <th width="20%">
									  操作
								  </th>
							</tr>
						</thead>

						<tbody id="tbody" >
						<c:forEach var="worker" items="${wkList}" varStatus="number">
							<tr id="tr_ofWorker">
								<td><c:out value="${number.index+1}"></c:out></td>
								<td><c:out value="${worker.getName()}"></c:out></td>
								<td><c:out value="待定"></c:out></td>
								<td><c:out value="待定"></c:out></td>
								<td><c:out value="待定"></c:out></td>
								
								<c:choose>
									<c:when test="${worker.getState() eq '1' }">
										<td id="state" style="color: green;" ><c:out value="启用"><font ></font></c:out></td>
									</c:when>
									<c:otherwise>
										<td id="state" style="color: red;"><c:out value="禁用 "></c:out></td>
									</c:otherwise>
								</c:choose>
								
								<td>
									<div  class="btn-group" style="text-align: center;" >
										    
										<button name="a_modify" id="m_${number.index}" class="btn btn-xs btn-info" title="修改" onclick="bclick(this)">
											修改
										</button>
										<c:choose>
														<c:when test="${worker.getState() eq '1'}">
															<button value="${worker.getWorkerid()}"
																title="${worker.getState()}"
																class="btn btn-xs btn-danger " onclick="changeStage(this)">禁用</button>
														</c:when>
														<c:otherwise>
															<button value="${worker.getWorkerid()}"
																title="${worker.getState()}"
																class="btn btn-xs btn-success  " onclick="changeStage(this)">启用</button>
														</c:otherwise>
													</c:choose>
										
										<button  class="btn btn-xs btn-danger" title="删除" onclick="deleteWorker(this);">
											删除
										</button>
										
										<button class="btn btn-xs btn-warning" title="重置密码" onclick="$('#resetpassword-modal').modal('show');"">
											重置密码
										</button>
										
									</div>
								</td>
							</tr>
						</c:forEach>
						
						
							<c:if test="${wkList==null}">
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
								<label style="margin-left: 15px;font-size: 20px;">人员姓名:</label>
								<br>
								
								
								<input name = "modify_name" id="modify_name" type="text" style="margin-left: 15px" class="col-xs-10 col-sm-5" id="form-input-readonly" value="" disabled="disabled">
								<br><br>
								<label style="margin-left: 15px;font-size: 20px;">修改科室:</label>
								<div class="form-group">
						    	<select class="form-control" title="科室" placeholder="科室" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 15px;"> 
							   		<option value="" selected>科室</option>
							    	<option value="0">xx科</option>
							    	<option value="1">yy科</option>
							    	<option value="3">zz科</option>
						    	</select>
						    	</div>
						    	<div class="form-group">
						    	<select class="form-control" title="角色" placeholder="角色" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 15px;"> 
							   		<option value="" selected>角色</option>
							    	<option value="0">管理员</option>
							    	<option value="1">医生</option>
							    	<option value="3">前台</option>
						    	</select>
						    	</div>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定提交</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
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
		<!-- 增加员工的模态框  -->
		 <div id="edit-modal" class="modal fade in" tabindex="-1" style="display: none;">
			<form id="edit-form" role="form">
					<div class="modal-dialog" style="margin-top: 120px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">新增人员</h3>
							</div>

							<div class="modal-body" style="height: 300px;"> 
								<div class="row">
									<div class="col-xs-6">
										<span class="col-xs-8"><input onblur="" type="text" id="name" title="人员姓名" placeholder="人员姓名" class="form-control"  style="margin-left: 15px;width: 480px;"></span>
									</div>
									<br><br>
									<div class="col-xs-6">
										<span class="col-xs-8"><input id="number" type="text" title="账号" placeholder="账号" class="form-control" style="margin-left: 15px;width: 200px;"></span>
										<!-- 这里要进行正则验证 -->
									</div>
									<div class="col-xs-6">
										<span class="col-xs-8"><input id="password" type="password" title="密码" placeholder="密码" class="form-control" style="width: 200px"></span>
										<!-- 这里要进行正则验证 -->
									</div>
								</div>
								<div class="hr hr-14 hr-dotted"></div><!-- 横线，单行 -->
								<div class="row">
									
								<div class="form-group">
						    	<select class="form-control" title="科室" placeholder="科室" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 40px;"> 
							   		<option value="" selected>科室</option>
							    	<option value="0">xx科</option>
							    	<option value="1">yy科</option>
							    	<option value="3">zz科</option>
						    	</select>
						    	</div>
						    	<div class="form-group">
						    	<select class="form-control" title="角色" placeholder="角色" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 40px;"> 
							   		<option value="" selected>角色</option>
							    	<option value="0">xx角色</option>
							    	<option value="1">yy角色</option>
							    	<option value="3">zz角色</option>
						    	</select>
						    	</div>
					  			
					  				<div class="form-inline">
						    	<select class="form-control" id="state" title="用户状态" placeholder="用户状态" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 40px;"> 
							   		<option value="" selected>用户状态</option>
							    	<option value="0">启用</option>
							    	<option value="1">禁用</option>
						    	</select>
						    	</div>

								
							</div>
						</div>
						<div class="modal-footer">
							<button onclick="addWorker()" type="submit" class="btn btn-success" data-dismiss="modal">确定提交</button>
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
			$("a[href='workerMg.action']").parent().parent().parent().addClass("active");
			$("a[href='workerMg.action']").parent().parent().parent().addClass("open");
			$("a[href='workerMg.action']").parent().addClass("active");
			//获取系统时间
			setInterval('sysTime()',1000);
			
			$("#querywkMg").click(function(){
				var n = $("#namea").val()=="";
				var s = ($("#userstate").val()==1||$("#userstate").val()==0)&&($("#userstate").val()!="");
				if (!n) {
					$.ajax({
						url : "WorkerMg.action",
						type : "post",
						dataType : "text",
						data : {
						}
					});
					
				}
				if (s) {	
					$.ajax({
						url : "selectWorkerByState.action",
						type : "post",
						dataType : "text",
						data : {
							
						}
					});
				}
				});
				
		
			
		});
		/* 点击修改获取对应行号的姓名 */
		function bclick(event) {
				$('#update-modal').modal('show');
				var person_name = $(event).parent().parent().parent().children().eq(1).text();
				$("#modify_name").attr("value",person_name);
				
		}
		/* 点击禁用修改数据库状态为0 */
		function changeStage(evevt) {
			$('#enable-modal').modal('show');
			var currentState = $(evevt).attr("title");
			
		 	$.ajax({
				type : "POST",
				url : "changeWorkerState.action",
				data: {
					"workerid" : $(evevt).attr("value"),
					"state": $(evevt).attr("title")
				},
				success : function(result) {
					if (result == 1) {
						if (currentState == 1) {
							
							alert("禁用成功");
							parent.location.reload();
							
						/* 	window.location.reload();  */
						} else {
							alert("启用成功");
							parent.location.reload();
							
						}
					} else {
						alert("修改状态失败，请重新设置");
					}

				}
				
			}
					
					);
			 
		}
		/* 新增人员 */
		function addWorker() {
			$.ajax({
				url : "insertworkerMg.action",
				type : "POST",
				dataType : "text",
				data : {
					"name" :$("#name").val(),
					"password" : $("#password").val(),
					/* "deptid" : deptid, */
					"state" : $("#state").val()
				},
			success : function(data) {
				if (data ="OK") {
					alert("增加成功");
					parent.location.reload();
				}else {
					alert("增加失败,可能网络异常");
				}
				
			}
			});
			
			
		}
		/* 删除员工*/
		function deleteWorker(node) {
			var con;
			con = confirm("确定要删除该员工吗?")
			if (con) {
				var chileArr = node.parentElement.parentElement.parentElement;  //获取当前节点的所需要的父级节点
				var nodes = filterSpaceNode(chileArr); 
				var rowNum = nodes.rowIndex;  //当前点击行号
				var name = document.getElementById('grid-table').rows[rowNum].cells[1].innerText;
				$.ajax({
					url : "deletworkerMg.action",
					type : "POST",
					dataType : "text",
					data : {
						"name" : name
					},
					success : function(data) {
						if (data=="OK") {
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
	
	
		function sysTime() {
			var today = new Date();// 系统时间（今天）
			var dateAndTime = today.toLocaleString();
			$("#sp_sysTime").html(dateAndTime+"&nbsp;&nbsp;"); 
		}
		/* $("#password").blur(function() {
			var n = $("#password").val();
			if (n==null||n=="" ) {
				alert("密码不能为空");
				$("#password").val() = "";
			}
			
		});
		$("#number").blur(function() {
			var n = $("#number").val();
			if (n==null||n=="" ) {
				alert("账号不能为空");
				$("#number").val() = "";
			}
			
		}); */
		/* $("#name").blur(function() {
			var n = $("#name").val();
			if (n==null||n=="" ) {
				alert("用户名不能为空");
				$("#name").val() = "";
			}
			
		}); */
		
			
		</script>
</html>