<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记账</title>

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
		
		<%--这里添加代码  --%>
		<div class="page-content">
			<div class="page-header">
				<!-- 页头-->
				<form class="form-inline">
				    <a href="#" class="btn btn-sm btn-primary" v-on:click="searchBill"><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
					<div class="form-group">
						<input type="text" placeholder="企业名称" class="form-control" id="seachName">
					</div>
				</form>
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
								<th>记账金额</th>
								<th>下单时间</th>
								<th>记账时间</th>
								<th>账单状态</th> <%--1表示未支付，0表示已支付 --%>
								<th>操作</th>
							</tr>
						</thead>
						
						<!-- 表体  -->
						<tbody>	
							<tr class="" v-for="(todo, index) in billList">	
								<td class="center">{{index+1}}</td>
								<td >{{todo.account}}</td>
								<td >{{todo.amount}}</td>
								<td >{{todo.pretime}}</td>
								<td >{{todo.time}}</td>
								<td v-if=(todo.state)==1>
									<span class="label label-sm label-warning arrowed-in">待支付</span>
								</td>
								<td v-else=(todo.state)==0>
									<span class="label label-sm label-success arrowed-in">已支付</span>
								</td>
								<td v-if=(todo.state)==1>
									<button class="btn btn-xs btn-info" v-on:click="showModal(''+todo.chargeid, index)">
										<i class="ace-icon fa fa-pencil bigger-110"></i>
										<span class="bigger-100">记账</span>
									</button>
								</td>
								<td v-else=(todo.state)==0>
									<button class="btn btn-xs btn-info" v-on:click="showModal(''+todo.chargeid, index)">
										<i class="ace-icon fa fa-tags bigger-110"></i>
										<span class="bigger-100">详情</span>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
					
					<!-- 分页  -->
					<ul class="pagination">
						<li v-on:click=(pageItem(currentPage-1))><a href="#">&laquo;</a></li>
						<li v-for="todo in pageCount" v-bind:class="{active:todo==currentPage}" v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
						<li v-on:click=(pageItem(currentPage+1))><a href="#">&raquo;</a></li>	
					</ul>
				</div>
			</div>
			<!-- /.row -->
			
		</div>
		<!-- /.page-content -->
		<div id="bill-modal" class="modal fade in" tabindex="-1" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">订单详情</h3>
						</div>

						<div class="modal-body" style="height: 300px"> 
							<div class="profile-user-info profile-user-info-striped">
								<div class="profile-info-row">
									<div class="profile-info-name">企业账户</div>
									<div class="profile-info-value">
										<span class="label label-info arrowed">{{billObj.account}}</span>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">记账金额</div>
									<div class="profile-info-value">
										<span class="label label-info arrowed">{{billObj.amount}}</span>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">下单时间</div>
									<div class="profile-info-value">
										<span class="label label-info arrowed">{{billObj.pretime}}</span>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">记账时间</div>
									<div class="profile-info-value">
										<span class="label label-info arrowed" v-if=(billObj.time)==null>该订单还未记账</span>
										<span class="label label-info arrowed" v-else=(billObj.time)!=null>{{billObj.time}}</span>
									</div>
								</div>
								<div class="profile-info-row">
									<div class="profile-info-name">订单状态</div>
									<div class="profile-info-value">
										<span class="label label-info arrowed" v-if=(billObj.state)==1>待支付</span>
										<span class="label label-info arrowed" v-else=(billObj.state)==0>已支付</span>
									</div>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" v-if=(billObj.state)==1 v-on:click="recoderBill">记账</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal" v-else=(billObj.state)==0>关闭</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
		</div>
		
	</div>
	
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
	<script src="<%=request.getContextPath() %>/js/charge.js"></script>
</body>
</html>