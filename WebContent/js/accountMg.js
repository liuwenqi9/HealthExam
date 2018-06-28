

var updataAccid;
		$(function() {
			$(".changeState").click(function() {
				var currentState = $(this).attr("title");
				$.ajax({
					type : "POST",
					url : "changeAccountState.action",
					data : {
						"accountId" : $(this).attr("value"),
						"state" : $(this).attr("title")
					},
					success : function(result) {
						window.location.reload(); //刷新
					}

				});
			});

			$("#updataDept").click(
					function() {
						$.ajax({
							url : "upataAccName.action",
							type : "post",
							dataType : "text",
							data : {
								'account' : updataAccid,
								'name' : $("#updataName").val()

							},
							success : function(data) {
								if (data == "OK") {
									alert("修改成功")
									var formNode = document
											.getElementById("updata-form");

									formNode.action = 'AccountMg.action';
									formNode.submit();

								} else if (data == "FAIL") {

									alert("已存在");

								}
							}
						})

					})

		});

		function updataBtn(node) {
			$('#updata-modal').modal('show')
			var chileArr = node.parentElement.parentElement.parentElement; // 获取当前节点的所需要的父级节点
			var nodes = filterSpaceNode(chileArr);
			var rowNum = nodes.rowIndex; // 当前点击行号
			updataAccid = document.getElementById('grid-table').rows[rowNum].cells[1].innerText; //获取要修改的参数名称

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