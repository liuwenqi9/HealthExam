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
<title>上传名单窗口</title>

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
		<!-- 表格内容开始 -->
		<div class="page-content" id="">
	
			<!--陈述上传说明开始  -->
			<div class="page-header">
			<h3 class="header smaller lighter blue">
			名单上传步骤：
			</h3>
			<h4>①请点击右下角的上传名单按钮，选择需要上传的文件<span style="color: #FF5722">（严格要求上传的文件为门户下载的登记模板<br>"传一人民医院-企业注册人员模板.xlsx"）请注意文件格式为xlsx。</span><br>		
			②请确保表头包含：<span style="color: #FF5722">企业（医院注册）账号-（体检）员工姓名、身份证、性别、年龄、电话;</span>以确保数据读取准确。<br>		
			③登记体检人数据如：<span style="color: 	#FFA500">CYKJ123-小简-350627199308014567-男-25-15759581890;</span>请确保身份证和电话正常显示！<br>	
			<span style="color: #FF4500">（错误的显示为科学计数法的手机号：1.58E+10,将影响数据的准确读取）。</span>
			</h4>
		    </div>
		    <!--陈述上传说明结束  -->
		    <!-- 表格数据开始 -->
				<div class="row">
				<div class="col-xs-12">
				<!--上传按钮位置-->
				<div class="clearfix">
						<!--按钮位置  -->
						<div class="pull-left">
							<label class="control-label" for="">上传文件按钮： </label>
							<input type="file"  >
							
							</div>
				</div>
				
			</div>
			</div>
			<!--表格数据结束  -->
		</div><!-- /.col -->
		</div><!-- /.row -->
		
		

<!--内容结束  -->
<!-- 页脚 -->
<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120"> <span class="blue bolder"></span>
					jsy © 2017 - 2018
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
	
			
		
</body>
</html>