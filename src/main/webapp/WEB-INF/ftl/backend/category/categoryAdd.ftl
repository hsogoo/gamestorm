<#include "../page_macro.ftl">
<@page title="游戏管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/category.js" menuId="2">

<div class="page-head">
    <h2 class="pull-left"><i class="icon-table"></i> 分类管理</h2>
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
		<div class="col-md-8 ">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i> 添加新分类
					</div>
				</div>
				<div class="portlet-body form">
					<form role="form" class="form-horizontal" action="/backend/category/doAddCategory" id="addCategoryForm" method="post">
						<div class="form-body">
							<div class="form-group">
								<label class="col-md-4 control-label">分类名称</label>
								<div class="col-md-6">
									<input type="text" placeholder="分类名称" class="form-control input-medium" name="categoryName">
									<span class="help-block">例如：益智，棋牌，竞技 </span>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn green" type="submit" onclick="submitAddCategory();">添加</button>
									<button class="btn default" type="button" onclick="cancelAddCategory();">取消</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- END SAMPLE FORM PORTLET-->
		</div>
	</div>
</div>

</@page>
