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
				<li>系统管理</li>
					<li class="active">下载登记模板</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<!--面包线结束  -->
		<!-- 表格内容开始 -->
		<div class="page-content" id="">
			<div class="page-header">
			<!--陈述下载说明  -->
			<h3 class="header smaller lighter blue">模板下载</h3>
		</div>
			<!--分隔线-->
			<div class="hr hr-18 dotted hr-double"></div>

				<div class="row">
					<div class="col-xs-12">
					
				<!--打印按钮位置-->
				<div class="clearfix">
						<!--按钮位置  -->
						<div class="pull-right tableTools-container"></div>
				</div>
						<!--表格头部-->
					<div class="table-header">
						下载企业团建人员登记模板格式如下：请填写完整数据,确保准确性！
					</div>

						<!-- div.table-responsive -->

				<!-- div.dataTables_borderWrap -->
					<div>
				<table id="dynamic-table" class="table table-striped table-bordered table-hover">
					<thead>
									<tr>
										<th class="center">
													<label class="pos-rel">
														<input type="checkbox" class="ace" />
														<span class="lbl"></span>
														</label>
														</th>
														<th>序号</th>
														<th>企业（医院注册）全称</th>
														<th class="hidden-480">企业（医院注册）账号</th>

														<th>
															<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
															（体检）员工姓名
														</th>
														<th class="hidden-480">（体检）员工身份证</th>

														<th></th>
													</tr>
												</thead>

												<tbody>
													<tr>
														<td class="center">
															<label class="pos-rel">
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</td>

														<td>
															<a href="#">1</a>
														</td>
														<td>传一科技有限公司</td>
														<td class="hidden-480">CYKJ123</td>
														<td>小简</td>

														<td class="hidden-480">
															<span class="label label-sm label-warning">350627</span>
														</td>

														<td>
															<div class="hidden-sm hidden-xs action-buttons">
																<a class="blue" href="#">
																	<i class="ace-icon fa fa-search-plus bigger-130"></i>
																</a>

																<a class="green" href="#">
																	<i class="ace-icon fa fa-pencil bigger-130"></i>
																</a>

																<a class="red" href="#">
																	<i class="ace-icon fa fa-trash-o bigger-130"></i>
																</a>
															</div>

															<div class="hidden-md hidden-lg">
																<div class="inline pos-rel">
																	<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
																		<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
																	</button>

																	<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
																		<li>
																			<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																				<span class="blue">
																					<i class="ace-icon fa fa-search-plus bigger-120"></i>
																				</span>
																			</a>
																		</li>

																		<li>
																			<a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																				</span>
																			</a>
																		</li>

																		<li>
																			<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="ace-icon fa fa-trash-o bigger-120"></i>
																				</span>
																			</a>
																		</li>
																	</ul>
																</div>
															</div>
														</td>
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
<script type="text/javascript"  src=<%=path+"/jscommon/download_template.js" %>></script>
<script type="text/javascript">
if('ontouchstart' in document.documentElement) document.write("<script src='../js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>


</body>
</html>