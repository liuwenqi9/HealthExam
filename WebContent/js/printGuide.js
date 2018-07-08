var req = new Vue({ // 定义绑定的数据
	el : "#dataBind",
	data : {
		guideId : "", // 导检ID号
		guideInfoList : [], // 导检列表
	},

	methods : {
		getGuideInfo : function(guideId) { // 更改了所选的企业
			if (guideId == "") {
				alert("请先输入导检单号");
			} else {
				$.ajax({
					url : "getGuideDataByGuideId.action",
					data : {
						"guideId" : guideId
					},
					method : "post",
					dataType : "json",
					success : function(data) {
						req.guideInfoList = data;
						if (data.length == 0) {
							alert("没有导检单号为" + guideId + "的导检信息");
						}
					},
					error : function() {
						alert("查询失败!");
					}

				});
			}

		},

		createPrintPage : function() {
//			if (guideId == "") {
//				alert("请先输入导检单号");
//			} else {
				var LODOP = getLodop();
				LODOP.ADD_PRINT_HTM(100, 100, "100%", "100%", document
						.getElementById("dynamicTableDiv").innerHTML);
				LODOP.PRINT_DESIGN();
//			}
		}
	}
});