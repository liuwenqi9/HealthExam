$.ajax({
	url : "getMultiExamInfo.action",
	type : "post",
	dataType : "json",
	success : function(data) {
		req.multiInfoList = data.multiInfoList; // 数据
		req.accountList = data.accountList;
		req.pageCount = data.pageContanier; // 总页数
		req.currentPage = 1;
	},
	error : function() {
		alert("获取失败，请检查是否联网");
	}

})

var currentid;
var currentIndex;
var req = new Vue({
	el : "#multiQueryDataBind",
	data : {
		multiInfoList : [], // 体检综合信息列表
		accountList : [], // 企业名称列表

		multiCondition:{			
			account : "", // 当前企业id号
			name : "", // 姓名
			telephone : "", // 电话号码
			state:"",
		},
		
		pageCount : [], // 页码
		currentPage : "", // 当前页
	},
	methods : {		
		multiQuery : function() {    
			
			$.ajax({
				url : "getExamInfoByCondition.action",
				data : JSON.stringify(req.multiCondition),
				method : "post",
				dataType : "json",
				contentType:"application/json",
				success : function(data) {
					req.multiInfoList = data.multiInfoList;
					req.pageCount = data.pageContanier;
				}

			});
		},
		

		pageItem : function(page) {    // 分页切换功能函数

			$.ajax({
				url : "getExamInfoByPage.action",
				data : {
					"multiCondition" : JSON.stringify(req.multiCondition),
					"currentPage" : page
				},
				method : "post",
				dataType : "json",
//				contentType : "application/json",
				success : function(data) {
					req.multiInfoList = data.multiInfoList;
					req.pageCount = data.pageContanier;
					alert(req.pageCount.length);
					// 判断当前页数是否合法
					if (page < 1) {
						page = 1;
					} else if (page > req.pageCount.length) {
						page = req.pageCount.length;
					}
					req.currentPage = page; // 当前页
				},
				error : function() {
					alert("查询失败!");
				}
			})
		}


	}
})