<#include "../macro_layout.ftl">
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8"/>
<title>GameStorm | 游戏管理</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="/static/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN THEME STYLES -->
<link href="/static/assets/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="/static/assets/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="/static/assets/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
<link href="/static/assets/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->

<!-- BEGIN PAGE LEVEL STYLES-->
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<!-- END PAGE LEVEL STYLES -->

<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<@layout menuId="2">
			<div class="page-content">
	
			<!-- BEGIN PAGE HEADER-->
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li>
						<i class="fa fa-home"></i>
						<a href="index.html">控制台</a>
						<i class="fa fa-angle-right"></i>
					</li>
					<li>
						<a href="#">商品管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			
			<div class="alert alert-success"><strong>模块功能说明： </strong>此模块用来设定某游戏，某类目下的商品类型，相当于三级类目。比如：World of Warcraft US下面的PowerLeveling有等级代练，荣誉代练等，这些在这里进行设置。</div>
			
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-chambray">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>商品类型管理
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<form role="form" class="form-inline">
								
									<div class="form-group">
										<label class="control-label">选择游戏</label>
										<div class="input-group">
											<select class="select2_category form-control input-medium" data-placeholder="选择游戏" tabindex="1" id="game">
												<option value="">选择游戏</option>
												<#if gameList??&&gameList?size gt 0>
													<#list gameList as game>
														<option value="${game.id}">${game.gameName}</option>
													</#list>
												</#if>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label">选择类别</label>
										<div class="input-group">
											<select class="select2_category form-control input-medium" data-placeholder="选择类别" tabindex="2" id="category">
												<option value="">选择类别</option>
												<#if categoryList??&&categoryList?size gt 0>
													<#list categoryList as category>
														<option value="${category.id}">${category.categoryName}</option>
													</#list>
												</#if>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label"> 商品类型名称 </label>
										<div class="input-group">
											<span class="input-group-addon">
											<i class="icon-present"></i>
											</span>
											<input name="productType" id="productType" type="text" placeholder="商品类型名称" class="form-control input-large">
										</div>
									</div>
									
									<button class="btn blue" onclick="addProductType();">添加商品类型 <i class="icon-plus"></i> </button>
								</form>
							</div>
								<#if productTypeList??&&productTypeList?size gt 0>
									<table class="table table-striped table-bordered table-hover" id="sample_2">
										<thead>
											<tr>
												<th class="table-checkbox">
													<input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes"/>
												</th>
												<th>游戏名称</th>
												<th>类别名称</th>
												<th>类型名称</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<#list productTypeList as productType>
												<tr class="odd gradeX">
													<td>
														<input type="checkbox" class="checkboxes" value="1"/>
													</td>
													<td>${productType.gameName}</td>
													<td>${productType.categoryName}</td>
													<td>${productType.typeName}</td>
													<td class="center">
														<a onclick="editProductType(${productType.id});" href="javascript:;" class="btn default btn-xs purple"><i class="fa fa-edit"></i> 修改 </a>
													</td>
												</tr>
											</#list>
										</tbody>
									</table>
								<#else>
									<div class="row">
										<div class="col-md-12">
										 	<div class="alert alert-warning" style="margin-top:10px;">暂无商品类型，请先添加商品类型</div>
										</div>
									</div>
								</#if>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>

		</div>
</@layout>
<script src="/static/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/static/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="/static/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="/static/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/static/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="/static/assets/admin/pages/scripts/table-managed.js"></script>
<script src="/static/assets/admin/pages/scripts/form-samples.js"></script>
<script src="/static/js/backend/product.js"></script>

<script>
jQuery(document).ready(function() {       
   Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
   	FormSamples.init();
   	TableManaged.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
