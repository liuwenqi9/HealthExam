//获取企业账号列表和套餐列表的数据
$.ajax({
	url : "getOriginalData.action",
	type : "post",
	dataType : "json",
	success : function(data) {
		req.personList = data.personList; // 企业账号列表
		req.packageList = data.packageList;
	}
})

var req = new Vue({
	el : "#teamOpenDataBind",
	data : {
		personList : [], // 员工列表
		packageList : [], // 套餐列表
		personIdList : [],
		packageIdList : []
	},
	methods : {
		sureOpen : function() { // 选择了勾选了某个员工
			if (req.personIdList.length == 0) {
				alert("请至少选择一个员工再下单预定");
			} else if (req.packageIdList.length == 0) {
				alert("请至少选择一个套餐再下单预定");
			} else {
				$("#teamOpenFormId").submit();
//				$.ajax({
//					url : "makeCharge.action",
//					data : {
//						"personChoose" : req.personChoose,
//						"packageChoose": req.packageChoose
//					},
//					method : "post",
//					dataType : "text",
//					success : function(data) {
//						alert("返回了");
//					}
//
//				});
			}

		},

		pageItem : function(page) { // 分页切换功能函数
			$.ajax({
				url : "getGuideInfoByPage.action",
				data : {
					"accountId" : req.currentAccount,
					"currentPage" : page
				},
				method : "post",
				dataType : "json",
				success : function(data) {
					req.guideInfoList = data.guideInfolist;
					req.pageCount = data.pageContanier;
					// 判断当前页数是否合法
					if (page < 1) {
						page = 1;
					} else if (page > req.pageCount.length) {
						page = req.pageCount.length;
					}
					req.currentPage = page; // 当前页
				},
				error : function() {
					alert("查询失败，请检查是否联网");
				}
			})

		}
	}
});