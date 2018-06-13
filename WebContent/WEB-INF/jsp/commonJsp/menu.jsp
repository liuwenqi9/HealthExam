<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

    	<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							后台管理系统
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav" style="">
						
						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>欢迎,</small>
									<%=session.getAttribute("WorkerName") %>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="<%=request.getContextPath() %>/jsp/login.jsp">
										<i class="ace-icon fa fa-power-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state" data-sidebar="true" data-sidebar-scroll="true" data-sidebar-hover="true">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				<ul class="nav nav-list" style="top: 0px;">
					<li class="">
						<a href="index.jsp">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text"> 首页 </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text">
								卡片管理
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">

							<li class="">
								<a href="cardStorage.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									卡入库
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="cardCancellation.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									卡注销
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="cardQuery.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									卡查询
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="cardApproval.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									领卡审批
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="collarCard.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									领卡
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="saleCard.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									售卡
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="backCard.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									退卡
								</a>

								<b class="arrow"></b>
							</li>
							
							<li class="">
								<a href="changeCard.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									换卡
								</a>

								<b class="arrow"></b>
							</li>

						</ul>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 系统管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a href="personManage.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									人员管理
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="permissionConfig.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									权限配置
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="menuManage.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									菜单管理
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="doctorScheduling.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									医生排班
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="logView.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									日志查看
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="parameterManage.jsp">
									<i class="menu-icon fa fa-caret-right"></i>
									参数管理
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					
				</ul><!-- /.nav-list -->

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>
