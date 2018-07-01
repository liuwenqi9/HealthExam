<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
		<title>项目配置</title>

	</head>
	<body class="no-skin">
		<%@ include file="menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="toIndex.action">首页</a></li>
						<li>系统管理</li>
					<li class="active">项目配置</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<div class="page-content" id="dataBind">
					<div class="page-header">
						<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
						<a href="#" class="btn btn-sm btn-success" v-on:click="addButton"><i class="glyphicon glyphicon-plus bigger-110"></i>新增细项</a>
						<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
						
						<div class="pull-right">
							<form class="form-inline">
							  <div class="form-group">
							    <input type="text" placeholder="项目名称" class="form-control" v-model="S_itemName">
							  </div>
							  <a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn" ><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
							</form>	
						</div>
					</div>
					<div class="page-body">
						<div class="row">
							<div class="col-xs-12">
								<table id="grid-table" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="5%">
												序号
											</th>
											<th width="20%">
												项目名称
											</th>
											<th width="20%">
												科室
											</th>
											<th width="20%">
												金额
											</th>
											<th width="20%">
												类别
											</th>
											<th width="15%">
												操作
											</th>
										</tr>
									</thead> 
			
									<tbody >
										<tr class="" v-for="(todo, index) in ret">
											 <td>
												<span>{{index+1}}</span>
											 </td>
											 <td>
												<span>{{todo.itemname}}</span>
											 </td>
											 <td>
												<span>{{todo.deptname}}</span>
											 </td>
											 <td>
												<span>{{todo.cost}}</span>
											 </td>
											 <td>
												<span>{{todo.classify == 1?"常规":todo.classify == 2?"拍片":todo.classify == 3?"血液":"未知"}}</span>
											 </td>
											<td>
											<div class="btn-group">
												    
												<button class="btn btn-xs btn-success" title="配置" v-on:click="editButton(todo)">
													配置
												</button>
												
												<button class="btn btn-xs btn-danger" title="删除" v-on:click="deleteItem(todo.detailid,index)">
													<i class="ace-icon fa fa-trash-o bigger-120"></i>
												</button>
												
											</div>
											</td>
										</tr>
									</tbody>
									<tbody v-if="ret.length<1">
										<tr>
											<td colspan="8"  class="center">没有数据</td>
										</tr>
									</tbody>
									
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
					<!-- add-modal -->
					<div id="add-modal" class="modal fade in" tabindex="-1" style="display: none;">
						<form id="add-form" role="form">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h3 class="smaller lighter blue no-margin">添加项目</h3>
									</div>
									
									<div class="modal-body" style="height: 300px"> 
										<div class="row">
											<div class="col-xs-6">
												<span class="col-xs-4">项目名称:</span>
												<input class="col-xs-8" type="text" id="itemname" name="itemname" v-model="addItem.itemname" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">科室:</span>
												<select class="col-xs-8" v-model="addItem.deptid">
													<option value="">科室</option>
													<option v-for="todo in deptList" v-bind:value="todo.deptid">{{todo.deptname}}</option>
												</select>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-6">
												<span class="col-xs-4">金额:</span>
												<input class="col-xs-8" type="text" id="cost" name="cost" v-model="addItem.cost" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">类别:</span>
												<select class="col-xs-8" v-model="addItem.classify">
													<option value="">科室</option>
													<option value="1">常规</option>
													<option value="2">拍片</option>
													<option value="3">血液</option>
												</select>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-4" v-for="todo in detailList">
                                            	<input type="checkbox" v-bind:value="todo.detailid" v-bind:checked="todo.checked" v-on:click="todo.checked = !todo.checked" />{{todo.name}}
                                            </div>
										</div>
									</div>
									
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" v-on:click="insertBtn(addItem)">添加</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									</div>
								</div><!-- /.modal-content -->
							</div><!-- /.modal-dialog -->
						</form>
					</div><!-- /.edit-modal -->
					
					<!-- edit-modal -->
					<div id="edit-modal" class="modal fade in" tabindex="-1" style="display: none;">
						<form id="edit-form" role="form">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<h3 class="smaller lighter blue no-margin">修改</h3>
									</div>
									
									<div class="modal-body" style="height: 300px"> 
										<div class="row">
											<div class="col-xs-6">
												<span class="col-xs-4">项目名称:</span>
												<input class="col-xs-8" type="text" id="itemname" name="itemname" v-model="editItem.itemname" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">科室:</span>
												<select class="col-xs-8" v-model="editItem.deptid">
													<option value="">科室</option>
													<option v-for="todo in deptList" v-bind:value="todo.deptid">{{todo.deptname}}</option>
												</select>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-6">
												<span class="col-xs-4">金额:</span>
												<input class="col-xs-8" type="text" id="cost" name="cost" v-model="editItem.cost" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">类别:</span>
												<select class="col-xs-8" v-model="editItem.classify">
													<option value="">科室</option>
													<option value="1">常规</option>
													<option value="2">拍片</option>
													<option value="3">血液</option>
												</select>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-4" v-for="todo in detailList">
                                            	<input type="checkbox" v-bind:value="todo.detailid" v-bind:checked="todo.checked" v-on:click="todo.checked = !todo.checked" />{{todo.name}}
                                            </div>
										</div>
									</div>
									
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" v-on:click="updateBtn(editItem)">修改</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									</div>
								</div><!-- /.modal-content -->
							</div><!-- /.modal-dialog -->
						</form>
					</div><!-- /.edit-modal -->
				</div><!-- /.page-content -->

			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							小潘 © 2017 - 2018
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>


		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<%@ include file="footer.jsp"%>
		<script type="text/javascript">
		$(function(){
			$("a[href='itemMg.action']").parent().parent().parent().addClass("active");
			$("a[href='itemMg.action']").parent().parent().parent().addClass("open");
			$("a[href='itemMg.action']").parent().addClass("active");
		});
		var req = new Vue({
			el: '#dataBind',
			data: {
				S_itemName:{},
				ret: [],
				pageCount:[],
				pageNum:"",
				searchModel: {},
				addItem:{},
				editItem:{},
				deptList:[],
				itemDetailList:[],
				detailList:[]
			},
			methods:{
				deleteItem:function(detailid,index){
					if(window.confirm("确定要删除吗？")){
						$.ajax({
							url: "itemMgDelete.action",
							method: "POST",
							data: { detailid: detailid },
							dataType: "json",
							success: function(msg){
								req.ret.splice(index, 1);
							},
							error: function(){
								alert("删除失败");
							}
						});
					}
				},
				editButton:function(item){
					$.ajax({
						url: "itemSelectDetailList.action",
						method: "POST",
						data: { itemid: item.itemid },
						dataType: "json",
						success: function(msg){
							req.itemDetailList = msg.itemDetailList;
							for(var i=0;i<req.detailList.length;i++){
								req.detailList[i].checked = false;
								for(var j=0;j<req.itemDetailList.length;j++){
									if(req.detailList[i].detailid == req.itemDetailList[j].detailid){
										req.detailList[i].checked = true;
										
									}
								}
							}
							req.editItem = item;
							$('#edit-modal').modal('show');
						},
						error: function(){
							alert("获取失败");
						}
					});
				},
				updateBtn:function(detail){
					 $.ajax({
						url: "itemMgUpdate.action",
						method: "POST",
						data: {detailid:detail.detailid,name:detail.name,parameterid:detail.parameterid,lowlimit:detail.lowlimit,uplimit:detail.uplimit},
						dataType: "json",
						success: function(msg){
							alert(msg.status);
							window.location.reload();
						},
						error: function(){
							alert("获取失败");
						}
					 });
				},
				addButton:function(){
					 for(var i=0;i<req.detailList.length;i++){
					 	req.detailList[i].checked = false;
					 }
					$('#add-modal').modal('show');
				},
				insertBtn:function(detail){
					var send = {item:req.addItem ,detailList:req.detailList};
					$.ajax({
						url: "itemMgInsert.action",
						method: "POST",
						data: {send: JSON.stringify(send)},
						dataType: "json",
						success: function(msg){
//							alert(msg.status);
//							window.location.reload();
						},
						error: function(){
							alert("获取失败");
						}
					 });
				},
				pageItem:function(index){
					 $.ajax({
							url: "itemMgPage.action",
							method: "POST",
							data: {page:index,sItemName:req.S_itemName,selectItem:req.selectItem},
							dataType: "json",
							success: function(msg){
								req.ret = msg.req;
								req.pageCount = msg.pageCount;
								req.pageNum = msg.pageNum;
								req.S_itemName = msg.sItemName;
							},
							error: function(){
								alert("获取失败");
							}
					 });
				},
				selectBtn:function(){
					req.selectItem = true;
					req.pageItem(1);
				}
			}
		});
		
		var request = $.ajax({
			url: "itemMgPage.action",
			method: "POST",
			data: {page:1,sItemName:req.S_itemName,selectItem: false},
			dataType: "json",
			success: function(msg){
				req.ret = msg.req;
				req.pageCount = msg.pageCount;
				req.pageNum = msg.pageNum;
				req.S_itemName = msg.sItemName;
				req.deptList = msg.deptList;
				req.selectItem = false; 
				req.detailList = msg.detailList;
			},
			error: function(){
				alert("获取失败");
			}
		})
		</script>
</html>
