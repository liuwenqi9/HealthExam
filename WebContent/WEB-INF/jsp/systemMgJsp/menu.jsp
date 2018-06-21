<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<div id="navbar" class="navbar navbar-default          ace-save-state">
	<div class="navbar-container ace-save-state" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>

			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<div class="navbar-header pull-left">
			<a href="index.html" class="navbar-brand"> <small> <i
					class="fa fa-leaf"></i> 健康体检团检后台管理系统
			</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav" style="">

				<li class="light-blue dropdown-modal"><a data-toggle="dropdown"
					href="#" class="dropdown-toggle"> <span class="user-info">
							<small>欢迎</small> <%=session.getAttribute("WorkerName")%>
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="updatePwd.action"> <i
								class="ace-icon fa fa-power-off"></i> 修改密码
						</a></li>
						<li><a href="<%=request.getContextPath()%>/jsp/login.action">
								<i class="ace-icon fa fa-power-off"></i> 退出
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-container -->
</div>
<div class="main-container ace-save-state" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.loadState('main-container')
		} catch (e) {
		}
	</script>
</div>

<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state"
	data-sidebar="true" data-sidebar-scroll="true"
	data-sidebar-hover="true">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>

	<ul class="nav nav-list" style="top: 0px;">
		<li class=""><a href="index.action"> <i
				class="menu-icon fa fa-desktop"></i> <span class="menu-text">
					首页 </span>
		</a> <b class="arrow"></b></li>

		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					系统管理 </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">

				<li class=""><a href="AccountMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 团检单位设置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="workerMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 人员设置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="roleMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 角色配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="powerMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 权限配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="menuMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 菜单配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="deptMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 科室设置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="detailMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 细项配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="itemMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 项目配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="mealMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 套餐配置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="queryLog.action"> <i
						class="menu-icon fa fa-caret-right"></i> 日志查看
				</a> <b class="arrow"></b></li>

				<li class=""><a href="paramMg.action"> <i
						class="menu-icon fa fa-caret-right"></i> 参数管理
				</a> <b class="arrow"></b></li>

			</ul></li>

		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					体检工作</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="charge.action"> <i
						class="menu-icon fa fa-caret-right"></i> 记账
				</a> <b class="arrow"></b></li>

				<li class=""><a href="settleAccount.action"> <i
						class="menu-icon fa fa-caret-right"></i> 团检结算
				</a> <b class="arrow"></b></li>

				<li class=""><a href="squareAccount.action"> <i
						class="menu-icon fa fa-caret-right"></i> 团检单位结款
				</a> <b class="arrow"></b></li>

				<li class=""><a href="printGuide.action"> <i
						class="menu-icon fa fa-caret-right"></i> 打印导检单和条码
				</a> <b class="arrow"></b></li>

				<li class=""><a href="printReport.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检报告打印
				</a> <b class="arrow"></b></li>

				<li class=""><a href="returnMoney.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检退费
				</a> <b class="arrow"></b></li>
			</ul></li>


		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					统计查询</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="allQuery.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检综合查询
				</a> <b class="arrow"></b></li>

				<li class=""><a href="examPersonQuery.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检人员查询
				</a> <b class="arrow"></b></li>

				<li class=""><a href="checkAccount.action"> <i
						class="menu-icon fa fa-caret-right"></i> 团检单位对账
				</a> <b class="arrow"></b></li>

			</ul></li>

		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					医生工作站</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="acceptItem.action"> <i
						class="menu-icon fa fa-caret-right"></i> 项目接收
				</a> <b class="arrow"></b></li>

				<li class=""><a href="summary.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检小结
				</a> <b class="arrow"></b></li>

				<li class=""><a href="allSummary.action"> <i
						class="menu-icon fa fa-caret-right"></i> 体检总结
				</a> <b class="arrow"></b></li>

			</ul></li>


		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					辅助功能</span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="updatePassword.action"> <i
						class="menu-icon fa fa-caret-right"></i> 修改密码
				</a> <b class="arrow"></b></li>

				<li class=""><a href="logRecord.action"> <i
						class="menu-icon fa fa-caret-right"></i> 日志记录
				</a> <b class="arrow"></b></li>

			</ul></li>

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon"
			class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>