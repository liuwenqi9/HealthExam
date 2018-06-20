<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室设置</title>

<!-- 面包屑 -->
<script type="text/javascript">
	try {
		ace.settings.check('breadcrumbs', 'fixed')
	} catch (e) {
	}
</script>

</head>
<body class="no-skin">
	<%@include file="menu.jsp"%>
	<div class="main-content" id="dataBind">
	
		<div class="breadcrumbs" id="breadcrumbs">

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a
					href="<%=request.getContextPath()%>/web/index.jsp">首页</a></li>
				<li>系统管理</li>
					<li class="active">科室设置</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>

		<%--这里添加代码  --%>
		<div class="page-content">
				<div class="page-header">	
<!-- 					<a href="" class="btn btn-sm btn-purple">
					<i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>  -->
					<a data-toggle="modal" href="#drug-stop" class="btn btn-sm btn-success" onclick="$('#add-modal').modal('show');">
					<i class="glyphicon glyphicon-plus bigger-110"></i>添加科室</a>
					
					<div class="pull-right">
						<form class="form-inline">
				    		<a href="#" class="btn btn-sm btn-primary" v-on:click="searchDept"><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
							<div class="form-group">
						    	<input type="text" placeholder="科室名称" class="form-control" id="seachName">
						  	</div>
						</form>
					</div>									
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-12">
								
								<div>
									<table id="dynamic-table" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th class="center">
													<label class="pos-rel"> 
														序号
<!-- 														<input type="checkbox" class="ace" /> 
														<span class="lbl"></span> -->
<!-- 														<button class="btn btn-xs btn-danger">
															<i class="ace-icon fa fa-trash-o bigger-120"></i>
														</button> -->
													</label>
												</th>
												<th>科室名称</th>
												<th>操作</th>
											</tr>
										</thead>
										
										<!-- 表格体 -->
										<tbody>	
											<tr class="" v-for="(todo, index) in deptList">											
												<td class="center">{{index+1}}</td>
												<td>{{todo.deptname}}</td>
												<td>
													<button class="btn btn-xs btn-danger" v-on:click="deletDept(''+todo.deptid)">
															<i class="ace-icon fa fa-trash-o bigger-120"></i>
														</button>		
														<button class="btn btn-xs btn-info" v-on:click="showModal(''+todo.deptid,index)">
															<i class="ace-icon fa fa-pencil bigger-120"></i>
													</button>
												</td>
											</tr>
										</tbody>
									</table>
									
									<ul class="pagination">
										<li v-on:click=(pageItem(currentPage-1))><a href="#">&laquo;</a></li>
										<li v-for="todo in pageCount" v-bind:class="{active:todo==currentPage}" v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
										<li v-on:click=(pageItem(currentPage+1))><a href="#">&raquo;</a></li>	
									</ul>
								</div>
							</div>					
						</div>
					</div>
				</div>	

			<!-- /.row -->
		</div>
		<!-- /.page-content -->
		
		 <div id="add-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form id="add-form" role="form" >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">添加科室</h3>
						</div>

						<div class="modal-body" style="height: 300px"> 
							<div class="row">
								<div class="col-xs-12">
									<span class="col-xs-4">科室名称:</span>
									<input type="text" name="deptname" id="deptname"/> 
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" v-on:click="addDept()">提交</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
		
		<div id="change-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form id="change-form" role="form">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">更改科室名称</h3>
						</div>

						<div class="modal-body" style="height: 300px"> 
							<div class="row">
								<div class="col-xs-12">
									<span class="col-xs-4">科室名称:</span>
									<input type="text" name="deptname" id="changeName"/> 
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" v-on:click="changeDept()">提交</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
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
	<script src="<%=request.getContextPath() %>/js/dept.js"></script>
</body>
</html>