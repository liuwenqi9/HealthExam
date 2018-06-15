
$(function(){
	
	//添加科室
	$("#insertDept").click(function(){

		$("#add-form").submit();
		$("#deptname").text("");
		$("#add-modal").modal('hide');
	})
	
	//修改科室名称
	var currentId; //科室Id
	var currentDom; //当前节点
	var thDom;
	$(".changeBtn").click(function(){
		
		$("#change-modal").modal('show')
		currentDom = $(this);	
		thDom = currentDom.parents("tr").children().eq(1);
		currentId = thDom.eq(0).attr("title");
	})
	
	//表单提交
	$("#changeDept").click(function(){
		
		var deptName = $("#changeName").val();//科室名称
		alert(currentId);
		$.ajax({
			url:"changeDepMg.action",
			data:{"deptid":currentId, "deptname":deptName},
			type:"post",
			dataType:"json",
			success:function(data){
				
				alert(data.deptname);
				thDom.text("成功！");
				$("#change-modal").modal('hide');
				$("#changeName").text("");
			}
		})	
	})	
})