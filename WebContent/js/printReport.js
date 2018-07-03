var lodop;
var currentDate;

var req = new Vue({
	el:"#dataBind",
	data:{
		guideCode:"", //导检号
		itemList:[], //项目列表
		detailList:[], //项目报告
		allSummary:"", //总结报告
		peopleMsg:"" //体检人信息
	},
	methods:{
		checkGuide:function(){
			
			req.guideCode = req.guideCode.replace(/\s|\xA0/g, "");
			if(req.guideCode != ""){
				
				//AJAX获取各个科室项目数据返回
				$.ajax({
					url:"searchGuideCode.action",
					data:{"guideCode":req.guideCode},
					method:"post",
					dataType:"json",
					success:function(data){					
						/*
						 * data 返回的数据 要有项目集合，单个项目的细项和报告
						 */		
						if(data.noData != -1){
							req.itemList = data.items;
							req.detailList = data.list;
							req.allSummary = data.allSummary;
							req.peopleMsg = data.peopleMsg;
						}else{
							alert("该导检号不存在!");
						}
					},
					error:function(){
						alert("数据获取失败，请确认是否联网！");
					}
				})
			}else{
				alert("请输入导检号！");
			}
		},
		CheckIsInstall:function(){
			
			lodop = window.CLODOP;
			var printDate = new Date();
			currentDate = printDate.getFullYear() + "-" + printDate.getMonth() + "-" + printDate.getDate();
			pageHead();
		}
	}
})

//第一页 --- 封面也
function pageHead(){
	
	//第一页内容
	LODOP.PRINT_INITA(12,13,845,911,"打印测试...");
	LODOP.ADD_PRINT_TEXT(567,175,397,109,"     健康体检中心\r\n 体    检    报   单");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",25);
	LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
	LODOP.ADD_PRINT_TEXT(24,5,308,19,"健   康   体   检   中   心");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_TEXT(111,133,534,20,"公司：");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(157,131,329,31,"公司账户：" + req.peopleMsg.account);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(212,134,193,25,"姓名：" + req.peopleMsg.name);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(215,455,110,31,"性别：" + req.peopleMsg.sex);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(260,133,100,25,"年龄：" + req.peopleMsg.age);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(261,454,265,26,"手机：" + req.peopleMsg.telephone);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(344,192,191,34,"打印日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	LODOP.ADD_PRINT_BARCODE(316,418,100,60,"QRCode","传一科技");
	
	LODOP.NewPage();
	//承接下一页
	secondPage();
}

//第二页 --- 欢迎页
function secondPage(){
	
	LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
	LODOP.ADD_PRINT_TEXT(24,5,308,19,"健   康   体   检   中   心");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_TEXT(189,112,197,36,"尊敬的：");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(244,119,577,190,"    感谢您来到传一健康中心进行健康体检！\r\n\r\n 为了增加您对健康体检的认识，我们在此特别向您说明，健康体检检查的目的在于及时的了解自身的健康状况，提高健康保健意识，如果此次检查在正常范围内，只表示您选择的体检项目所反映的身体健康状况，由于体检手段及项目所限，并不能完全排除身体潜在疾病，若有疾病出现，请您及时到医院就医。");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(444,113,548,94,"   “健康是人生最宝贵的。”不良的生活习惯和行为会损坏您的健康，我们真诚希望您保持科学健康的生活方式，定期接受健康检查，在您最需要的时候请随时与我们联系，欢迎您再次光临传一健康中心。");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(554,159,232,28,"祝您，健康快乐！");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	
	LODOP.NewPage();
	thirdPage();
	
}

//第三页 --- 体检项目列表
function thirdPage(){
	
	LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
	LODOP.ADD_PRINT_TEXT(24,5,308,19,"健   康   体   检   中   心");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_TEXT(114,78,152,37,"体检项目列表");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	LODOP.ADD_PRINT_HTM(190,102,598,570,document.getElementById("pplItems").innerHTML);
	
	LODOP.NewPage();
	fourthPage();
}

//第四页 --- 医生总结
function fourthPage(){
	
	LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
	LODOP.ADD_PRINT_TEXT(17,11,308,19,"健   康   体   检   中   心");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_SHAPE(1,145,39,744,1,0,1,"#C0C0C0");
	LODOP.ADD_PRINT_TEXT(104,44,322,36,"体   检   总   结   及   建   议");
	LODOP.SET_PRINT_STYLEA(0,"FontName","华文新魏");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",19);
	LODOP.ADD_PRINT_TEXT(762,304,205,20,"总结日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
	LODOP.ADD_PRINT_TEXT(763,562,214,20,"总结医生：");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.NewPage();
	fifthPage();
}

//第五页 --- 生活健康指导
function fifthPage(){
	
	LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
	LODOP.ADD_PRINT_TEXT(17,11,308,19,"健   康   体   检   中   心");
	LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
	LODOP.ADD_PRINT_SHAPE(1,145,39,744,1,0,1,"#C0C0C0");
	LODOP.ADD_PRINT_TEXT(105,56,322,36,"生活保健指导");
	LODOP.SET_PRINT_STYLEA(0,"FontName","华文新魏");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",19);
	LODOP.ADD_PRINT_TEXT(762,304,205,20,"总结日期：" + currentDate);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",11);
	LODOP.ADD_PRINT_TEXT(763,562,214,20,"指导医生：罗杭春");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
	LODOP.ADD_PRINT_TEXT(201,40,708,185,"一、保持健康的生活方式\r\n （1）健康的饮食习惯：食物多样，谷类为主；适当吃季节性蔬菜；吃适量乳类、豆类制品；吃适量新鲜有鳞鱼、蛋、瘦肉，超吃肥肉和荤油；食量与活动要平衡，监测体重，吃清淡少盐食物。\r\n （2）戒烟戒酒：不但要避免吸烟也要避免被动吸烟，不饮酒或饮少量红葡萄酒。\r\n （3）适量规律运动：能够预防很多慢性疾病，包括冠心病、高血压、糖尿病、骨质疏松等。\r\n （4）保持心里平衡：愉悦的心情更有益于健康。");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.ADD_PRINT_TEXT(425,40,693,213,"二、超重\r\n 保持健康体重，对于体重超重者\r\n 1、有利于控制血压\r\n    健康体重有利于预防高血压的发生，已患高血压者，减轻体重能起到改善血压的作用，也可以减少降压药的剂量和次数，有研究表明体重每降低1公斤，可以时血压降低1-2mmHg。\r\n 2、能帮助调节血糖\r\n    控制体重可增加人体调节血糖的能力，而血糖的稳定对健康是非常重要的，因为长期的血糖偏高可以增加患糖尿病、冠心病和中风的危险性。\r\n 3、避免多余脂肪在体内贮存。");
	LODOP.SET_PRINT_STYLEA(0,"FontName","楷体");
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.NewPage();
	sixthPage();
}

//第六页 --- 项目检查报告
function sixthPage(){
	
	for (var i = 0; i < req.itemList.length; i++) {
		LODOP.ADD_PRINT_LINE(52,-95,51,855,0,1);
		LODOP.ADD_PRINT_TEXT(17,11,308,19,"健   康   体   检   中   心");
		LODOP.SET_PRINT_STYLEA(0,"FontName","隶书");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
		LODOP.ADD_PRINT_TEXT(31,626,174,16,"体检日期：" + currentDate);
		LODOP.ADD_PRINT_HTM(190,102,598,570,document.getElementById(i).innerHTML);
		LODOP.NewPage();
	}	
	lodop.PREVIEW();
}
