<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"
	+request.getServerName()+":"+request.getServerPort()
	+path+"/";
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生接收项目窗口</title>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href=<%=path+"/css/jquery.dataTables.css" %>>
<link rel="stylesheet" type="text/css" href=<%=path+"/css/buttons.dataTables.min.css" %>>
<style type="text/css">
/*输入框提示语设置  */
#search_div .error, #message_h3{
	
  color: #FF5722;  
}

</style> 
</head>
<body class="no-skin">
<%@ include file="menu.jsp"%>
<!-- 内容开始 -->
<div class="main-content">
<!--面包线开始  -->
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
				<li>上传建档</li>
					<li class="active">上传名单</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<!--面包线结束  -->
	<div class="page-content" id="showview_div">
				<div class="row">
				<div class="col-xs-12">
							<!--需要的开始-->
				<div class="widget-box">
				<div class="widget-header widget-header-small">
				<h5 class="widget-title lighter">读取体检导诊卡号：</h5>
				</div>
				
				<div class="widget-body">
					<div class="widget-main">
					<form class="form-search" id="search_form" >
					<div class="row" id="search_div">
						<!--第一行查询卡开始  -->
					<div class="col-xs-9 col-sm-5" >
					<div class="input-group input-group-lg " >										
						<input type="text"  class="form-control search-query" name="guide_id" id="guide_id" placeholder="输入卡号" autocomplete="off" required/>
						<span class="input-group-btn">
						<button type="submit" class="btn btn-purple btn-lg">
						<span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
							读卡
						</button>
						</span>
					</div>
					
					</div>
					 </div>
						<!--第一行查询卡结束  -->
					<!--第二行用户信息显示开始  -->
				<div class="row">
				<div class="col-xs-12 col-sm-12" > 
					<div class="hr"></div>
					<!-- 提示信息 -->
					<div id="message_div"> <h3 class="lighter" id="message_h3">{{promptmessage}}</h3>     </div>
					<div id="person_div">	
						<h2 >用户信息：</h2>		
						<h3 class="lighter"> 公司账号:&nbsp;{{person.account}} &nbsp;姓名:&nbsp;{{person.name}} &nbsp;性别:&nbsp;{{person.sex}}&nbsp;年龄:&nbsp;{{person.age}}</h3>
						
						<h3 class="lighter"> &nbsp;联系号码:&nbsp;{{person.telephone}} &nbsp; 身份证号:&nbsp;{{person.identity}}</h3>
						<!--11.14  -->	
					</div>
						<div id="hr_div"   class="hr"></div>
						<!--体检项目表格  -->
							
					<!-- 结束 -->	
				</div>
			</div> 
				<!--第二行用户信息显示结束  -->
			</form>
			
		</div>
		</div>
		</div>
						<!--需要的结束-->
		</div>				
		</div>
		<!-- 第一行结束 -->
			<div class="row" >
			<div class="col-xs-12" id="show_items_div" >
				 <h3 class="header smaller lighter blue">体检信息显示：</h3> 
					<!--打印按钮位置-->
						<!-- <div class="clearfix">
							<div class=" inline-block"><label class=control-label >打印按钮</label></div> 
							
							 <div class="pull-right  tableTools-container"></div> 
							</div> -->
						<!--打印-->
								<div class="table-header">
									体检者体检项目明细如下：
										</div>

										<!-- div.table-responsive -->

										<!-- div.dataTables_borderWrap -->
										<div>
											<table id="dynamic-table" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<!-- <th class="center">
													 	<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label> 
														</th> -->
													
														<th>序号</th>
														<th>体检项目名称</th>
														<th class="hidden-480">科室ID号</th>

							
														<th class="hidden-480">本项目所需金额</th>

														<th>操 作</th>
													</tr>
												</thead>

												<tbody>
													<!--第一行数据开始-->

										<tr class="" v-for="(todo, index) in itemsList">
										
										<td>
										<a href="#">{{index+1}}</a>
										</td>	
								
										<td >{{todo.itemname}}</td>
										<td >{{todo.deptname}}</td>
										<td >{{todo.cost}}</td>
									
								<td >
								<div class="hidden-sm hidden-xs action-buttons"  v-if=(todo.examtime)==null>
									<!-- 判断时间是否为空 -->	
															
									<button class="btn btn-success  btn-sm  apt_btn"  v-on:click="showModal(''+todo.itemname,todo.itemid,todo.guideitemid)">
									<span class="ace-icon fa fa-search-plus bigger-130"></span>
									接收</button>	
										
																											
									</div>	
									<div class="hidden-sm hidden-xs action-buttons" v-else=(todo.examtime)!=null>
									
															
									<button class="btn btn-default  btn-sm  apt_btn"   >
									<span class="glyphicon glyphicon-ok"></span>
									已接收</button>	
									<button class="btn btn-info  btn-sm  " v-on:click="showModal2(''+todo.itemid,todo.guideitemid)" >
									<span class="glyphicon glyphicon-pencil"></span>
									体检小结</button>	
																											
									</div>	
									
																					
									</td>	
															
								</tr>		
							<!--第一行数据结束-->													
											
								</tbody>
								<!--假数据结束-->
											</table>
										</div>
									</div>
								</div>
								<!--需要的表格内容结束-->	
<!-- 接收项目模态框开始1 -->
	 <div id="accept-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form id="read-form" role="form" >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">体检项目：</h3>
						</div>

						<div class="modal-body" > 
							<div class="row">
								<div class="col-xs-12">
								<h4>是否接收？</h4>
								<h4 id="item_h4">&nbsp;</h4>
								</div>
							</div>
							<div class="hr hr-14 hr-dotted"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  v-on:click="hideModal">接收</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
	<!-- 接收项目模态框结束 -->
	<!-- 接收项目模态框开始2 -->
	<div id="summary-modal" class="modal fade in" tabindex="-1" style="display: none;">
		 	<form  role="form"  id="summary_form"  >
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 class="smaller lighter blue no-margin">体检小结：</h3>
						</div>

						<div class="modal-body" > 
					
							<div class="row">
								<div class="col-xs-12">
								<h4>描述：</h4>
<textarea rows="6" cols="50" id="description_text" name="description_text"  maxlength="300"  placeholder="请输入...">
根据体检结果 ,
							
							
建议：
   多吃水果，多锻炼，愉悦身心。
		</textarea>
						
								</div>
								</div>
								<div class="row">
								<div class="col-xs-4">
										<h4>医生签名：</h4>
										<!-- 待添加登录信息到session里的时候操作 -->
							<input type="text" id="doctorname"  name="doctorname" class="form-control" placeholder="医生姓名" autocomplete="off" required/>
								
								</div>
								
								</div>
			
							
							
							<div class="hr hr-14 hr-dotted"></div>
							
						</div>
					<div class="modal-footer">
							<button type="button" class="btn btn-primary"  v-on:click="summaryUp">提交</button>
					</div>
					
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</form>
		</div>
	<!-- 接收项目模态框结束2 -->
	
	
	
	</div>
</div>
<!--内容结束  -->
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
	<!--外联JS链接  -->
	<%@ include file="footer.jsp"%>
	<script type="text/javascript"  src=<%=path+"/js/jquery.dataTables.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/jquery.dataTables.bootstrap.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/dataTables.buttons.min.js" %>></script>	
	<script type="text/javascript" src=<%=path+"/js/jszip.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/buttons.print.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/dataTables.select.min.js" %>></script>	
	
<script type="text/javascript">
if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");

jQuery(function($) {
	
	var myTable = 
	$('#dynamic-table')

	.DataTable( {
			language: {  
  "sProcessing": "处理中...",  
  "sLengthMenu": "显示 _MENU_ 项结果",  
  "sZeroRecords": "没有匹配结果",  
  "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",  
  "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",  
  "sInfoFiltered": "(由 _MAX_ 项结果过滤)",  
  "sInfoPostFix": "",  
  "sSearch": "搜索:",  
  "sUrl": "",  
  "sEmptyTable": "表中数据为空",  
  "sLoadingRecords": "载入中...",  
  "sInfoThousands": ",",  
  "oPaginate": {  
      "sFirst": "首页",  
      "sPrevious": "上页",  
      "sNext": "下页",  
      "sLast": "末页"  
  },  
  "oAria": {  
      "sSortAscending": ": 以升序排列此列",  
      "sSortDescending": ": 以降序排列此列"  
  }  
},	
		"searching" : false, //去掉搜索框方法一
		"bSort": false,  //禁止排序
		bAutoWidth: false,
		"aoColumns": [
		  { "bSortable": false },
		  null, null,null, 
		  { "bSortable": false }
		],
		"aaSorting": [],
		select: {
			style: 'multi'
		}
    } );

	
	$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
	
	/* new $.fn.dataTable.Buttons( myTable, {
		buttons: [
		
		  {
			extend: "print",
				title: '体检项目表',
			text: "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>打印</span>",
			className: "btn btn-white btn-primary btn-bold",
			autoPrint: true,
			message: '传一人民医院体检项目明细'
		  }		  
		]
	} );
	myTable.buttons().container().appendTo( $('.tableTools-container') ); */
	

	
//延迟
	/* setTimeout(function() {
		$($('.tableTools-container')).find('a.dt-button').each(function() {
			var div = $(this).find(' > div').first();
			if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
			else $(this).tooltip({container: 'body', title: $(this).text()});
		});
	}, 500); */
	
	
	
	
	/* //	全选、全不选
	myTable.on( 'select', function ( e, dt, type, index ) {
		if ( type === 'row' ) {
			$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
		}
	} );
	myTable.on( 'deselect', function ( e, dt, type, index ) {
		if ( type === 'row' ) {
			$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
		}
	} );



//复选框选择
	/////////////////////////////////
	//table checkboxes
	$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);
	
	//select/deselect all rows according to table header checkbox
	$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
		var th_checked = this.checked;//checkbox inside "TH" table header
		
		$('#dynamic-table').find('tbody > tr').each(function(){
			var row = this;
			if(th_checked) myTable.row(row).select();
			else  myTable.row(row).deselect();
		});
	});
	
	//select/deselect a row when the checkbox is checked/unchecked
	$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
		var row = $(this).closest('tr').get(0);
		if(this.checked) myTable.row(row).deselect();
		else myTable.row(row).select();
	});
 */


/* 	$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
		e.stopImmediatePropagation();
		e.stopPropagation();
		e.preventDefault();
	});  */
});
</script>
<script type="text/javascript"  src=<%=path+"/jscommon/receive_items.js" %>></script>

</body>
</html>