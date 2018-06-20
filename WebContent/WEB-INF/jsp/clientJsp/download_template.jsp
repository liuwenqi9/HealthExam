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
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href=<%=path+"/css/jquery.dataTables.css" %>>
<link rel="stylesheet" type="text/css" href=<%=path+"/css/buttons.dataTables.min.css" %>>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载模板窗口</title>
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
					<li class="active">下载登记模板</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<!--面包线结束  -->
		<!-- 表格内容开始 -->
		<div class="page-content" id="">
			<div class="page-header">
			<!--陈述下载说明  -->
			<h3 class="header smaller lighter blue">
			模板下载步骤：
			</h3>
			<h4>①请点击右下角的下载按钮下载团检登记模板表格，
			填写顺序如下表格所示，填写时请删除第一行参考数据，并填入需提交的实际数据。<br>
			②表头：<span style="color: #FF5722">企业（医院注册）账号-（体检）员工姓名、身份证、性别、年龄、电话;</span>
			<span style="color: #307ECC">请勿删除！！！</span>以免影响之后的读取数据。<br>
			③第一行示例参考数据：<span style="color: 	#FFA500">CYKJ123-小简-350627199308014567-男-25-15759581890;</span>
			<span style="color: #FF4500">请在登记数据时删除！</span>以免影响上传数据出错！
			</h4>
		</div>
			<!--分隔线-->
			

				<div class="row">
					<div class="col-xs-12">
					
				<!--打印按钮位置-->
				<div class="clearfix">
						<!--按钮位置  -->
						<div class="pull-right">
							<label class="control-label" for="">下载模板按钮： </label>
						<div class="pull-right tableTools-container"></div>
							</div>
				</div>
						<!--表格头部-->
					<div class="table-header">
						填写企业团建人员登记模板格式如下：请下载填写完整数据,确保准确性!
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
														<th>企业（医院注册）账号</th>
													
														<th>（体检）员工姓名</th>
														<th >（体检）员工身份证</th>
														<th >（体检）员工性别</th>
														<th >（体检）员工年龄</th>
														<th >（体检）员工联系电话</th>
														
													</tr>
												</thead>

												<tbody>
													<tr>
														<!-- <td class="center">
															<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</td> -->

														<td>
															1
														</td>												
														<td >CYKJ123</td>
														<td>小简</td>

														<td >350627199308014567	</td>
															
													
														<td>男</td>
												
														<td>25</td>
													
												
														<td>15759581890</td>
														
													</tr>
												
												
												
												</tbody>
													<!--假数据结束-->
											</table>
										</div>
									</div>
								</div>
								<!--需要的表格内容结束-->		
								

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
		
		

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


<script type="text/javascript">
if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript"  src=<%=path+"/js/jquery.dataTables.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/jquery.dataTables.bootstrap.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/dataTables.buttons.min.js" %>></script>	
	<script type="text/javascript" src=<%=path+"/js/jszip.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/buttons.flash.min.js" %>></script>	
	<script type="text/javascript"  src=<%=path+"/js/buttons.html5.min.js" %>></script>	
	<script type="text/javascript"  src=<%=path+"/js/buttons.print.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/buttons.colVis.min.js" %>></script>
	<script type="text/javascript"  src=<%=path+"/js/dataTables.select.min.js" %>></script>	
			
			



	
			
<script type="text/javascript"  src=<%=path+"/jscommon/download_template.js" %>></script>
</body>
</html>