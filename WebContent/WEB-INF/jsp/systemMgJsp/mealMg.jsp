<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
		<title>套餐配置</title>

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
					<li class="active">套餐配置</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<div class="page-content" id="dataBind">
					<div class="page-header">
						<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
						<a href="#" class="btn btn-sm btn-success" v-on:click="addButton"><i class="glyphicon glyphicon-plus bigger-110"></i>新增套餐</a>
						<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
						
						<div class="pull-right">
							<form class="form-inline">
							  <div class="form-group">
							    <input type="text" placeholder="套餐名称" class="form-control" v-model="S_itemName">
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
											<th width="40%">
												套餐名称
											</th>
											<th width="40%">
												套餐价格
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
												<span>{{todo.packname}}</span>
											 </td>
											 <td>
												<span>{{todo.price}}</span>
											 </td>
											<td>
												<div class="btn-group">
													    
													<button class="btn btn-xs btn-success" title="配置" v-on:click="editButton(todo)">
														配置
													</button>
													
													<button class="btn btn-xs btn-danger" title="删除" v-on:click="deleteItem(todo.packageid,index)">
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
										<h3 class="smaller lighter blue no-margin">添加套餐</h3>
									</div>
									
									<div class="modal-body" style="height: 300px"> 
										<div class="row">
											<div class="col-xs-6">
												<span class="col-xs-4">套餐名称:</span>
												<input class="col-xs-8" type="text" id="packname" name="packname" v-model="addItem.packname" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">套餐价格:</span>
												<input class="col-xs-8" type="text" id="price" name="price" v-model="addItem.price" required="required"/>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-12">
												<span class="col-xs-2">套餐详情:</span>
												<input class="col-xs-10" type="text" id="packdetail" name="packdetail" v-model="addItem.packdetail" required="required"/>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-4" v-for="todo in detailList">
                                            	<input type="checkbox" v-bind:value="todo.itemid" v-bind:checked="todo.checked" v-on:click="todo.checked = !todo.checked" />{{todo.itemname}}
                                            </div>
										</div>
									</div>
									
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" v-on:click="insertBtn()">添加</button>
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
												<span class="col-xs-4">套餐名称:</span>
												<input class="col-xs-8" type="text" id="packname" name="packname" v-model="editItem.packname" required="required"/>
											</div>
											<div class="col-xs-6">
												<span class="col-xs-4">套餐价格:</span>
												<input class="col-xs-8" type="text" id="price" name="price" v-model="editItem.price" required="required"/>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-12">
												<span class="col-xs-2">套餐详情:</span>
												<input class="col-xs-10" type="text" id="packdetail" name="packdetail" v-model="editItem.packdetail" required="required"/>
											</div>
										</div>
										<div class="hr hr-14 hr-dotted"></div>
										<div class="row">
											<div class="col-xs-4" v-for="todo in detailList">
                                            	<input type="checkbox" v-bind:value="todo.itemid" v-bind:checked="todo.checked" v-on:click="todo.checked = !todo.checked" />{{todo.itemname}}
                                            </div>
										</div>
									</div>
									
									<div class="modal-footer">
										<button type="button" class="btn btn-primary" v-on:click="updateBtn()">修改</button>
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
			$("a[href='mealMg.action']").parent().parent().parent().addClass("active");
			$("a[href='mealMg.action']").parent().parent().parent().addClass("open");
			$("a[href='mealMg.action']").parent().addClass("active");
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
				deleteItem:function(packageid,index){
					if(window.confirm("确定要删除吗？")){
						$.ajax({
							url: "packMgDelete.action",
							method: "POST",
							data: { packageid: packageid },
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
						url: "packSelectItemList.action",
						method: "POST",
						data: { packid: item.packageid },
						dataType: "json",
						success: function(msg){
							req.itemDetailList = msg.itemDetailList;
							for(var i=0;i<req.detailList.length;i++){
								req.detailList[i].checked = false;
								for(var j=0;j<req.itemDetailList.length;j++){
									if(req.detailList[i].itemid == req.itemDetailList[j].itemid){
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
				updateBtn:function(){
					var send = {item:req.editItem ,detailList:req.detailList};
					 $.ajax({
						url: "packMgUpdate.action",
						method: "POST",
						data: {send: JSON.stringify(send)},
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
				insertBtn:function(){
					var send = {item:req.addItem ,detailList:req.detailList};
					$.ajax({
						url: "packMgInsert.action",
						method: "POST",
						data: {send: JSON.stringify(send)},
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
				pageItem:function(index){
					 $.ajax({
							url: "packMgPage.action",
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
			url: "packMgPage.action",
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
