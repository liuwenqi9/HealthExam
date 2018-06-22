<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>团检结算</title>
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
				<li>体检工作</li>
					<li class="active">记账</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		
		<div class="page-content">
			<!-- 页头 -->
			<div class="page-header">
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<!-- 表头  -->
						<thead>
							<tr>
								<th class="center">
									<label class="pos-rel"> 
									序号
<!-- 								<input type="checkbox" class="ace" /> 
									<span class="lbl"></span> -->
<!-- 								<button class="btn btn-xs btn-danger">
									<i class="ace-icon fa fa-trash-o bigger-120"></i>
									</button> -->
									</label>
								</th>
								<th>企业账户</th>
								<th>结账时间</th>
								<th>下单人数</th>
								<th>实检人数</th>
								<th>订单状态</th> <%--1表示已接收，0表示已完成，3表示已结款 --%>
								<th>操作</th>
							</tr>
						</thead>
						<!-- 表体  -->
						<tbody>	
						</tbody>
					</table>
					
					<!-- 分页  -->
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<li>{{todo}}</a></li>
						<li><a href="#">&raquo;</a></li>	
					</ul>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
		
		
	</div>

</body>
</html>