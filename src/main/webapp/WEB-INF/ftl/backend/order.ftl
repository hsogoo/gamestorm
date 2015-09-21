<#include "page_macro.ftl">
<@page title="订单管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/order.js" menuId="3">

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

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="btn-group">
				<button class="btn green" id="sample_editable_1_new">
					Add New <i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<div class="col-md-3">
				<div data-date-viewmode="years" data-date-format="dd-mm-yyyy" data-date="9-09-2015" class="input-group input-medium date date-picker">
					<input type="text" readonly="" class="form-control">
					<span class="input-group-btn">
					<button type="button" class="btn default"><i class="fa fa-calendar"></i></button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div id="orderList"></div>
</div>

</@page>