
$.ajax({
	url:"getAllMsg.action",
	method:"post",
	dataType:"json",
	success:function(data){
		req.rdList = data.depModel;
		req.pageCount = data.pageContanier;
		req.currentPage = 1;
		if(req.rdList.length==0){			
			alert("当前没有需要进行结算的订单！");
		}
	},
	error:function(){
		alert("获取失败，请检查是否联网");
	}
})

var chargeid;
var currentIndex;
var req = new Vue({
	el:"#dataBind",
	data:{
		rdList:[], //订单
		pageCount:[], //页码
		currentPage:"", //订单当前页
		rdObj:[] ,//当前订单详情
		detailCount:[], //当前订单信息分页
		billState:"",
		detailPage:"" //详情当前页
	},
	methods:{		
		showModal:function(id, no, state){
			$("#settle-modal").modal("show");
			req.billState = state;
			chargeid = id;
			currentIndex = no;
			$.ajax({
				url:"getBillDetail.action",
				data:{"chargeid":chargeid},
				method:"post",
				dataType:"json",
				success:function(data){
					req.rdObj = data.billDetal;
					req.detailCount = data.smallContanier;
				},
				error:function(data){
					alert("获取失败，请检查是否联网");
				}
			})
		},
		billCheck:function(){ //结算			
			$.ajax({
				url:"checkCash.action",
				data:{"chargeid":chargeid},
				method:"post",
				dataType:"json",
				success:function(data){
					var flag;
					if(data.totalprice == 0){
						flag = confirm("该订单尚未实际性消费，是否确认结算？");
					}else {			
						flag = confirm("该订单总价为" + data.amount + "，实际消费：" + data.totalprice + "是否确认结算？");
					}
					
					if(flag){
						
						$.ajax({
							url:"comfirmCheck.action",
							data:{"chargeid":chargeid, "state":0},
							method:"post",
							dataType:"json",
							success:function(data){
								if(data.success != -1){
									billState=0;
									req.rdList[currentIndex].recordtime = data.recordtime;
									req.rdList[currentIndex].recordstate = data.recordstate;
								}
								$("#settle-modal").modal("hide");
							}
						})
					}else{
						$("#settle-modal").modal("hide");
					}
					
				},
				error:function(){
					alert("结算失败，请检查是否联网");
				}
			})
		},
		pageItem:function(page){ //订单分页
			$.ajax({
				url:"changePages.action",
				data:{"currentPage":page},
				method:"post",
				dataType:"json",
				success:function(data){
					req.rdList = data.depModel;
					req.pageCount = data.pageContanier;
					if(page < 1){ 
						page = 1; 
					}else if(page > req.pageCount.length){
						page = req.pageCount.length;
					}
					req.currentPage = page;
					
				},
				error:function(){
					alert("获取失败，请检查是否连接网络");
				}
			})	
		},
		detailPage:function(page){ //详情分页
			$.ajax({
				url:"detailPages.action",
				data:{"currentPage":page, "chargeid":chargeid},
				method:"post",
				dataType:"json",
				success:function(data){
					req.rdObj = data.billDetal;
					req.detailCount = data.smallContanier;
					
					if(page < 1){ 
						page = 1; 
					}else if(page > req.pageCount.length){
						page = req.pageCount.length;
					}
					detailPage = page;
				},
				error:function(){
					alert("获取失败，请检查是否连接网络");
				}
			})
		}
	}
})