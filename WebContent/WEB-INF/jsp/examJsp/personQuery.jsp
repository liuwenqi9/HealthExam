<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体检人员综合查询</title>
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
				<li class="active">体检人员查询</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<!-- 页头 -->
			<div class="page-header">
				<form class="form-inline">
					<a href="#" class="btn btn-sm btn-primary" v-on:click="searchItem"><i
						class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
					<div class="form-group">
						<input type="text"  placeholder="体检人姓名" class="form-control" v-model="searchModel.name">
						<input type="text" placeholder="手机号码" class="form-control" v-model="searchModel.phone"> 
						<input type="text" placeholder="条码号" class="form-control" v-model="searchModel.barcode">
					</div>
					
					<div class="pull-right">					
						<div class="input-group input-group-md">
							<span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
							<input type="date" v-model="searchModel.startTime" class="form-control hasDatepicker">
						</div>
						至
						<div class="input-group input-group-md">
							<input type="date" v-model="searchModel.endTime" class="form-control hasDatepicker">
							<span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
						</div>
					</div>
				</form>
			</div>

			<div class="row">
				<div class="col-xs-12">
 					<div class="pull-right ">
 						<a class="dt-button buttons-print btn btn-white btn-primary btn-bold" tabindex="0" id="excelBtn" v-on:click="exportExcel">
							<span><i class="fa fa-print bigger-110 grey"></i></span>
						</a> 
					</div>
					<table id="dynamic-table" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><label class="pos-rel">序号 </label></th>
								<th>体检人</th>
								<th>联系电话</th>
								<th>所属账户</th>
								<th>条码号</th>
								<th>办理次数</th><%--1表示已接收，0表示已完成，3表示已结款 --%>
								<th>详情</th>
							</tr>
						</thead>
						<tbody>
							<tr class="" v-for="(todo, index) in ppList">
								<td class="center">{{index+1}}</td>
								<td>
									<i class="ace-icon fa fa-user green bigger-120"></i> 
									<span class="bigger-100">{{todo.name}}</span>					
								</td>
								
								<td>
									<i class="ace-icon glyphicon glyphicon-earphone blue bigger-120"></i>
									<span class="bigger-100">{{todo.telephone}}</span>
								</td>
								
								<td>
									<i class="ace-icon fa fa-bookmark blue bigger-120"></i>
									<span class="bigger-100">{{todo.account}}</span>
								</td>
								
								<td>
									<i class="ace-icon fa fa-barcode grey bigger-120"></i> 
									<span class="bigger-100">{{todo.barcode}}</span></td>
								<td>
									<i class="ace-icon fa fa-credit-card red bigger-120"></i>
									<span class="bigger-100">{{todo.guideidCard}}</span></td>
								<td>
									<button class="btn btn-xs btn-primary" v-on:click="showModal(''+todo.name, index)">
										<i class="ace-icon glyphicon glyphicon-tag"></i> 
										<span class="bigger-100">详情</span>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- 分页  -->
					<ul class="pagination">
						<li v-on:click="pageItem(currentPage-1)"><a href="#">&laquo;</a></li>
						<li v-for="todo in pageCount" v-bind:class="{active:todo==currentPage}" v-on:click="pageItem(todo)"><a>{{todo}}</a></li>
						<li v-on:click="pageItem(currentPage+1)"><a href="#">&raquo;</a></li>
					</ul>
				</div>
				
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
		<div id="people-modal" class="modal fade in" tabindex="-1" style="display: none; padding-right: 17px;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 class="smaller lighter blue no-margin">体检人：{{currentName}}</h3>
					</div>
					
					<div class="modal-body no-padding"> 
						<table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">
							<thead>
								<tr>
									<th>导捡号</th>
									<th>总价格</th>
									<th>检查状态</th>
									<th>体检总结</th>
									<th>套餐</th>
								</tr>
							</thead>
							<tbody>
								<tr class="" v-for="(td, index) in ppObj">
									<td>
										<i class="ace-icon fa fa-barcode grey bigger-120"></i> 
										<span class="bigger-100">{{td.guideid}}</span>
									</td>
									
									<td>
										<span class="label label-success label-white middle">
											<i class="ace-icon glyphicon glyphicon-yen green bigger-120"></i> 
											{{td.totalprice}}
										</span>
									</td>
									
									<td>
										<span v-if="(td.checkstate)==1" class="label label-warning">
											<i class="ace-icon fa fa-exclamation-triangle bigger-120"></i> 
											未检查
										</span>
										<span v-if="(td.checkstate)==0" class="label label-success">
											<i class="ace-icon fa fa-check-square-o bigger-120"></i> 
											已检查
										</span>
										<span v-if="(td.checkstate)==2" class="label label-danger">
											<i class="ace-icon fa fa-ban bigger-120"></i> 
											已过期
										</span>
									</td>
									
									<td>
										<i class="ace-icon fa fa-pencil-square-o blue bigger-120"></i> 
										<span v-if="(td.allsummary)==null" class="bigger-100">暂无</span>
										<span v-if="(td.allsummary)!=null" class="bigger-100">{{td.allsummary}}</span>
									</td>
									
									<td>
										<i class="ace-icon fa  fa-heart red bigger-120"></i> 
										<span class="bigger-100">{{td.totalPackages}}</span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="modal-footer no-margin-top">
						<button  type="button" class="btn btn-sm btn-danger pull-left" data-dismiss="modal" >
							<i class="ace-icon glyphicon glyphicon-remove bigger-120"></i>关闭
						</button>
						
						<ul class="pagination pull-right no-margin">
							<li v-on:click=""><a href="#">&laquo;</a></li>
							<li v-for="todo in detailCount" v-bind:class="{active:todo==currentPage}" v-on:click=""><a>{{todo}}</a></li>
							<li v-on:click=""><a href="#">&raquo;</a></li>	
						</ul>  
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- /.main-content -->
	<%@include file="footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/exampeople.js"></script>	
</body>
</html>