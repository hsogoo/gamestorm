<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
	<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
	<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	<div class="page-sidebar navbar-collapse collapse">
		<!-- BEGIN SIDEBAR MENU -->
		<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
		<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
		<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
		<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<ul class="page-sidebar-menu page-sidebar-menu-light" data-keep-expanded="true" data-auto-scroll="true" data-slide-speed="200">
			<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
			<li class="sidebar-toggler-wrapper">
				<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				<div class="sidebar-toggler">
				</div>
				<!-- END SIDEBAR TOGGLER BUTTON -->
			</li>
			<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
			<li class="sidebar-search-wrapper">
				<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
				<!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
				<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
				<form class="sidebar-search " action="extra_search.html" method="POST">
					<a href="javascript:;" class="remove">
					<i class="icon-close"></i>
					</a>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="订单查询...">
						<span class="input-group-btn">
						<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
						</span>
					</div>
				</form>
				<!-- END RESPONSIVE QUICK SEARCH FORM -->
			</li>
			<#if menuId?number == 0><li class="start active open"><#else><li class="start"></#if>
				<a href="javascript:;">
				<i class="icon-home"></i>
				<span class="title">控制台</span>
				<span class="selected"></span>
				<span class="arrow open"></span>
				</a>
			</li>
			<#if menuId?number == 1><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-settings"></i>
				<span class="title">游戏管理</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="/backend/game/manage">
						<i class="icon-list"></i>
						游戏列表</a>
					</li>
					<li>
						<a href="/backend/category/manage">
						<i class="icon-list"></i>
						类目列表</a>
					</li>
					<li>
						<a href="/backend/gameCategory/manage">
						<i class="icon-link"></i>
						游戏类目管理</a>
					</li>
				</ul>
			</li>
			<#if menuId?number == 2><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-present"></i>
				<span class="title">商品管理</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="/backend/product/manage">
						<i class="icon-list"></i>
						商品列表</a>
					</li>
				</ul>
			</li>
			<#if menuId?number == 3><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-basket"></i>
				<span class="title">订单管理</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="/backend/order/manage">
						<i class="icon-list"></i>
						订单列表</a>
					</li>
				</ul>
			</li>
			<#if menuId?number == 4><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-user"></i>
				<span class="title">用户管理</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="components_pickers.html">
						<i class="icon-list"></i>
						用户列表</a>
					</li>
					<li>
						<a href="components_dropdowns.html">
						<i class="icon-bar-chart"></i>
						会员等级设置</a>
					</li>
				</ul>
			</li>
			<#if menuId?number == 5><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-question"></i>
				<span class="title">帮助中心</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="form_controls.html">
						<i class="icon-list"></i>
						内容列表</a>
					</li>
				</ul>
			</li>
			<#if menuId?number == 6><li class="active open"><#else><li></#if>
				<a href="javascript:;">
				<i class="icon-speech"></i>
				<span class="title">新闻管理</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu">
					<li>
						<a href="table_basic.html">
						<i class="icon-list"></i>
						新闻列表</a>
					</li>
				</ul>
			</li>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->