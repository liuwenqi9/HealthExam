<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<script src="http://localhost:18000/CLodopfuncs.js?priority=0"></script>
<script src="http://localhost:8000/CLodopfuncs.js?priority=1"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>体检报告打印</title>
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
				<li class="active">体检报告打印</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		
		<div class="page-content">
			<div class="page-header">
				<form class="form-inline">
					<a href="#" class="btn btn-sm btn-primary" v-on:click="checkGuide"><i class="glyphicon  glyphicon-search bigger-110"></i>查询</a>
					
					<div class="form-group">
						<input type="text"  placeholder="导检号" class="form-control" v-model="guideCode">
					</div>
					<div class="pull-right">			
						<a class="dt-button buttons-print btn btn-white btn-primary btn-bold" tabindex="0" v-on:click="CheckIsInstall">
							<span><i class="fa fa-print bigger-110 grey"></i></span>
						</a> 
					</div>
				</form>				
			</div>
			
			<div class="row">
				<div class="col-xs-12">
					<table id="dynamic-table" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>体检人</th>
								<th>性别</th>
								<th>年龄</th>
								<th>联系电话</th>
								<th>所属账户</th>
							</tr>
						</thead>
						<tbody>
							<tr v-if="peopleMsg!=''" class="">
								<td>{{peopleMsg.name}}</td>
								<td>{{peopleMsg.sex}}</td>
								<td>{{peopleMsg.age}}</td>
								<td>{{peopleMsg.telephone}}</td>
								<td>{{peopleMsg.account}}</td>
							</tr>
						</tbody>
					</table>
					<div class="hidden" id="pplItems">
						<table class="hidden" style="width: 100%;" border="0" cellpadding="0" cellspacing="0">
							<thead>
								<tr>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;"><label>序号 </label></th>
						 			<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">科室</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">项目</th>
								</tr>
							</thead>
							<tbody>
								<tr class="" v-for="(todo, index) in itemList">
									<th style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{index+1}}</th>
									<th style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{todo.deptname}}</th>
									<th style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{todo.itemname}}</th>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="" v-for="(ttd,index) in detailList" v-bind:id="index">
						<div class="hidden">	
				 		 <p>{{ttd.itemName}}</p>
						</div>
						<table class="hidden" style="width: 100%;" border="0" cellpadding="0" cellspacing="0" bgcolor="#DCDCDC">
							<thead>						
								<tr>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;"></th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">细项</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">单位</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">上限值</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">下限值</th>
								</tr>
							</thead>
							<tbody>
								<tr class="" v-for="(tod, index) in ttd.list">
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{index+1}}</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{tod.detailname}}</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{tod.paramname}}</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{tod.uplimit}}</th>
									<th  style="border-bottom:#000 solid 1px; text-align:center; line-height:24px;">{{tod.lowlimit}}</th>
								</tr>
							</tbody>
						</table>
						<div class="hidden" v-for="(tsd, index) in ttd.list">
							<p v-if="(tsd.summary)!=null">医生小结：{{tsd.summary}}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- /.main-content -->

	<%@include file="footer.jsp"%>
	<script language="javascript" src="<%=request.getContextPath()%>/js/printReport.js"></script>	
	<script language="javascript" src="<%=request.getContextPath()%>/js/LodopFuncs.js"></script>	
</body>
</html>