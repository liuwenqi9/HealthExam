
$.ajax({
	url:"getExamPeople.action",
	metoht:"post",
	dataType:"json",
	success:function(data){
		req.ppList = data.depModel;
		req.pageCount = data.pageContanier;
		req.currentPage = 1;
		req.searchBtn = false;
	},
	error:function(){
		alert("获取失败，请检查是否连接网络！");
	}
})

var req = new Vue({
	el:"#dataBind",
	data:{
		ppList:[], //人员
		pageCount:[], //页数
		currentPage:"", //当前页面
		ppObj:[], //人员详情
		detailCount:[], //当前订单信息分页
		detailPage:"" ,//详情当前页
		currentName:"",
		searchModel:{
			name:"",
			phone:"",
			barcode:"",
			startTime:"",
			endTime:""
		}, //多条件搜索
		searchBtn:"" //是否启用查询
	},
	methods:{
		showModal:function(name, no){
			req.currentName = name; 
			$("#people-modal").modal("show");
			$.ajax({
				url:"showPeopelDetail.action",
				data:{"name":name},
				method:"post",
				dataType:"json",
				success:function(data){
					req.ppObj = data.peopleDetail;
					req.detailCount = data.DetailContanier;
					req.detailPage = 1;
				},
				error:function(){
					alert("获取失败，请检查是否连接网络！");
				}
			})
		},
		searchItem:function(){ //查询事务
			
			if(req.searchModel.name != ""){
				req.searchModel.name = req.searchModel.name.replace(/\s|\xA0/g, ""); //体检人，去除所有空格
			}else{
				req.searchModel.name = "";
			}
			

			if(req.searchModel.phone != ""){
				req.searchModel.phone = req.searchModel.phone.replace(/\s|\xA0/g, ""); //体检人，去除所有空格
			}else{
				req.searchModel.phone = "";
			}
			
			if(req.searchModel.barcode != ""){
				req.searchModel.barcode = req.searchModel.barcode.replace(/\s|\xA0/g, ""); //体检人，去除所有空格
			}else{
				req.searchModel.barcode = "";
			}
			
			if(req.searchModel.startTime != ""){
				if(req.searchModel.endTime == ""){
					alert("请选择截止日期")
					return;
				}
			}
			
			if(req.searchModel.endTime != ""){
				if(req.searchModel.startTime == ""){
					alert("请选择起始日期")
					return;
				}
				req.searchModel.startTime = req.searchModel.startTime + " 00:00";
				req.searchModel.endTime = req.searchModel.endTime + " 23:59";
			}
			req.searchBtn = true;
			req.pageItem(1);
		},
		pageItem:function(page){
			
			if(page < 1){ 
				page = 1; 
			}else if(page > req.pageCount.length){
				page = req.pageCount.length;
			}
			req.currentPage = page;
			
			$.ajax({
				url:"pageAndsearch.action",
				data:{currentPage:req.currentPage, searchModel:JSON.stringify(req.searchModel), isSearch:req.searchBtn},
				method:"post",				
				dataType:"json",
				success:function(data){
					req.ppList = data.depModel;
					req.pageCount = data.pageContanier;
				},
				error:function(){
					alert("异常！请检查是否联网，或者其他内部错误");
				}
			})
		},
		exportExcel:function(){
			
			//数据源
			var excelList = [];
			for(let i = 0 ; i < req.ppList.length ; i++ ){
				var ppl=  { name:"", telephone:"", account:"", barcode:"", guideidCard:""};
		    	ppl.name = req.ppList[i].name;
		        ppl.telephone = req.ppList[i].telephone;
		        ppl.account = req.ppList[i].account;
		        ppl.barcode = req.ppList[i].barcode;
		        ppl.guideidCard = req.ppList[i].guideidCard;  	 
		        excelList.push(ppl);
		     }
			console.log(JSON.stringify(excelList));
			//列标题，逗号隔开，每一个逗号就是隔开一个单元格
		     let str = `体检人,联系电话,所属账户,条码号,办理次数\n`;
		     
		     //增加\t为了不让表格显示科学计数法或者其他格式
		     for(let i = 0 ; i < excelList.length ; i++ ){		    	 
		         for(let item in excelList[i]){    		 
		        	 str+=`${excelList[i][item] + '\t'},`; 
		         }
		         str+='\n';
		     }
		   //encodeURIComponent解决中文乱码
		   let uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);   
		   //通过创建a标签实现
		   var link = document.createElement("a");
		   link.href = uri;
		   //对下载的文件命名
		   link.download = "体检人员表.csv";
		   document.body.appendChild(link);
		   link.click();
		   document.body.removeChild(link);
		}
	}
})
