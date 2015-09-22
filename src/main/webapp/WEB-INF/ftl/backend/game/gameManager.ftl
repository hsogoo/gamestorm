<#include "../page_macro.ftl">
<@page title="游戏管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/game.js" menuId="3">

<div class="page-head">
    <h2 class="pull-left"><i class="icon-table"></i> 订单管理</h2>
    <!-- Breadcrumb -->
    <div class="bread-crumb pull-right">
      <a href="index.html"><i class="icon-home"></i> Home</a> 
      <!-- Divider -->
      <span class="divider">/</span> 
      <a class="bread-current" href="#">Dashboard</a>
    </div>
    <div class="clearfix"></div>
</div>

<div class="container" style="margin-top:15px;">
	<div class="row">
		<div class="col-md-12">
			<div class="btn-group">
				<button class="btn green" id="sample_editable_1_new">
					添加新游戏  <i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
	</div>
	<div id="gameList"></div>
</div>

</@page>
