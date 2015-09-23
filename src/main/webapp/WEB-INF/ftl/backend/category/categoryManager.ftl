<#include "../page_macro.ftl">
<@page title="分类管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/category.js" menuId="3">

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
		<div class="col-md-12">
			<div class="btn-group">
				<a href="#addNewCategoryModal" data-toggle="modal" class="btn green">添加类别 <i class="fa fa-plus"></i></a>
			</div>
		</div>
	</div>
	<div id="categoryList"></div>
	
	<#--- 弹框开始 -->
	<div aria-hidden="true" role="basic" tabindex="-1" id="addNewCategoryModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
					<h4 class="modal-title">添加新类别</h4>
				</div>
				<div class="modal-body">
					<div class="portlet-body form">
						<form role="form" class="form-horizontal" action="/backend/category/doAddCategory" id="addCategoryForm" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="col-md-4 control-label">分类名称</label>
									<div class="col-md-6">
										<input type="text" placeholder="分类名称" class="form-control input-medium" name="categoryName">
										<span class="help-block">例如：PowerLeveling、Item、gold </span>
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
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn default" type="button">关闭</button>
					<button class="btn blue" type="button">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<#--- 弹框结束 -->
</div>

</@page>
