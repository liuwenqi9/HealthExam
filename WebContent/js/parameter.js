/**
 * 
 */

var updataparamid ;

$(function() {

	$("#insertDept").click(function() {
		$.ajax({
			url : "insertparamMg.action",
			type : "post",
			dataType : "text",
			data : {
				"paramname" : $("#paramname").val()

			},
			success : function(data) {
				if (data == "OK") {
					alert("添加成功");
					var formNode = document.getElementById("add-form");
					var basepath = formNode.getAttribute("path");

					formNode.action = 'paramMg.action';
					formNode.submit();

				} else if (data == "FAIL") {

					alert("已存在");

				}
			}
		})

	})
	
	
	$("#changeDept").click(function(){
		$.ajax({
			url : "updataparamMg.action",
			type : "post",
			dataType : "text",
			data : {
				"paramname" : $("#changeName").val(),
                "parameterid"  :updataparamid
			},
			success : function(data) {
				if (data == "OK") {
					alert("修改成功")
					var formNode = document.getElementById("change-form");

					formNode.action = 'paramMg.action';
					formNode.submit();

				} else if (data == "FAIL") {

					alert("已存在");

				}
			}
		})
		
	})
	
	

})

function updataParam(node){	
	$('#change-modal').modal('show')
	var chileArr = node.parentElement.parentElement.parentElement;  // 获取当前节点的所需要的父级节点
	var nodes = filterSpaceNode(chileArr); 
	var rowNum = nodes.rowIndex;  // 当前点击行号
	updataparamid = document.getElementById('dynamic-table').rows[rowNum].cells[0].innerText;  //获取要修改的参数名称
	
}


function deleteParam(node) {

	var con;
	con = confirm("确定删除吗？"); // 在页面上弹出对话框
	if (con == true) {
		var chileArr = node.parentElement.parentElement.parentElement;  // 获取当前节点的所需要的父级节点
		var nodes = filterSpaceNode(chileArr); 
		var rowNum = nodes.rowIndex;  // 当前点击行号
		var paramname = document.getElementById('dynamic-table').rows[rowNum].cells[1].innerText;
		alert(paramname);
		$.ajax({
			url : "deleteparamMg.action",
			type : "post",
			dataType : "text",
			data : {
				"paramname" :paramname,
			},
			success : function(data) {
				if (data == "OK") {
					alert("删除成功");
					var formNode = document.getElementById("add-form");
					var basepath = formNode.getAttribute("path");

					formNode.action = 'paramMg.action';
					formNode.submit();
				} else if (data == "FAIL") {

					alert("参数被使用中，无法删除");

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

// function showRowIndex(ObjTd) {
// var objTr = ObjTd.parentElement;
// var rowNum = objTr.rowIndex;
// alert(rowNum);
// var a =
// document.getElementById('dynamic-table').rows[rowNum].cells[0].innerText;
// alert(a);
// }
