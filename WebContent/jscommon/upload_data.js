/**
 * @author JSY
 * @date 6月21日
 * 上传人员名单js文件
 */
$(function () {

	try {
	  Dropzone.autoDiscover = false;
	
	  var myDropzone = new Dropzone('#dropzone', {
	    previewTemplate: $('#preview-template').html(),
	/*    url:"/filehandle.action",*/
	    url: "filehandle.action", // Set the url
        method : "post",
        paramName:"files",
		thumbnailHeight: 120,
	    thumbnailWidth: 120,
	    maxFiles:1,
	    maxFilesize: 10,
		addRemoveLinks : true,
		dictRemoveFile: '清空上传目录',
		 acceptedFiles:".xlsx,.xls",
		 dictMaxFilesExceeded: "您最多只能上传1个文件！",
	     dictResponseError: '文件上传失败!',
	     dictInvalidFileType: "你不能上传该类型文件,文件类型只能是*.xlsx,*.xls",
	     dictFallbackMessage:"浏览器不受支持",
	     dictFileTooBig:"文件过大上传文件最大支持",
		dictDefaultMessage :
		'<i class="ace-icon fa fa-caret-right red"></i>将文件拖拽至此(或点击)\
	<br /> \
		<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>'
	,
		
	    thumbnail: function(file, dataUrl) {
	      if (file.previewElement) {
	        $(file.previewElement).removeClass("dz-file-preview");
	        var images = $(file.previewElement).find("[data-dz-thumbnail]").each(function() {
				var thumbnailElement = this;
				thumbnailElement.alt = file.name;
				thumbnailElement.src = dataUrl;
			});
	        setTimeout(function() { $(file.previewElement).addClass("dz-image-preview"); }, 1);
	      }
	    }
	
	  });
	
	
	  //simulating upload progress
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
	            	//判断是否有成功回调函数触发
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
	  
	  /*myDropzone.on("complete", function(file) {
		  myDropzone.removeFile(file);
		});*/
	  
	   
	   //remove dropzone instance when leaving this page in ajax mode
	   $(document).one('ajaxloadstart.page', function(e) {
			try {
				myDropzone.destroy();
			} catch(e) {}
	   });
	
	} catch(e) {
	  alert('浏览器不支持Dropzone.js !');
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});