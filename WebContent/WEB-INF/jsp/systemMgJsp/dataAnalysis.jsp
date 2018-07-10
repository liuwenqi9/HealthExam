<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
		<%@ include file="header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8" />
		<title>数据统计与分析</title>
		<style type="text/css">
			td,th {
	text-align: center;
}
		</style>

	</head>
</head>
<body class="no-skin">
		<%@ include file="menu.jsp"%>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i></li>
						<li class="active">统计查询</li><li>数据与统计分析</li>
					</ul>

					<!-- /.breadcrumb -->
				</div>
				<%--这里添加代码  --%>
				<div class="widget-box widget-color-blue ui-sortable-handle">
						<div class="widget-header" >
							<h5 class="widget-title bigger lighter">
							<font style="vertical-align: inherit;">
								数据统计
								<span style="float:right" id="sp_sysTime"></span>
							</font>
							</h5>
							</div>
						</div>
						
				<div>
				<!-- 在这里添加图标，先来一个静态的 -->
				
				
				<div id="canvas-holder" style="width: 100%;color: yellow;">
				<div style="display: inline-block;">
					<canvas id="myChart" width="500px" height="500px"></canvas>
				</div>
				<div style="display: inline-block;">
					<canvas id="myChart2" width = "500px" height = "500px"></canvas>
				</div>
			</div>
		<!-- 	捆绑式构建 -->
				
				</div>
				<%--上面添加代码  --%>
				
				<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							ShuaiFanDare © 2017 - 2018
						</span>
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../js/ace-master/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<%@ include file="footer.jsp"%>
		<script type="text/javascript">
		$(function(){
			setInterval('sysTime()',1000);
			
			barGraph();
			AreaGraph();
		});
			
			
		
		function sysTime() {
			var today = new Date();// 系统时间（今天）
			var dateAndTime = today.toLocaleString();
			$("#sp_sysTime").html(dateAndTime+"&nbsp;&nbsp;"); 
		}
		//构建条形图
		function barGraph() {
		/* 	<c:forEach items="${hotList}" var="hot">
	        alert("${hot.getPackname()}"+"${hot.getTotal()}");
	    	</c:forEach> */
			
			var ctx = document.getElementById("myChart");
			var b = ['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'];
 
           
           
           
            
			var myChart = new Chart(ctx, {
			    type: 'bar',
			    data: {
			        labels: ${ordinate},//["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],//这里添加项目名称
			        datasets: [{
			            label: '套餐热度排行榜',//这里添加表格名称
			            data: ${abscissa},
			            backgroundColor: 
			            	b,
			            borderColor: [
			                'rgba(255,99,132,1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 206, 86, 1)',
			                'rgba(75, 192, 192, 1)',
			                'rgba(153, 102, 255, 1)',
			                'rgba(255, 159, 64, 1)'
			            ],
			            borderWidth: 1
			        }]
			    },
			    options: {
			        scales: {
			            yAxes: [{
			                ticks: {
			                    beginAtZero:true
			                }
			            }]
			        }
			    }
			});
			
		};
		function AreaGraph() {
			/* 	<c:forEach items="${hotList}" var="hot">
		        alert("${hot.getPackname()}"+"${hot.getTotal()}");
		    	</c:forEach> */
				
				var ctx = document.getElementById("myChart2");
				var b = ['rgba(255, 99, 132, 0.2)','rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)','rgba(153, 102, 255, 0.2)','rgba(255, 159, 64, 0.2)'];
	 
	           
	           
	           
	            
				var myChart = new Chart(ctx, {
				    type: 'polarArea',
				    data: {
				        labels: ${ordinate},//["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],//这里添加项目名称
				        datasets: [{
				            label: '套餐热度排行榜',//这里添加表格名称
				            data: ${abscissa},
				            backgroundColor: 
				            	b,
				            borderColor: [
				                'rgba(255,99,132,1)',
				                'rgba(54, 162, 235, 1)',
				                'rgba(255, 206, 86, 1)',
				                'rgba(75, 192, 192, 1)',
				                'rgba(153, 102, 255, 1)',
				                'rgba(255, 159, 64, 1)'
				            ],
				            borderWidth: 1
				        }]
				    },
				    options: {
				        scales: {
				            yAxes: [{
				                ticks: {
				                    beginAtZero:true
				                }
				            }]
				        }
				    }
				});
				
			};
	
		
		</script>
	</div>	
</body>
</html>