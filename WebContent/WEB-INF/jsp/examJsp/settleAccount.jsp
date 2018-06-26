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
					<li class="active">结账</li>
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
								<th>记账/结算时间</th>
								<th>下单人数</th>
								<th>实检人数</th>
								<th>订单状态</th> <%--1表示已接收，0表示已完成，3表示已结款 --%>
								<th>操作</th>
							</tr>
						</thead>
						<!-- 表体  -->
						<tbody >	
							<tr class="" v-for="(todo, index) in rdList">	
								<td class="center">{{index+1}}</td>
								<td>{{todo.companyacc}}</td>
								<td>			
									<span v-if="(todo.recordstate)==1" class="label label-lg label-primary arrowed arrowed-right">记账时间：{{todo.recordtime}}</span>
									<span v-if="(todo.recordstate)==0" class="label label-lg label-success arrowed arrowed-right">结算时间：{{todo.recordtime}}</span>
								</td>
								<td>
									<i class="ace-icon fa fa-users red bigger-110"></i>
									<span class="bigger-100">{{todo.pnumber}}</span>								
								</td>
								
								<td>
									<i class="ace-icon fa fa-users green bigger-110"></i>
									<span class="bigger-100">{{todo.gnumber}}</span>
								</td>
								
								<td>  
									<span v-if=(todo.recordstate)==1 class="label label-lg label-warning arrowed-in arrowed-in-right">待结算</span>
									<span v-if=(todo.recordstate)==0 class="label label-lg label-success arrowed arrowed-right">已结算</span>
								</td>
								<td v-if=(todo.recordstate)==1>
 									<button class="btn btn-xs btn-primary" v-on:click="showModal(''+todo.chargeid, index, todo.recordstate)">
										<i class="ace-icon fa fa-pencil bigger-110"></i>
										<span class="bigger-100">结算</span>
									</button>
								</td>
 								<td v-if=(todo.recordstate)==0>
									<button class="btn btn-xs btn-primary" v-on:click="showModal(''+todo.chargeid, index, todo.recordstate)">
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
						<li v-for="todo in pageCount" v-bind:class="{active:todo==currentPage}" v-on:click="pageItem(todo)"><a>{{todo}}</a></li>
						<li v-on:click=(pageItem(currentPage+1))><a href="#">&raquo;</a></li>	
					</ul>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
		
		 <div id="settle-modal" class="modal fade in" tabindex="-1" style="display: none; padding-right: 17px;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 class="smaller lighter blue no-margin">结算详情</h3>
					</div>

					<div class="modal-body no-padding"> 
						<table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
							<thead>
								<tr>
									<th>公司名称</th>
									<th>公司账户</th>
									<th>员工名称</th>
									<th>检查状态</th>
									<th>导检表号码</th>
									<th>总价格</th>
								</tr>
							</thead>
							<tbody>
								<tr class="" v-for="(td, index) in rdObj">
									<th>{{td.companyname}}</th>
									<th>{{td.companyacc}}</th>
									<th>
										<i class="ace-icon fa fa-user green bigger-120"></i>
										<span class="bigger-100">{{td.pname}}</span>
									</th>

									<th>
										<span v-if="(td.recordstate)==1" class="label label-lg label-warning">
											<i class="ace-icon fa fa-exclamation-triangle bigger-120"></i>
											未体检
										</span>
										<span v-if="(td.recordstate)==0" class="label label-lg label-success">
											<i class="ace-icon fa fa-check-square-o bigger-120"></i>
											已体检
										</span>
									</th>
									<th>{{td.guideid}}</th>
									<th> 
										<span class="label label-lg label-success label-white middle">
											<i class="ace-icon glyphicon glyphicon-yen bigger-120"></i>
											{{td.totalprice}}
										</span>
									</th>
								</tr> 
							</tbody>
						</table>
					</div>	
											
					<div class="modal-footer no-margin-top">
						<button v-if="billState==1" type="button" class="btn btn-sm btn-primary pull-left" v-on:click="billCheck()" >
							<i class="ace-icon glyphicon glyphicon-ok bigger-120"></i>
							结算
						</button>
						<button v-if="billState==0" type="button" class="btn btn-sm btn-danger pull-left" data-dismiss="modal" >
							<i class="ace-icon glyphicon glyphicon-remove bigger-120"></i>
							关闭
						</button>  
						
						<ul class="pagination pull-right no-margin">
							<li v-on:click="(pageItem2(currentPage-1))"><a href="#">&laquo;</a></li>
							<li v-for="todo in detailCount" v-bind:class="{active:todo==currentPage}" v-on:click="(pageItem(todo))"><a>{{todo}}</a></li>
							<li v-on:click="(pageItem2(currentPage+1))"><a href="#">&raquo;</a></li>	
						</ul> 
					</div>
				</div>
			</div>
		</div>	
	</div> 
	
<%@include file="footer.jsp"%>
<script src="<%=request.getContextPath()%>/js/settleAccount.js"></script>
</body>
</html>