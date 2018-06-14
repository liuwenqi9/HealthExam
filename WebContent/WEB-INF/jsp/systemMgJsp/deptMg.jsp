<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="no-skin">
	<div>
		<div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
			<div class="row">
				<div class="col-xs-6">
					<div class="dataTables_lenght" id="dynamic-table_length">
						<label>
							"显示"
							<select name="dynamic-table_length" aria-controls="dynamic-table" class="form-control input-sm">
								<option value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option value="40">40</option>
							</select>
							"条数"
						</label>
					</div>
				</div>
				<div class="col-xs-6">
					<div id="dynamic-table_filter" class="dataTables_filter">
						<label>
							"搜索"
							<input type="text" class="form-control input-sm" placeholder="科室 " aria-controls="dynamic-table">
						</label>
					</div>
				</div>			
			</div>
			<table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dynamic-table_info">
				<thead>
					<tr role="row">
						<th class="center sorting_disabled" rowspan="1" colspan="1" aria-label="">
							<label class="pos-rel">
								<input type="checkbox" class="ace">
								<span class="lbl"></span>
							</label>
						</th>
						<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending">
							"Price"
						</th>
						<th class="hidden-480 sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Click: activate to sort column ascending">
							"Click"
						</th>
						<th class="sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending">
							<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
							"Update"
						</th>
						<th class="hidden-480 sorting" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">
							"Status"
						</th>
						<th class="sorting_disabled" rowspan="1" colspan="1" aria-label></th>
					</tr>
				</thead>
				<tbody>
					<tr role="row" class="odd">
						<td class="center">
							<input type="checkbox" class="ace">
							<span class="lbl"></span>
						</td>
						<td>
							<a href="#" >a标签</a>
						</td>
						<td class="sorting_1">$20</td>	
						<td class="hidden-480">1,000</td>					
						<td class="sorting_1">Apr</td>
						<td class="hidden-480">1,000</td>
						<td class="label label-sm label-info arrowed arrowed-righ">
							"Sold"
						</td>
						<td>
							<div class="hidden-sm hidden-xs action-buttons">
								<a class="blue" href="#">
									<i class="ace-icon fa fa-search-plus bigger-130"></i>
								</a>
								<a class="green" href="#">
									<i class="ace-icon fa fa-pencil bigger-130"></i>
								</a>
								<a class="red" href="#">
									<i class="ace-icon fa fa-trash-o bigger-130"></i>
								</a>
							</div>
							<div class="hidden-md hidden-lg">
								<div class="inline pos-rel">
									<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto" aria-expanded="false">
										<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
									</button>
									<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="blue">
													<i class="ace-icon fa fa-search-plus bigger-120"></i>
												</span>
											</a>
										</li>
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="green">
													<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
												</span>
											</a>
										</li>
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="red">
													<i class="ace-icon fa fa-trash-o bigger-120"></i>
												</span>
											</a>
										</li>
									</ul>				
								</div>
							</div>				
						</td>				
					</tr>				
					<tr role="row" class="even">
						<td class="center">
							<input type="checkbox" class="ace">
							<span class="lbl"></span>
						</td>
						<td>
							<a href="#" >a标签</a>
						</td>
						<td class="sorting_1">$20</td>	
						<td class="hidden-480">1,000</td>					
						<td class="sorting_1">Apr</td>
						<td class="hidden-480">1,000</td>
						<td class="label label-sm label-info arrowed arrowed-righ">
							"Flagged"
						</td>
						<td>
							<div class="hidden-sm hidden-xs action-buttons">
								<a class="blue" href="#">
									<i class="ace-icon fa fa-search-plus bigger-130"></i>
								</a>
								<a class="green" href="#">
									<i class="ace-icon fa fa-pencil bigger-130"></i>
								</a>
								<a class="red" href="#">
									<i class="ace-icon fa fa-trash-o bigger-130"></i>
								</a>
							</div>
							<div class="hidden-md hidden-lg">
								<div class="inline pos-rel">
									<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto" aria-expanded="false">
										<i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
									</button>
									<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="blue">
													<i class="ace-icon fa fa-search-plus bigger-120"></i>
												</span>
											</a>
										</li>
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="green">
													<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
												</span>
											</a>
										</li>
										<li>
											<a href="#" class="tooltip-info" data-rel="tooltip" title="View">
												<span class="red">
													<i class="ace-icon fa fa-trash-o bigger-120"></i>
												</span>
											</a>
										</li>
									</ul>			
								</div>
							</div>				
						</td>	
					</tr>		
				</tbody>
			</table>
			<div class="row">
				<div class="col-xs-6">
					<div class="dataTables_info" id="dynamic-table_info" role="status" aria-live="polite" >Showing 1 to 10 of 23 entries</div>
				</div>
				<div class="col-xs-6">
					<div class="dataTables_paginate paging_simple_numbers" id="dynamic-table_paginate">
						<ul class="pagination">
							<li class="paginate_button previous disabled" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_previous">
								<a href="#">上一页</a>
							</li>
							<li class="paginate_button previous disabled" aria-controls="dynamic-table" tabindex="0">
								<a href="#">1</a>
							</li>
							<li class="paginate_button previous disabled" aria-controls="dynamic-table" tabindex="0" id="dynamic-table_next">
								<a href="#">下一页</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>