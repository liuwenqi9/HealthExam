

var req = new Vue({
	el:"#dataBind",
	data:{
		deptList:[], //科室列表
		pageCount:[], //页码
		pageNum:"",   //页数
	},
	methods:{		
		showModal:function(){
			$("#change-modal").modal('show');
		},
		changeDept:function(deptid){ //更改科室
			
			var deptname = $("#changeName").val();
			$.ajax({
				url:"changeDepMg.action",
				data:{"deptid":deptid, "deptname":deptname},
				method:"post",
				dataType:"json",
				success:function(data){
					this.parents("tr").children().eq(2).text(data.deptname);
				}
			})
			
		},
		addDept:function(){ //增加科室
			
			var deptname = $("#deptname").val();
			$.ajax({
				url:"addDeptMg.action",
				data:{"deptname":deptname},
				method:"post",
				dataType:"json",
				success:function(data){
					req.deptList=data;
					$("#add-modal").modal('hide');
				}
			})
		},
		deletDept:function(deptid){//删除科室
			$.ajax({
				url:"deletDepMg.action",
				data:{"deptid":deptid},
				method:"post",
				dataType:"json",
				success:function(data){
					alert("删除成功");
				}
			})
		}
	}
})

$(function(){
	
	$.ajax({
		url:"loadDept.action",
		method:"post",
		datayType:"json",
		success:function(data){
			req.deptList=data;	
		},
		error: function(){
			alert("获取失败");
		}
	})
	
	//修改科室名称
//	var currentId; //科室Id
//	var currentDom; //当前节点
//	var thDom;
//	$(".changeBtn").click(function(){
//		
//		$("#change-modal").modal('show')
//		currentDom = $(this);	
//		trDom = currentDom.parents("tr");
//		currentId = trDom.children().eq(1).attr("title");
//	})
	
})






//$(function(){
//
//	//添加科室
//	$("#insertDept").click(function(){
//
//		$("#add-form").submit();
//		$("#deptname").text("");
//		$("#add-modal").modal('hide');
//	})
//	
//	//修改科室名称
//	var currentId; //科室Id
//	var currentDom; //当前节点
//	var thDom;
//	$(".changeBtn").click(function(){
//		
//		$("#change-modal").modal('show')
//		currentDom = $(this);	
//		trDom = currentDom.parents("tr");
//		currentId = trDom.children().eq(1).attr("title");
//	})
//	
//	//表单提交
//	$("#changeDept").click(function(){
//		
//		var deptName = $("#changeName").val();//科室名称
//		$.ajax({
//			url:"changeDepMg.action",
//			data:{"deptid":currentId, "deptname":deptName},
//			type:"post",
//			dataType:"json",
//			success:function(data){
//				
//				trDom.children().eq(2).text(data.deptname);
//				$("#change-modal").modal('hide');
//				$("#changeName").val("");
//			}
//		})	
//	})	
//})