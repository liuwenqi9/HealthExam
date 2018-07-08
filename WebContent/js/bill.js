var currentIndex;
var currentId;
$.ajax({
	url : "loadBillList.action",
	method : "post",
	datayType : "json",
	success : function(data) {
		red.billList = data.billList; // 数据
		red.pageCount = data.pageContanier; // 总页数
		red.currentPage = 1; // 当前页
	},
	error : function() {
		alert("获取失败，请检查是否联网");
	}
})

var red = new Vue({
	el : "#bill",
	data : {
		billList : [],// 员工列表
		pageCount : [], // 页码
		currentPage : "", // 当前页
	},
	methods : {

		pageItem : function(page) { // 分页
			$.ajax({
				url : "pageItemeBill.action",
				data : {
					"currentPage" : page
				},
				method : "post",
				dataType : "json",
				success : function(data) {
					red.billList = data.billList; // 数据
					red.pageCount = data.pageContanier; // 总页数

					// 判断当前页数是否合法
					if (page < 1) {
						page = 1;
					} else if (page > red.pageCount.length) {
						page = red.pageCount.length;
					}

					red.currentPage = page; // 当前页
				},
				error : function() {
					alert("查询失败，请检查是否联网");
				}
			})

		}

	}

})

function settlement(node) {

	var con;
	con = confirm("确定结款吗？"); // 在页面上弹出对话框
	if (con == true) {
		var chileArr = node.parentElement.parentElement; // 获取当前节点的所需要的父级节点
		var nodes = filterSpaceNode(chileArr);
		var rowNum = nodes.rowIndex; // 当前点击行号
		var chargeid = document.getElementById('grid-table').rows[rowNum].cells[1].innerText;
		var account = document.getElementById('grid-table').rows[rowNum].cells[2].innerText;
		var amount = document.getElementById('grid-table').rows[rowNum].cells[3].innerText;
		alert(chargeid + amount);

		$.ajax({
			url : "settlement.action",
			type : "post",
			dataType : "text",
			data : {
				"chargeid" : chargeid,
				"account" : account,
				"amount" : amount
			},
			success : function(data) {
				if (data == "OK") {
					alert("扣除成功");
//					var formNode = document.getElementById("form");
//	
//					formNode.action = 'loadBillList.action';
//					formNode.submit();
				} else if (data == "FAIL") {

					alert("余额不足");

				}
			}
		})
	}

}

function filterSpaceNode(nodes) {
	for (var i = 0; i < nodes.length; i++) {
		if (nodes[i].nodeType == 3 && /^\s+$/.test(nodes[i].nodeValue)) {
			// 得到空白节点之后，移到父节点上，删除子节点
			nodes[i].parentNode.removeChild(nodes[i]);

		}
	}
	return nodes;
}