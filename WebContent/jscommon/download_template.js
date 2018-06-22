/**
 * @author JSY
 * @Date 6月 19日
 * 下载模板js文件
 */
$(function () {
	//initiate dataTables plugin
	/* var buttonCommon = {
		        exportOptions: {
		            format: {
		                body: function ( data, row, column, node ) {
		                    // Strip $ from salary column to make it numeric
		                    return column === 5 ?
		                        data.replace( /[$,]/g, '' ) :
		                        data;
		                }
		            }
		        }
		    };*/
	

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
		 /* columns: [
	            { data: '（体检）员工身份证' },
	            { data: '（体检）员工年龄' },
	            { data: '（体检）员工联系电话' }
	           
	        ],*/
		
		
		
		bAutoWidth: false,
		"aoColumns": [
		  { "bSortable": false },
		  null, null,null, null, null,
		  { "bSortable": false }
		],
		"aaSorting": [],
		
		select: {
			style: 'multi'
		}
    } );

	
	
	$.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';
	
	new $.fn.dataTable.Buttons( myTable, {
		buttons: [
		/*  {
			extend: "colvis",
			text: "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
			className: "btn btn-white btn-primary btn-bold",
			columns: ':not(:first):not(:last)'
		  },*/
	/*  {
			extend: "copy",
			text: "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
			className: "btn btn-white btn-primary btn-bold"
		  },*/
		 /* {
			extend: "csv",
			title: '传一人民医院-企业注册人员模板',
			text: "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>下载模板</span>",
			className: "btn btn-white btn-primary btn-bold"
		  },*/
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
		  
		 /*,{
			extend: "pdf",
			text: "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
			className: "btn btn-white btn-primary btn-bold"
		  },*/
		/*{
			extend: "print",
			text: "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
			className: "btn btn-white btn-primary btn-bold",
			autoPrint: false,
			message: 'This print was produced using the Print button for DataTables'
		  }	*/  
		]
	} );
	myTable.buttons().container().appendTo( $('.tableTools-container') );
	
	//style the message box
	//复制所以数据
	/*var defaultCopyAction = myTable.button(1).action();
	myTable.button(1).action(function (e, dt, button, config) {
		defaultCopyAction(e, dt, button, config);
		$('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
	});*/
	
	//显示，隐藏列
/*	var defaultColvisAction = myTable.button(0).action();
	myTable.button(0).action(function (e, dt, button, config) {
		
		defaultColvisAction(e, dt, button, config);
		
		
		if($('.dt-button-collection > .dropdown-menu').length ==1) {
			$('.dt-button-collection')
			.wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
			.find('a').attr('href', '#').wrap("<li />")
		}
		$('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
	});*/

	////
	//提示语
	setTimeout(function() {
		$($('.tableTools-container')).find('a.dt-button').each(function() {
			var div = $(this).find(' > div').first();
			if(div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
			else $(this).tooltip({container: 'body', title: $(this).text()});
		});
	}, 500);
	
	
	
	
	//	全选、全不选
	/*myTable.on( 'select', function ( e, dt, type, index ) {
		if ( type === 'row' ) {
			$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', true);
		}
	} );
	myTable.on( 'deselect', function ( e, dt, type, index ) {
		if ( type === 'row' ) {
			$( myTable.row( index ).node() ).find('input:checkbox').prop('checked', false);
		}
	} );*/



//复选框
	/////////////////////////////////
	//table checkboxes
	/*$('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);*/
	
	//select/deselect all rows according to table header checkbox
	/*$('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function(){
		var th_checked = this.checked;//checkbox inside "TH" table header
		
		$('#dynamic-table').find('tbody > tr').each(function(){
			var row = this;
			if(th_checked) myTable.row(row).select();
			else  myTable.row(row).deselect();
		});
	});*/
	
	//select/deselect a row when the checkbox is checked/unchecked
	/*$('#dynamic-table').on('click', 'td input[type=checkbox]' , function(){
		var row = $(this).closest('tr').get(0);
		if(this.checked) myTable.row(row).deselect();
		else myTable.row(row).select();
	});*/



	/*$(document).on('click', '#dynamic-table .dropdown-toggle', function(e) {
		e.stopImmediatePropagation();
		e.stopPropagation();
		e.preventDefault();
	});*/
	
	
	
	
	
	

	

	/********************************/
	//add tooltip for small view action buttons in dropdown menu
	/*$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
	
	//tooltip placement on right or left
	function tooltip_placement(context, source) {
		var $source = $(source);
		var $parent = $source.closest('table')
		var off1 = $parent.offset();
		var w1 = $parent.width();

		var off2 = $source.offset();
		//var w2 = $source.width();

		if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
		return 'left';
	}*/
	
	
	
	
	/***************/
	/*$('.show-details-btn').on('click', function(e) {
		e.preventDefault();
		$(this).closest('tr').next().toggleClass('open');
		$(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
	});*/
	/***************/
	
	
	
	
	
	
	
	
});