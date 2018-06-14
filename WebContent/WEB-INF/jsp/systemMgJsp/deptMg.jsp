<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室设置</title>
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
					<li class="active">科室设置</li>
			</ul>

			<!-- /.breadcrumb -->
		</div>

		<%--这里添加代码  --%>
		<div class="page-content" id="dataBind">
				<div class="page-header">	
								<a href="" class="btn btn-sm btn-purple">
								<i class="ace-icon fa fa-undo bigger-110"></i>刷新</a> 
								<a data-toggle="modal" href="#drug-stop" class="btn btn-sm btn-success" onclick="$('#add-modal').modal('show');">
								<i class="glyphicon glyphicon-plus bigger-110"></i>添加科室</a>									
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
														<input type="checkbox" class="ace" /> 
														<span class="lbl"></span>
													</label>
												</th>
												<th class="hidden">ID</th>
												<th>科室名称</th>
												<th>科室人员</th>
												<th>操作</th>
											</tr>
										</thead>
										
										<!-- 表格体 -->
										<tbody>
										
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
		
		 <div id="add-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form id="add-form" role="form" action="<%=request.getContextPath()%>/addDeptMg.action" method="post">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">查询卡</h3>
						</div>

						<div class="modal-body" style="height: 300px"> 
							<div class="row">
								<div class="col-xs-12">
									<span class="col-xs-4">科室名称:</span>
									<input type="text" name="deptname"/> 
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" data-dismiss="modal">提交</button>
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
</body>
</html>