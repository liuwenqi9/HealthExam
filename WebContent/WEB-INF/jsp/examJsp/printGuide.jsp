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

<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/LodopFuncs.js"></script>
<object id="LODOP_OB"
	classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width="0"
	height="0">
	<embed id="LODOP_EM" type="application/x-print-lodop" width="0"
		height="0" pluginspage="Lodop/install_lodop32.exe"></embed>
</object>

</head>
<body class="no-skin">
	<%@ include file="menu.jsp"%>

	<div class="main-content">
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
				<li>体检工作</li>
				<li class="active">打印导检单和条码</li>
			</ul>
			<div class="page-content" id="dataBind">
				<div class="page-header">


					<div class="pull-left form-inline">
						<div class="form-group">
							<input type="text" placeholder="输入导检单号" v-model="guideId"
								class="form-control">
							<button class="btn btn-sm btn-success"
								v-on:click="getGuideInfo(guideId)">
								<i class="glyphicon  glyphicon-search bigger-110"></i>查询
							</button>

							<button class="btn btn-sm btn-success"
								v-on:click="createPrintPage();LODOP.PRINT_DESIGN()">打印导检单</button>
						</div>
					</div>

					<div class="row">

						<div id="dynamicTableDiv" class="col-xs-12">
							<table class="table table-striped table-bordered table-hover">

								<tr v-for="(todo, index) in guideInfoList" v-if="index==0">
									<td class="center">姓名：{{todo.name}}</td>
								</tr>
								<tr v-for="(todo, index) in guideInfoList" v-if="index==0">
									<td class="center">所属企业：{{todo.accountname}}</td>
								</tr>
								<tr v-for="(todo, index) in guideInfoList" v-if="index==0">
									<td class="center">身份证号码：{{todo.identity}}</td>
								</tr>
								<tr v-for="(todo, index) in guideInfoList" v-if="index==0">
									<td class="center">性别/年龄：{{todo.sex}}/ {{todo.age}}</td>
								</tr>
								<tr v-for="(todo, index) in guideInfoList" v-if="index==0">
									<td class="center">条形码：{{todo.barcode}}</td>
								</tr>
							</table>
								
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr tr v-for="(todo, index) in guideInfoList" v-if="index==0">
										<th class="center" width="20%">检查项目</th>
										<th class="center" width="20%">体检科室</th>
										<th class="center" width="30%">科室医生</th>
										<th class="center" width="30%">医生签名</th>

									</tr>
								</thead>

								<tbody>
									<tr v-for="(todo, index) in guideInfoList">
										<td class="center">{{todo.itemname}}</td>
										<td class="center">{{todo.deptname}}</td>
										<td class="center">{{todo.totoldoctors}}</td>
										<td class="center"></td>

									</tr>
								</tbody>

							</table>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>

			<!-- /.breadcrumb -->
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

	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<%@ include file="footer.jsp"%>
	<script src="<%=request.getContextPath()%>/js/printGuide.js"></script>

</body>
</html>
