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
<title>上传名单窗口</title>
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css" href=<%=path+"/css/bootstrap-theme.min.css" %>>
 <style>
   
    #actions {
      margin: 2em 0;
    }


    /* Mimic table appearance */
    div.table {
      display: table;
    }
    div.table .file-row {
      display: table-row;
    }
    div.table .file-row > div {
      display: table-cell;
      vertical-align: top;
      border-top: 1px solid #ddd;
      padding: 8px;
    }
    div.table .file-row:nth-child(odd) {
      background: #f9f9f9;
    }



    /* The total progress gets shown by event listeners */
    #total-progress {
      opacity: 0;
      transition: opacity 0.3s linear;
    }

    /* Hide the progress bar when finished */
    #previews .file-row.dz-success .progress {
      opacity: 0;
      transition: opacity 0.3s linear;
    }

    /* Hide the delete button initially */
    #previews .file-row .delete {
      display: none;
    }

    /* Hide the start and cancel buttons and show the delete button */

    #previews .file-row.dz-success .start,
    #previews .file-row.dz-success .cancel {
      display: none;
    }
    #previews .file-row.dz-success .delete {
      display: block;
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
		<!-- 表格内容开始 -->
		
		<div class="page-content" id="">
	
			<!--陈述上传说明开始  -->
			<div class="page-header">
			<h3 class="header smaller lighter blue">
			名单上传步骤：
			</h3>
			<h4>①请点击（或拖拽至）下面的上传名单区域，选择需要上传的文件<span style="color: #FF5722">（严格要求上传的文件为门户下载的登记模板<br>"传一人民医院-企业注册人员模板.xlsx"）请注意文件格式为xlsx。</span><br>		
			②请确保表头包含：<span style="color: #FF5722">企业（医院注册）账号-（体检）员工姓名、身份证、性别、年龄、电话;</span>以确保数据读取准确。<br>		
			③登记体检人数据如：<span style="color: 	#FFA500">CYKJ123-小简-350627199308014567-男-25-15759581890;</span>请确保身份证和电话正常显示！<br>	
			<span style="color: #FF4500">（错误的显示为科学计数法的手机号：1.58E+10,将影响数据的准确读取）。</span>
			</h4>
		    </div>
		    <!--陈述上传说明结束  -->
		    <!-- 表格数据开始 -->
				<div class="row">
				<div class="col-xs-3">
				<!--上传按钮位置-->
			 	<div class="clearfix">
						按钮位置 
					 <div class="pull-left">
							<label class="control-label" for="">上传文件按钮： </label>
							
							 <form action="filehandle.action" method="post" enctype="multipart/form-data">
     					请选择文件:<input type="file" name="files"class="file">
     					 
     					 <button type="submit" class="btn btn-primary start">
           				 <i class="glyphicon glyphicon-upload"></i>
         				   <span>上传</span>
      					  </button> 
    						 </form>
							</div> 
				</div> 
						<!-- PAGE CONTENT BEGINS -->
							<!-- 	<div class="alert alert-info">
									<i class="ace-icon fa fa-hand-o-right"></i>

								请参考上传名单规定.
									<button class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>
								</div>

								<div>
									<form action="filehandle.action"  method="post" class="dropzone well" id="dropzone"enctype="multipart/form-data" >
										<div class="fallback">
											<input name="file" type="file"  multiple= ""/>
										</div>
									</form>
								</div>

								<div id="preview-template" class="hide">
									<div class="dz-preview dz-file-preview">
										<div class="dz-image">
											<img data-dz-thumbnail="" />
										</div>

										<div class="dz-details">
											<div class="dz-size">
												<span data-dz-size=""></span>
											</div>

											<div class="dz-filename">
												<span data-dz-name=""></span>
											</div>
										</div>

										<div class="dz-progress">
											<span class="dz-upload" data-dz-uploadprogress=""></span>
										</div>

										<div class="dz-error-message">
											<span data-dz-errormessage=""></span>
										</div>

										<div class="dz-success-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-check fa-stack-1x fa-inverse green"></i>
											</span>
										</div>

										<div class="dz-error-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-remove fa-stack-1x fa-inverse red"></i>
											</span>
										</div>
									</div>
								</div>  -->
								<!-- PAGE CONTENT ENDS -->	
			<!-- 新加按钮 开始-->
	 <div class="container" id="container">

    <div id="actions" class="row">

      <div class="col-lg-7">
      <!--   The fileinput-button span is used to style the file input field as button -->
        <span class="btn btn-success fileinput-button" >
            <i class="glyphicon glyphicon-plus"></i>
            <span>添加文件</span>
        </span>
        <button type="submit" class="btn btn-primary start">
            <i class="glyphicon glyphicon-upload"></i>
            <span>开始上传</span>
        </button> 
       <button type="reset" class="btn btn-warning cancel">
            <i class="glyphicon glyphicon-ban-circle"></i>
            <span>取消上传</span>
        </button> 
      </div>

      <div class="col-lg-5">
       <!--  The global file processing state -->
        <span class="fileupload-process">
          <div id="total-progress" class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
          </div>
        </span>
      </div>

    </div>








    <div class="table table-striped files" id="previews">

      <div id="template" class="file-row">
       <!--  This is used as the file preview template -->
        <div>
            <span class="preview"><img data-dz-thumbnail /></span>
        </div>
        <div>
            <p class="name" data-dz-name></p>
            <strong class="error text-danger" data-dz-errormessage></strong>
        </div>
        <div>
            <p class="size" data-dz-size></p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
              <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
            </div>
        </div>
        <div>
        
         <button class="btn btn-primary start">
              <i class="glyphicon glyphicon-upload"></i>
              <span>开始</span>
          </button> 
          <button data-dz-remove class="btn btn-warning cancel">
              <i class="glyphicon glyphicon-ban-circle"></i>
              <span>取消</span>
          </button>
          <button data-dz-remove class="btn btn-danger delete">
            <i class="glyphicon glyphicon-trash"></i>
            <span>清空</span>
          </button>
      
        </div>
      </div>

    
	</div>
   


  </div>
				<!-- 新加按钮 结束-->
				
			</div>
			</div>
			<!--上传按钮数据结束  -->
			<!--表格数据开始  -->
			<div class="row">
					<div class="col-xs-12">
					
				<!--打印按钮位置-->
				<div class="clearfix">
						<!--按钮位置  -->
						
				</div>
						<!--表格头部-->
					<div class="table-header">
						导入的员工信息如下：目前无数据，下面数据写死
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
								<div>
								 <div class="pull-right">
								 <button type="" class="btn btn-primary save">
          							  <i class="glyphicon glyphicon-saved"></i>

           						 <span>保存数据</span>
        						</button> 
												
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
	
	 <script type="text/javascript"  src=<%=path+"/js/dropzone.min.js" %>></script> 
	<%--  <script type="text/javascript"  src=<%=path+"/jscommon/upload_data.js" %>></script>  --%>
	<script type="text/javascript">
		 try {
		 Dropzone.autoDiscover = false;
      // Get the template HTML and remove it from the doument
      var previewNode = document.querySelector("#template");
      previewNode.id = "";
      var previewTemplate = previewNode.parentNode.innerHTML;
      previewNode.parentNode.removeChild(previewNode);

      var myDropzone = new Dropzone(document.body, { // Make the whole body a dropzone
        url: "filehandle.action", // Set the url
        method : "post",
        paramName:"files",
        maxFiles:1,
	    maxFilesize: 10,
        thumbnailWidth: 80,
        thumbnailHeight: 80,
        parallelUploads: 20,
        acceptedFiles:".xlsx,.xls",
        previewTemplate: previewTemplate,
        autoQueue: false, // Make sure the files aren't queued until manually added
        previewsContainer: "#previews", // Define the container to display the previews
        clickable: ".fileinput-button" ,// Define the element that should be used as click trigger to select files.
       		 dictMaxFilesExceeded : "您最多只能上传{{maxFiles}}个文件！",
    	     dictResponseError: '文件上传失败!',
    	     dictInvalidFileType: "你不能上传该类型文件,文件类型只能是*.xlsx,*.xls",
    	     dictFallbackMessage:"浏览器不受支持",   	  
    	     dictFileTooBig:"文件过大({{filesize}}MB). 上传文件最大支持: {{maxFilesize}}MB."	
        
      });

      myDropzone.on("addedfile", function(file) {
        // Hookup the start button
        file.previewElement.querySelector(".start").onclick = function() { myDropzone.enqueueFile(file); };
      });

      // Update the total progress bar
      myDropzone.on("totaluploadprogress", function(progress) {
        document.querySelector("#total-progress .progress-bar").style.width = progress + "%";
      });

      myDropzone.on("sending", function(file) {
        // Show the total progress bar when upload starts
        document.querySelector("#total-progress").style.opacity = "1";
        // And disable the start button
        file.previewElement.querySelector(".start").setAttribute("disabled", "disabled");
      });

      // Hide the total progress bar when nothing's uploading anymore
      myDropzone.on("queuecomplete", function(progress) {
        document.querySelector("#total-progress").style.opacity = "0";
      });

      // Setup the buttons for all transfers
      // The "add files" button doesn't need to be setup because the config
      // `clickable` has already been specified.
      document.querySelector("#actions .start").onclick = function() {
        myDropzone.enqueueFiles(myDropzone.getFilesWithStatus(Dropzone.ADDED));
      };
      document.querySelector("#actions .cancel").onclick = function() {
        myDropzone.removeAllFiles(true);
      };





      // Now fake the file upload, since GitHub does not handle file uploads
      // and returns a 404

      var minSteps = 6,
          maxSteps = 60,
          timeBetweenSteps = 100,
          bytesPerStep = 100000;

      myDropzone.uploadFiles = function(files) {
        var self = this;

        for (var i = 0; i < files.length; i++) {

          var file = files[i];
          totalSteps = Math.round(Math.min(maxSteps, Math.max(minSteps, file.size / bytesPerStep)));

          for (var step = 0; step < totalSteps; step++) {
            var duration = timeBetweenSteps * (step + 1);
            setTimeout(function(file, totalSteps, step) {
              return function() {
                file.upload = {
                  progress: 100 * (step + 1) / totalSteps,
                  total: file.size,
                  bytesSent: (step + 1) * file.size / totalSteps
                };

                self.emit('uploadprogress', file, file.upload.progress, file.upload.bytesSent);
                if (file.upload.progress == 100) {
                  file.status = Dropzone.SUCCESS;
                  self.emit("success", file, 'success', null);
                  self.emit("complete", file);
                  self.processQueue();
                }
              };
            }(file, totalSteps, step), duration);
          }
        }
      }
		 } catch(e) {
			  alert('浏览器不支持Dropzone.js !');
			}
    </script>	
			
		
</body>
</html>