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

<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<@layout menuId="5">
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
						<a href="#">内容管理&帮助中心</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-chambray">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>内容分类设置
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="col-md-6">
									<div class="btn-group">
										<a class="btn green" href="#addContentTypeDiv" data-toggle="modal">
										添加内容分类 <i class="fa fa-plus"></i>
										</a>
									</div>
								</div>
							</div>
							<#if contentTypeList??&&contentTypeList?size gt 0>
							<div class="table-scrollable">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>内容分类名称</th>
										<th>上/下架</th>
										<th>状态</th>
										<th>操作</th>
						            </tr>
								</thead>
								<tbody>
								<#list contentTypeList as contentType>
									<tr class="odd gradeX">
										<td>
											<span class="uni"><input type="checkbox"></span>
										</td>
										<td>
											<input name="typeName_${contentType.id}" value="${contentType.typeName}" class="form-control input-medium"/>
										</td>
										<td>
											<span><input type="radio" name="status_${contentType.id}" value="1" <#if contentType.status>checked="checked"</#if>/>上架</span>
											<span><input type="radio" name="status_${contentType.id}" value="0" <#if !contentType.status>checked="checked"</#if>/>下架</span>
										</td>
										<td class="center">
											<#if contentType.status><span class="label label-sm label-success">Active</span><#else><span class="label label-sm label-danger">deleted</span></#if>
										</td>
										<td>
											<a class="btn default btn-xs purple" href="javascript:;" onclick="saveContentType(${contentType.id});"><i class="fa fa-edit"></i> 修改 </a>
										</td>
									</tr>
								</#list>
								</tbody>
							</table>
							</div>
							<#else>
								<div class="row">
									<div class="col-md-12">
									 	<div class="alert alert-warning" style="margin-top:10px;">暂无内容分类设置，请先添加内容分类</div>
									</div>
								</div>
							</#if>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>

			<#--modal start-->
			<div aria-hidden="true" role="basic" tabindex="-1" id="addContentTypeDiv" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
							<h4 class="modal-title">添加内容分类</h4>
						</div>
						<div class="modal-body">
							 <div class="portlet-body form">
							<form role="form" class="form-horizontal" action="/backend/content/addContentType" id="addContentTypeForm" method="post">
								<div class="form-body">
									<div class="form-group">
										<label class="col-sm-4 control-label">内容分类名称</label>
										<div class="col-sm-8">
											<input type="text" placeholder="内容分类名称" class="form-control input-medium" name="typeName">
											<span class="help-block">例如：about us </span>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn default" type="button">关闭</button>
							<button class="btn blue" type="button" onclick="submitAddContentType();">添加</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<#--modal end-->
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

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="/static/js/backend/content.js"></script>

<script>
jQuery(document).ready(function() {       
   	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features

});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
