$.ajax({
	url : "getAccountData.action",
	type : "post",
	dataType : "json",
	success : function(data) {
		req.accountList = data.accountList; // 企业账号列表
		req.guideInfoList = data.guideInfoList; // 数据
		req.pageCount = data.pageContanier; // 总页数
		req.currentAccount = data.currentAccount; // 当前企业
		req.currentPage = 1; // 当前页
	}
})

var req = new Vue({
	el : "#dataBind",
	data : {
		accountList : [], // 企业账号列表
		guideInfoList : [], // 导检列表
		pageCount : [], // 页码
		currentPage : "", // 当前页
		currentAccount : "" // 当前账户
	},
	methods : {
		accountChange : function(accountId, name, amount) { // 更改了所选的企业
			$("#userName").text("当前查询企业为：" + name);
			if (amount == null) {
				$("#currentAmount").text("该企业账户余额：0  元");
			} else {
				$("#currentAmount").text("该企业账户余额：" + amount + "元");
			}
			req.currentAccount = accountId; // 把当前账户ID进行转换
			$.ajax({
				url : "getGuideDataByAccount.action",
				data : {
					"accountId" : accountId
				},
				method : "post",
				dataType : "json",
				success : function(data) {
					req.guideInfoList = data.guideInfolist;
					req.pageCount = data.pageContanier;
					req.currentPage = 1; // 当前页
				}

			});
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