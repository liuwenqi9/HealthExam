/**
 * @author JSY
 * @Date 6月 19日
 * 下载模板js文件
 */
$(function () {
	
	

	var myTable =$('#dynamic-table').DataTable( {
		language: {  
		      "sProcessing": "处理中...",  
		      "sLengthMenu": "显示 _MENU_ 项结果",  
		      "sZeroRecords": "没有匹配结果",  
		      "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",  
		      "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",  
		      "sInfoFiltered": "(由 _MAX_ 项结果过滤)",  
		      "sInfoPostFix": "",  
		      "sSearch": "搜索:",  
		      "sUrl": "",  
		      "sEmptyTable": "表中数据为空",  
		      "sLoadingRecords": "载入中...",  
		      "sInfoThousands": ",",  
		      "oPaginate": {  
		          "sFirst": "首页",  
		          "sPrevious": "上页",  
		          "sNext": "下页",  
		          "sLast": "末页"  
		      },  
		     
		      "oAria": {  
		          "sSortAscending": ": 以升序排列此列",  
		          "sSortDescending": ": 以降序排列此列"  
		      }
		     
		  }, 
		     
		  
		  columnDefs: [{
		       targets:[3,5,6],//指定哪几列
		       render: function(data){
		               return "\u200C" + data ; 
		         }
		    }],
		
		
		
		bAutoWidth: false,
		"aoColumns": [
		  { "bSortable": false },
		  null, null,null, null, null,
		  { "bSortable": false }
		],
		"aaSorting": [],
		
		select: {
			style: 'multi'
		},
		  "bSort": false, //排序功能
			 "bPaginate": false, //翻页功能
			 "bLengthChange": false, 
			 "bInfo": false,//页脚信息
			 "searching" : false,
		  
    } );

		
	$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
	
	new $.fn.dataTable.Buttons( myTable, {
		buttons: [
		
			 {
		 			
	            extend: 'excelHtml5',
            	title: '传一人民医院-企业登记人员模板',
    			text: "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>下载模板</span>",
    			className: "btn btn-white btn-primary btn-bold",
    			exportOptions: {  
                       'modifier': {  
                            'page': 'current'  
                       }  
                    } 
			 }
		   
		]
	} );
	myTable.buttons().container().appendTo( $('.tableTools-container') );

	//提示语
	setTimeout(function() {
		$($('.tableTools-container')).find('a.dt-button').each(function() {
			var div = $(this).find(' > div').first();
			if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
			else $(this).tooltip({container: 'body', title: $(this).text()});
		});
	}, 500);
	
});