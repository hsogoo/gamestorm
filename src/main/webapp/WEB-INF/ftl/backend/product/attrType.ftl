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
			
			<div class="alert alert-success"><strong>模块功能说明： </strong>此模块用来设定商品的特殊属性，某种游戏或者类型的商品有些具有特殊属性。比如：World of Warcraft US下面有联盟，部落，或者像暗黑3有不同的赛季，可以在这里对某个游戏进行定制。</div>
			
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-chambray">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>系列属性列表
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="btn-group">
									<a data-toggle="modal" href="#addAttrTypeModal" class="btn green">
									添加新属性 <i class="fa fa-plus"></i>
									</a>
								</div>
							</div>
								<#if attrTypeList??&&attrTypeList?size gt 0>
									<table class="table table-striped table-bordered table-hover" id="sample_2">
										<thead>
											<tr>
												<th class="table-checkbox">
													<input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes"/>
												</th>
												<th>属性名称</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<#list attrTypeList as attrType>
												<tr class="odd gradeX">
													<td>
														<input type="checkbox" class="checkboxes" value="1"/>
													</td>
													<td>${attrType.typeName}</td>
													<td><a onclick="deleteAttrType(${attrType.id});" href="javascript:;" class="btn default btn-xs purple"><i class="fa fa-times"></i> 删除 </a></td>
												</tr>
											</#list>
										</tbody>
									</table>
								<#else>
									<div class="row">
										<div class="col-md-12">
										 	<div class="alert alert-warning" style="margin-top:10px;">暂无系列属性，请先添加系列属性</div>
										</div>
									</div>
								</#if>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
			
			<#--- 弹框开始 -->
			<div aria-hidden="true" role="basic" tabindex="-1" id="addAttrTypeModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
							<h4 class="modal-title">添加新属性</h4>
						</div>
						<div class="modal-body">
							<div class="portlet-body form">
								<form role="form" class="form-horizontal" action="/backend/product/addAttrType" id="addAttrTypeForm" method="post">
									<div class="form-body">
										<div class="form-group">
											<label class="col-md-4 control-label">属性名称</label>
											<div class="col-md-6">
												<input type="text" placeholder="属性名称" class="form-control input-medium" name="typeName">
												<span class="help-block">例如：职业，赛季，难度等 </span>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn default" type="button">关闭</button>
							<button class="btn blue" type="button" onclick="submitAddCategory();">添加</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<#--- 弹框结束 -->
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
<script src="/static/js/backend/gameCategory.js"></script>

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
