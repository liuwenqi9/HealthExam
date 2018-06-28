var currentIndex;
var currentId;
$.ajax({
	url:"loadEmployee.action",
	method:"post",
	datayType:"json",
	success:function(data){		
		empInfo.employeeList = data.employeeModel; //数据
		empInfo.pageCount = data.pageContanier; //总页数
		empInfo.currentPage = 1; //当前页
	},
	error: function(){
		alert("获取失败，请检查是否联网");
	}
})


var empInfo=new Vue({
	el:"#empInfo",
	data:{
		employeeList:[],//员工列表
		pageCount:[], //页码
		currentPage:"", //当前页
	},
	methods:{
		
		pageItem:function(page){ //分页
			$.ajax({
				url:"pageItemeInfo.action",
				data:{"currentPage":page},
				method:"post",
				dataType:"json",
				success:function(data){
					empInfo.employeeList = data.employeeModel; //数据
					empInfo.pageCount = data.pageContanier; //总页数
					
					//判断当前页数是否合法
					if(page < 1){ 
						page = 1; 
					}else if(page > empInfo.pageCount.length){
						page = empInfo.pageCount.length;
					}
					
					empInfo.currentPage = page; //当前页					
				},
				error:function(){
					alert("查询失败，请检查是否联网");
				}
			})
			
		}
		
		
	}
	
	})