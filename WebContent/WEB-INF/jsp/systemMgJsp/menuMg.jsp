<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>菜单管理</title>
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
						<li class="active">系统管理</li><li>菜单管理</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>

				<%--这里添加代码  --%>
				<div class="page-content" id="dataBind">
					<div class="page-header">
				<a href="javascript:window.location.reload();" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-undo bigger-110"></i>刷新</a>
				<!-- 绑定模态框 -->
				<div id="dialog-form"  class="btn btn-sm btn-success" onclick="$('#edit-modal').modal('show');"><i class="glyphicon glyphicon-plus bigger-110"></i>新增菜单</div>
				<!-- <span class="text-error" data-bind="text:errormsg"></span> -->
				
				<div class="pull-right"><!-- 查询细项 -->
					<form class="form-inline">
					  <div class="form-group">
					    <input type="text" placeholder="菜单名称" class="form-control" v-model="searchModel.S_workerName">
					  </div>
					  <div class="form-group">
					    <select class="form-control" placeholder="菜单级别" v-model="searchModel.S_userStatus"> 
					   		<option value="" selected>菜单级别</option>
					    	<option value="0">一级菜单</option>
					    	<option value="1">二级菜单</option>
					    </select>
					 
					  </div>
					  <a href="#" class="btn btn-sm btn-success" v-on:click="selectBtn" ><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
					</form>	
				</div>
				<div class="row">
				<div class="col-xs-12">
					<table id="grid-table" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								  <th width="5%">
								   	序号
								  </th>
								  <th width="15%">
								   	 菜单名称
								  </th>
								  <th width="30%">
								  	二级菜单路径
								  </th>
								  <th width="25%">
								   	对应以及菜单名称
								  </th>
								  <th width="10%">
								   	状态
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
									<span>{{todo.WORKER_NAME}}</span>
								 </td>
								 <td>
									<span>{{todo.PARAMETER_NAME}}</span>
								 </td>
								 <td>
								 	<span>{{todo.PARAMTER_NO}}}}</span>
								 </td>
								 <td>
								 	<span>{{todo.PARAMTER_state}}}}</span>
								 </td>
								 
								<td>
									<div class="btn-group" style="text-align: center;">
										    
										<button class="btn btn-xs btn-info" title="修改" onclick="$('#update-modal').modal('show');">
											修改
										</button>
										
										
										<button class="btn btn-xs btn-success" title="启用"  value="1" onclick="$('#enable-modal').modal('show');">
											启用
										</button>
										<button class="btn btn-xs btn-danger" title="禁用"  value="0" onclick="$('#disable-modal').modal('show');">
											禁用
										</button>
																									
									</div>
								</td>
							</tr>
						</tbody>
						<tbody v-if="ret.length<1">
							<tr>
								<td colspan="6"  class="center">没有数据</td>
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
								<div class="form-group">
						    	<select class="form-control" title="菜单级别" placeholder="菜单级别" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 15px;"> 
							   		<option value="" selected>菜单级别</option>
							    	<option value="0">一级菜单</option>
							    	<option value="1">二级菜单</option>
						    	</select>
						    	</div>
						    	<label style="margin-left: 15px;font-size: 20px;">菜单名称:</label>
								<br>
								<input type="text" style="margin-left: 15px" class="col-xs-10 col-sm-5" id="form-input-readonly">
								<br><br>
								<label style="margin-left: 15px;font-size: 20px;">菜单路径:</label>
								<br>
								<input type="text" style="margin-left: 15px" class="col-xs-10 col-sm-5" id="form-input-readonly">
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定修改</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					
					<!-- 禁用。。。。。。。 -->
					<div id="disable-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="disable-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">禁用提示</h3>
							</div>

							<div class="modal-body" style="height: 150px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;color: red;">温馨提示！<br><br>您是否要禁用{{菜单名称}}这个菜单?</h2>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定禁用</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
					<!-- 启用。。。。。。 -->
					<div id="enable-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="enable-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">启用提示</h3>
							</div>

							<div class="modal-body" style="height: 150px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;">温馨提示！<br><br>您是否要启用{{菜单名称}}这个菜单?</h2>
								</div>
								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定启用</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
						</div>
						</div><!-- /.modal-content -->
						</form>
					</div><!-- /.modal-dialog -->
						<!-- 删除。。。。。。 -->
					<div id="delete-modal" class="modal fade in" tabindex="-1" style="display: none;">
					<form id="delete-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">删除</h3>
							</div>
							<div class="modal-body" style="height: 250px;"> 
								<div class="row">
									<h2 style="margin-left: 30px;">温馨提示！<br><br>您是否要删除{{本行的姓名}}这位工作人员的<br>所有信息?</h2>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">删除</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
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
		<!-- 增加菜单的模态框  -->
		 <div id="edit-modal" class="modal fade in" tabindex="-1" style="display: none;">
			<form id="edit-form" role="form">
					<div class="modal-dialog" style="margin-top: 220px">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">新增菜单</h3>
							</div>

							<div class="modal-body" style="height: 200px;"> 
								<div class="row">
									<div class="col-xs-6">
										<span class="col-xs-8"><input type="text" title="菜单名称" placeholder="菜单名称" class="form-control"  style="margin-left: 15px;width: 480px;"></span>
									</div>
									<br><br>
									<div class="col-xs-6">
										<span class="col-xs-8"><input type="text" title="二级菜单路径" placeholder="二级菜单路径" class="form-control"  style="margin-left: 15px;width: 480px;"></span>
									</div>
									
								</div>
								<div class="hr hr-14 hr-dotted"></div><!-- 横线，单行 -->
								<div class="row">
									
								<div class="form-group">
						    	<select class="form-control" title="对应一级菜单名称" placeholder="对应一级菜单名称" v-model="searchModel.S_userStatus" style="width: 200px;margin-left: 40px;"> 
							   		<option value="" selected>对应一级菜单名称</option>
							    	<option value="0">xxmenu</option>
							    	<option value="1">yymenu</option>
							    	<option value="3">zzmenu</option>
						    	</select>
						    	</div>
							

								
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" data-dismiss="modal">确定提交</button>
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
			$("a[href='menuMg.action']").parent().parent().parent().addClass("active");
			$("a[href='menuMg.action']").parent().parent().parent().addClass("open");
			$("a[href='menuMg.action']").parent().addClass("active");
		});
		/* //新增人员弹出
		bootbox.setDefaults("locale","zh_CN");  //弹窗设置中文
		bootbox.confirm("投票已结束，是否直接查看投票结果？",function(re){
	 	if(re) {
	       voteResults(id,title); 
	  		}
		});
 */

	
			
		</script>
</html>