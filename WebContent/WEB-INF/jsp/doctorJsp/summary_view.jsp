<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体检小结</title>
<%@ include file="header.jsp"%>
<style type="text/css">
/*输入框提示语设置  */
.modal-body .error {
	color: #FF5722;
}
</style>
</head>
<body class="no-skin">
	<%@ include file="menu.jsp"%>
	<!-- 主内容开始 -->
	<div class="main-content">
		<!-- 面包屑开始 -->
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a
					href="toIndex.action">首页</a></li>
				<li>体检小结</li>
				<li class="active">体检小结</li>
			</ul>

			<!-- /.breadcrumb -->
		</div>
		<!-- 面包屑结束 -->
		<div class="page-content" id="datapart">
			<div class="page-header">
				<!--页头开始  -->
				<div class="table-header">所有已接收的项目如下：</div>
			</div>
			<!--页头结束  -->

			<div class="page-body">
				<!--页面体开始  -->
				<div class="row" id="show_items_div">
					<div class="col-xs-12">

						<table id="grid-table"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th width="5%">序号</th>
									<th width="25%">体检项目名称</th>
									<th width="15%">科室名称</th>
									<th width="25%">本项目所需金额</th>
									<th width="30%">操 作</th>

								</tr>
							</thead>

							<tbody >
								<tr class="" v-for="(todo, index) in itemsList">

									<td><a href="#">{{index+1}}</a></td>

									<td>{{todo.itemname}}</td>
									<td>{{todo.deptname}}</td>
									<td>{{todo.cost}}</td>
									<td>
										<!-- 普通文字小结 -->
										<div class="hidden-sm hidden-xs action-buttons"
											v-if=(todo.classify)==1>
											<button class="btn btn-info  btn-sm"
												v-on:click="showModal1(''+todo.itemid,todo.guideitemid)">
												<span class="glyphicon glyphicon-pencil"></span> 体检小结1
											</button>

										</div> <!-- 图片小结 -->
										<div class="hidden-sm hidden-xs action-buttons"
											v-if=(todo.classify)==2>
											<button class="btn btn-info  btn-sm"
												v-on:click="showModal2(''+todo.itemid,todo.guideitemid)">
												<span class="glyphicon glyphicon-pencil"></span> 体检小结2
											</button>

										</div> <!-- 细项小结 -->
										<div class="hidden-sm hidden-xs action-buttons"
											v-if=(todo.classify)==3>
											<button class="btn btn-info  btn-sm"
												v-on:click="showModal3(''+todo.itemid,todo.guideitemid)">
												<span class="glyphicon glyphicon-pencil"></span> 体检小结3
											</button>

										</div>
									</td>

								</tr>
							</tbody>
							<tbody v-if="itemsList.length<1">
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
			 <h2 id="workdeptid_h2" > ${sessionScope.WorkerDeptId }</h2> 
			
			
			<!--页面体结束  -->
			<!--普通文字小结开始  -->
			<div id="summary-modal1" class="modal fade in" tabindex="-1"
				style="display: none;">
				<form role="form" id="summary_form1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h3 class="smaller lighter blue no-margin">体检小结：</h3>
							</div>

							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12">
										<h4>描述：</h4>
						<textarea rows="6" cols="50" id="description_text"
		name="description_text"  v-model="descriptionText" placeholder="请输入..." required>

					</textarea>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<h4>医生签名：</h4>
										<!-- 待添加登录信息到session里的时候操作 -->
										<input type="text" id="doctorname" name="doctorname" v-model="docName"
											class="form-control" placeholder="医生姓名" autocomplete="off"
											required />
									</div>
								</div>
								<div class="hr hr-14 hr-dotted"></div>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary"  >提交</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</form>
			</div>
			<!--普通文字小结结束  -->
<!--  图片小结模态框开始 -->
		<div id="summary-modal2" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form  role="form"  id="summary_form2"  >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">体检小结：</h3>
						</div>

						<div class="modal-body" > 
					
							<div class="row">
								<div class="col-xs-12">
								<h4>体检图片：</h4>
								请选择图片:<input type="file" name="files"class="file">
							</div>
							</div>
					
					
					<div class="row">
						<div class="col-xs-12">
						<h4>描述：</h4>
<textarea rows="5" cols="50" id="description_text2" name="description_text2" v-model="descriptionText2"    placeholder="请输入..." required>

</textarea>
						
						</div>
						</div>
						<div class="row">
						<div class="col-xs-4">
						<h4>医生签名：</h4>
					<!-- 待添加登录信息到session里的时候操作 -->
					<input type="text" id="doctorname2"  name="doctorname2" class="form-control"  v-model="docName2"  placeholder="医生姓名" autocomplete="off" required/>
								
						</div>
								
						</div>
	
					<div class="hr hr-14 hr-dotted"></div>
							
						</div>
					<div class="modal-footer">
							<button type="submit" class="btn btn-primary" >提交</button>
					</div>
					
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
	
		<!--  图片小结模态框结束 -->		
		<!--  细项小结模态框开始 -->
			<div id="summary-modal3" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form  role="form"  id="summary_form3"  >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">体检小结：</h3>
						</div>

						<div class="modal-body" > 
					
							<div class="row">
								<div class="col-xs-12">
					<!-- 需添加表格数据 -->
							<table id="grid-table" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th width="20%">
												序号
											</th>
											<th width="20%">
												细项名称
											</th>
											<th width="20%">
												计量单位
											</th>
											<th width="20%">
												测量值
											</th>
											<th width="20%">
												参考值
											</th>
											
										</tr>
									</thead> 
			
									<tbody >
										<tr class="" v-for="(todo, index) in ret">
											 <td>
												<span>{{index+1}}</span>
											 </td>
											 <td>
												<span>{{todo.name}}</span>
											 </td>
											 <td>
												<span>{{todo.paramname}}</span>
											 </td>
											 <td>
												<span>{{todo.detaildata}}</span>
											 </td>
											 <td>
												<span>{{todo.lowlimit}}</span>~
												<span>{{todo.uplimit}}</span>
											 </td>
											
										</tr>
									</tbody>
									<tbody v-if="ret.length<1">
										<tr>
											<td colspan="8"  class="center">没有数据</td>
										</tr>
									</tbody>
									
								</table>
			
								<%-- <ul class="pagination">
								    <li v-on:click="pageItem(pageNum-1)" v-if="pageNum > 1"><a href="#">&laquo;</a></li>
								    <li class="disabled" v-if="pageNum == 1"><a href="#">&laquo;</a></li>
								    <li class="" v-for="todo in pageCount" v-bind:class="{active:todo==pageNum}" v-on:click="pageItem(todo)"><a href="#">{{todo}}</a></li>
								    <li v-on:click="pageItem(pageNum+1)" v-if="pageNum < pageCount.length"><a href="#">&raquo;</a></li>
								    <li class="disabled" v-if="pageNum == pageCount.length"><a href="#">&raquo;</a></li>
								</ul> --%>
								<!-- PAGE CONTENT ENDS -->		
									
							</div><!--  col-->
							</div><!--row  -->
					
					
							<div class="row">
								<div class="col-xs-12">
								<h4>描述：</h4>
<textarea rows="5" cols="50" id="description_text3" name="description_text3"  v-model="descriptionText3"  placeholder="请输入..." required>

</textarea>
				
								</div>
								</div>
								<div class="row">
								<div class="col-xs-4">
										<h4>医生签名：</h4>
										<!-- 待添加登录信息到session里的时候操作 -->
	<input type="text" id="doctorname3"  name="doctorname3" class="form-control" v-model="docName3" placeholder="医生姓名" autocomplete="off" required/>
								
								</div>
								
								</div>
			
							<div class="hr hr-14 hr-dotted"></div>
							
						</div>
					<div class="modal-footer">
							<button type="submit" class="btn btn-primary"  v-on:click="">提交</button>
					</div>
					
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
			<!--  细项小结模态框结束 -->





		</div>
		<!--page-content end  -->
	</div>
	<!--主内容结束 -->
	<!-- 页脚 -->
	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder"></span>
					JSY © 2017 - 2018
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>

	<!-- 页脚结束 -->






	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		$(function() {
			$("a[href='summary.action']").parent().parent().parent().addClass(
					"active");
			$("a[href='summary.action']").parent().parent().parent().addClass(
					"open");
			$("a[href='summary.action']").parent().addClass("active");
		 	$("#workdeptid_h2").hide(); 
		});
	</script>
	<script type="text/javascript"
		src=<%=path + "/jscommon/summary_view.js"%>></script>
</body>
</html>