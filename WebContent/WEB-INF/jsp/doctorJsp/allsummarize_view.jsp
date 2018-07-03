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
<title>总结窗口</title>
<%@ include file="header.jsp"%>
<style type="text/css">
/*输入框提示语设置  */
#search_div .error,#submit_form .error{
	
  color: #FF5722;  
}

</style>
</head>
<body class="no-skin">
<%@ include file="menu.jsp"%>

<div class="main-content"><!-- 主内容开始 -->

	<div class="breadcrumbs" id="breadcrumbs"><!-- 面包屑开始 -->
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="toIndex.action">首页</a></li>
						<li>体检小结</li>
					<li class="active">体检小结</li>
					</ul>

					<!-- /.breadcrumb -->
		</div>	<!-- 面包屑结束 -->
<div class="page-content" id="showview_div" ><!--主内容开始  -->
<div class="page-header"><!--页头开始  -->
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
						<input type="text"  class="form-control search-query" name="guide_id"  v-model="guide_id"  id="guide_id" placeholder="输入卡号" autocomplete="off" required/>
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


</div><!--页头结束  -->
<div class="page-body"><!--页面体开始  -->
<div class="row"  id="show_items_div">
		<div class="col-xs-12">
		<div class="table-header">
		体检者体检项目明细如下：
		</div>
	<table id="grid-table" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
				<th width="5%">序号</th>
				<th width="25%">体检项目名称</th>
				<th width="15%">科室名称</th>
				<th width="25%">本项目所需金额</th>
				<th width="30%">操 作</th>	
							
				</tr>
			</thead> 
			
			<tbody  >
				<tr class="" v-for="(todo, index) in itemsList">
				
					<td>
					<a href="#">{{index+1}}</a>
					</td>	
								
					<td >{{todo.itemname}}</td>
					<td >{{todo.deptname}}</td>
					<td >{{todo.cost}}</td>	
					<td >
					<!--未接收  -->
				<div class="hidden-sm hidden-xs action-buttons"  v-if=(todo.examtime)==null>
					
															
				<button class="btn btn-success  btn-sm  apt_btn"  >
				<span class="ace-icon fa fa-search-plus bigger-130"></span>
				待接收</button>																																					
			    </div>	
			    
			    
			    
			    
			    <!--已接收未小结  -->
			    <div class="hidden-sm hidden-xs action-buttons"  v-if=(todo.examtime)!=null&&(todo.summary)==null>
					
															
				<button class="btn btn-default  btn-sm  apt_btn"   >
				<span class="glyphicon glyphicon-ok"></span>
				已接收</button>	
				<button class="btn btn-success  btn-sm  apt_btn"  >
				<span class="glyphicon glyphicon-pencil"></span>
				未小结</button>																																				
			    </div>
			    
			    
					<!--已接收已小结  -->
				<div class="hidden-sm hidden-xs action-buttons" v-if=(todo.examtime)!=null&&(todo.summary)!=null>
												
				<button class="btn btn-default  btn-sm  apt_btn"   >
				<span class="glyphicon glyphicon-ok"></span>
				已接收</button>		
				<button class="btn btn-success  btn-sm  apt_btn"  >
				<span class="glyphicon glyphicon-ok-circle"></span>
				已小结</button>			
							
							
																																		
				</div>	
														
					</td>		
		
					</tr>
				    </tbody>
					<tbody v-if="itemsList.length<1">
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
					</ul>  --%>
								<!-- PAGE CONTENT ENDS -->
					</div><!-- /.col -->
					</div><!-- /.row -->


</div><!--页面体结束  -->
<br>
<div class="page-footer"  id="page_footer"><!--页面底部开始  -->
<form action="" id="submit_form">

<div class="row" >
		<div class="col-xs-12">
	
		<div class="table-header">
		体检总结：
		</div>
			<br>
	<textarea rows="6" cols="100" id="description_text"
		name="description_text"  v-model="descriptionText" placeholder="请输入..." required>

	</textarea>

		</div>
		</div>
		<br>
		<div class="row">
		<div class="col-xs-3">
		<h4>医生签名：</h4>
			<!-- 待添加登录信息到session里的时候操作 -->
		<input type="text" id="doctorname" name="doctorname" v-model="docName"
			class="form-control" placeholder="医生姓名" autocomplete="off"
					required />
		</div>
		</div>
		<br>
		<div class="row">
		<div class="col-xs-4">
		
			<button type="submit" class="btn btn-primary"  >提交</button>
		</div>
		</div>
	</form>
<br>	
</div>




</div><!--主内容结束  -->








</div><!-- 主内容结束 -->









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
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
<%@ include file="footer.jsp"%>
<script type="text/javascript">
$(function(){
	$("a[href='allSummary.action']").parent().parent().parent().addClass("active");
	$("a[href='allSummary.action']").parent().parent().parent().addClass("open");
	$("a[href='allSummary.action']").parent().addClass("active");	
	$("#message_div").hide();
	$("#person_div").hide();
	$("#hr_div").hide();
	$("#show_items_div").hide();
	$("#page_footer").hide();
});
</script>
<script type="text/javascript"  src=<%=path+"/jscommon/allsummarize_view.js" %>></script>
</body>
</html>