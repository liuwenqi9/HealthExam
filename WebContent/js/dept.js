var currentIndex;
var currentId;

$.ajax({
	url:"loadDept.action",
	method:"post",
	datayType:"json",
	success:function(data){		
		req.deptList = data.depModel; //数据
		req.pageCount = data.pageContanier; //总页数
		req.currentPage = 1; //当前页
	},
	error: function(){
		alert("获取失败，请检查是否联网");
	}
})

var req = new Vue({
	el:"#dataBind",
	data:{
		deptList:[], //科室列表
		pageCount:[], //页码
		currentPage:"", //当前页
	},
	methods:{		
		showModal:function(deptid,no){
			$("#change-modal").modal('show');
			currentId = deptid;
			currentIndex=no;
		},		
		changeDept:function(){ //更改科室
			var deptname = $("#changeName").val();
			$.ajax({
				url:"changeDepMg.action",
				data:{"deptid":currentId, "deptname":deptname},
				method:"post",
				dataType:"json",
				success:function(data){
					req.deptList[currentIndex].deptname = data.deptname;
					$("#change-modal").modal("hide");
				},
				error: function(){
					alert("更改失败，请检查是否联网");
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
					req.deptList = data.depModel; //数据
					req.pageCount = data.pageContanier; //总页数
					req.currentPage = 1; //当前页
					$("#add-modal").modal('hide');
				},
				error: function(){
					alert("添加失败，请检查是否联网");
				}
			})
		},
		deletDept:function(deptid){//删除科室			
			var flag = confirm("是否确认删除该科室？");			
			if(flag){				
				$.ajax({
					url:"deletDepMg.action",
					data:{"deptid":deptid},
					method:"post",
					dataType:"json",
					success:function(data){
						req.deptList = data.depModel; //数据
						req.pageCount = data.pageContanier; //总页数
						req.currentPage = 1; //当前页
						alert("删除成功");
					},
					error: function(){
						alert("删除失败，请检查是否联网");
					}
				})
			}			
		},
		searchDept:function(){ //科室查询
			var seachName = $("#seachName").val().replace(/\s|\xA0/g, ""); //去除全部空格
			if(seachName == ""){
				$.ajax({
					url:"loadDept.action",
					data:{"deptname":seachName},
					method:"post",
					dataType:"json",
					success:function(data){
						req.deptList = data.depModel; //数据
						req.pageCount = data.pageContanier; //总页数
						req.currentPage = 1; //当前页
					},
					error:function(){
						alert("查询失败，请检查是否联网");
					}
				})
			}else{
				$.ajax({
					url:"searchDepMg.action",
					data:{"deptname":seachName},
					method:"post",
					dataType:"json",
					success:function(data){
						req.deptList = data.depModel; //数据
						req.pageCount = data.pageContanier; //总页数
						req.currentPage = 1; //当前页
					},
					error:function(){
						alert("查询失败，请检查是否联网");
					}
				})
			}			
		},
		
		pageItem:function(page){ //分页
			
			var seachName = $("#seachName").val().replace(/\s|\xA0/g, ""); //去除全部空格
			$.ajax({
				url:"pageItem.action",
				data:{"deptname":seachName, "currentPage":page},
				method:"post",
				dataType:"json",
				success:function(data){
					req.deptList = data.depModel; //数据
					req.pageCount = data.pageContanier; //总页数
					
					//判断当前页数是否合法
					if(page < 1){ 
						page = 1; 
					}else if(page > req.pageCount.length){
						page = req.pageCount.length;
					}
					
					req.currentPage = page; //当前页					
				},
				error:function(){
					alert("查询失败，请检查是否联网");
				}
			})
			
		}
	}
})


