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
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
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
						<form class="form-inline">
							<div class="form-group">
								<input type="text" placeholder="账户名称" class="form-control"
									v-model="searchModel.S_cardNum">
							</div>
							<div class="form-group">
								<select class="form-control" v-model="searchModel.S_cardStatus">
									<option value="" selected="selected">账户状态</option>
									<option value="1">启用</option>
									<option value="0">禁用</option>
								</select>
							</div>
							<a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn"><i
								class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
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

									<c:forEach var="account" items="${acList}">
										<tr id="tr_ofAccount">
											<td><c:out value="${account.getState()}"></c:out></td>
											<td><c:out value="${account.getAccount()}"></c:out></td>
											<td><c:out value="${account.getName()}"></c:out></td>
											<td><c:out value="${account.getState()}"></c:out></td>
											<td><c:out value="${account.getAmount()}"></c:out></td>
										</tr>
									</c:forEach>
<!-- 									<tr class="" v-for="(todo, index) in acList"> -->
<!-- 										<td><span>{{index+1}}</span></td> -->
<!-- 										<td><span>{{todo.account}}</span></td> -->
<!-- 										<td><span>{{todo.state==1?"在用状态":todo.state==0?"禁用状态"}}</span></td> -->
<!-- 										<td><span>{{todo.amount}}</span></td> -->
<!-- 										<td> -->
<!-- 											<div class="btn-group"> -->
<!-- 												<button class="btn btn-xs btn-success"> -->
<!-- 													<i class="ace-icon fa fa-check bigger-120"></i> -->
<!-- 												</button> -->
<!-- 												<button class="btn btn-xs btn-info"> -->
<!-- 													<i class="ace-icon fa fa-pencil bigger-120"></i> -->
<!-- 												</button> -->
<!-- 												<button class="btn btn-xs btn-danger"> -->
<!-- 													<i class="ace-icon fa fa-trash-o bigger-120"></i> -->
<!-- 												</button> -->
<!-- 												<button class="btn btn-xs btn-warning"> -->
<!-- 													<i class="ace-icon fa fa-flag bigger-120"></i> -->
<!-- 												</button> -->
<!-- 											</div> -->
<!-- 										</td> -->
<!-- 									</tr> -->
								</tbody>
								<tbody v-if="ret.length<1">
									<tr>
										<td colspan="8" class="center">没有数据</td>
									</tr>
								</tbody>

							</table>

							<ul class="pagination">
								<li v-on:click="pageItem(pageNum-1)" v-if="pageNum > 1"><a
									href="#">&laquo;</a></li>
								<li class="disabled" v-if="pageNum == 1"><a href="#">&laquo;</a></li>
								<li class="" v-for="todo in pageCount"
									v-bind:class="{active:todo==pageNum}"
									v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
								<li v-on:click="pageItem(pageNum+1)"
									v-if="pageNum < pageCount.length"><a href="#">&raquo;</a></li>
								<li class="disabled" v-if="pageNum == pageCount.length"><a
									href="#">&raquo;</a></li>
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
		<div id="edit-modal" class="modal fade in" tabindex="-1"
			style="display: none;">
			<form id="edit-form" role="form">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">查询卡</h3>
						</div>

						<div class="modal-body" style="height: 300px">
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">卡号:</span> <span class="col-xs-8">{{dat.CARD_INFO_PREFIX}}{{dat.CARD_INFO_NUM}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">卡余额:</span> <span class="col-xs-8">{{dat.PATIENT_BALANCE}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">卡状态:</span> <span class="col-xs-8">{{dat.PARAMETER_ID==0?"待领用":dat.PARAMETER_ID==1?"待销售":dat.PARAMETER_ID==2?"已售卡":dat.PARAMETER_ID==3?"已退卡":dat.PARAMETER_ID==4?"已注销":"未知"}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">就诊人:</span> <span class="col-xs-8">{{dat.PATIENT_NAME}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">领用人:</span> <span class="col-xs-8">{{dat.OPTION_PERSON}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">领用时间:</span> <span class="col-xs-8">{{dat.OPTION_TIME}}</span>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
							<div class="row">
								<div class="col-xs-6">
									<span class="col-xs-4">售卡人:</span> <span class="col-xs-8">{{dat.SALE_TIME==null||dat.SALE_TIME==""?"":dat.OPTION_PERSON}}</span>
								</div>
								<div class="col-xs-6">
									<span class="col-xs-4">售卡时间:</span> <span class="col-xs-8">{{dat.SALE_TIME}}</span>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</form>
		</div>
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
	</div>


	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<%@ include file="footer.jsp"%>
	<script>
		$(function(){
			$("a[href='cardQuery.jsp']").parent().parent().parent().addClass("active");
			$("a[href='cardQuery.jsp']").parent().parent().parent().addClass("open");
			$("a[href='cardQuery.jsp']").parent().addClass("active");
		});
		$("#form").validate();

	var modalVue = new Vue({
		el: '#edit-modal',
		data: {
			dat: {}
		},
		methods:{

		}
	});

	var req = new Vue({
		el: '#dataBind',
		data: {
			selectItem:{},
			ret: [],
			pageCount:[],
			pageNum:"",
			searchModel: {}
		},
		methods:{
			detailItem:function(cardid){
				$.ajax({
					url: "<%=request.getContextPath()%>/CardQueryServlet",
					method: "POST",
					data: { cmd : "detail", cardid : cardid},
					dataType: "html",
					success: function(msg){
						modalVue.dat = JSON.parse(msg).dat;
						$('#edit-modal').modal('show');
					},
					error: function(){
						alert("获取失败");
					}
				});
			},
			addClick:function(){
				$('#my-modal').modal('show');
			},
			pageItem:function(index){
				 $.ajax({
						url: "<%=request.getContextPath()%>/CardQueryServlet",
						method: "POST",
						data: {page:index,searchItem:JSON.stringify(req.searchModel),selectItem:req.selectItem},
						dataType: "html",
						success: function(msg){
							/* pageData = JSON.parse(msg); */
							req.ret = JSON.parse(msg).req;
							req.pageCount = JSON.parse(msg).pageCount;
							req.pageNum = JSON.parse(msg).pageNum;
							req.searchModel = JSON.parse(msg).searchItem;
						},
						error: function(){
							alert("获取失败");
						}
				 });
			},
			selectBtn:function(){

				if (req.searchModel.S_beginDate != "") {
					if(req.searchModel.S_endDate == ""){
						alert("请填写结束时间");
						return;
					}
				}
				if (req.searchModel.S_beginDate != "") {
					if(req.searchModel.S_endDate == ""){
						alert("请填写开始时间");
						return;
					}
				}
				req.selectItem = true;
				req.pageItem(1);
			}
		}
	});

	var request = $.ajax({
		url: "<%=request.getContextPath()%>
		/CardQueryServlet",
			method : "POST",
			data : {
				page : 1,
				searchItem : JSON.stringify(req.searchModel),
				selectItem : false
			},
			dataType : "html",
			success : function(msg) {
				/* pageData = JSON.parse(msg); */
				req.ret = JSON.parse(msg).req;
				req.pageCount = JSON.parse(msg).pageCount;
				req.pageNum = JSON.parse(msg).pageNum;
				req.searchModel = JSON.parse(msg).searchItem;
				req.selectItem = false;
			},
			error : function() {
				alert("获取失败");
			}
		})
	</script>
</body>
</html>
