
$.ajax({
	url:"loadBill.action",
	type:"post",
	dataType:"json",
	success:function(data){
		req.billList = data.depModel; //数据
		req.pageCount = data.pageContanier; //总页数
		req.currentPage = 1; //当前页
	},
	error:function(){
		alert("获取失败，请检查是否联网");
	}
	
})

var currentid;
var currentIndex;
var req = new Vue({
	el:"#dataBind",
	data:{
		billList:[], //科室列表
		pageCount:[], //页码
		currentPage:"", //当前页
		billObj:"",
	},
	methods:{
		showModal:function(chargeid,no){ //展示订单详情
			$("#bill-modal").modal("show");				
			currentid = chargeid; //订单ID
			currentIndex = no;  //序号
			$.ajax({
				url:"getOneBill.action",
				data:{"chargeid":chargeid},
				method:"post",
				dataType:"json",
				success:function(data){
					req.billObj = data;					
				},
				error:function(data){
					alert("数据获取失败，请检查是否联网");
				}				
			})
		},
		recoderBill:function(){ //记账
			$.ajax({
				url:"recoderBill.action",
				data:{"chargeid":currentid, "state":1},
				method:"post",
				dataType:"json",
				success:function(data){
					req.billList[currentIndex].time = data.time;
					req.billList[currentIndex].state = 0;
					$("#bill-modal").modal("hide");	
				},
				error:function(){
					alert("提交失败，请确认是否联网");
				}
			})
		},
		searchBill:function(){ //订单搜索		
			var acc = $("#seachName").val().replace(/\s|\xA0/g, ""); //去除全部空格;			
			if(acc == ""){
				$.ajax({
					url:"loadBill.action",
					data:{"account":acc},
					method:"post",
					dataType:"json",
					success:function(data){
						req.billList = data.depModel; //数据
						req.pageCount = data.pageContanier; //总页数
						req.currentPage = 1; //当前页
					},
					error:function(){
						alert("获取失败，请确认是否联网");
					}
				})
			}else {			
				$.ajax({
					url:"searchBill.action",
					data:{"account":acc},
					method:"post",
					dataType:"json",
					success:function(data){
						req.billList = data.depModel; //数据
						req.pageCount = data.pageContanier; //总页数
						req.currentPage = 1; //当前页
					},
					error:function(){
						alert("获取失败，请确认是否联网");
					}
				})
			}
		},
		pageItem:function(page){ //分页
			var acc = $("#seachName").val().replace(/\s|\xA0/g, ""); //去除全部空格;
			$.ajax({
				url:"pageItemForBill.action",
				data:{"account":acc, "currentPage":page},
				method:"post",
				dataType:"json",
				success:function(data){
					req.billList = data.depModel; //数据
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