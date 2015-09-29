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
<@layout menuId="4">
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
						<a href="#">用户管理</a>
					</li>
				</ul>
			</div>
			<!-- END PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box grey-cascade">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>用户等级设置
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="col-md-6">
									<div class="btn-group">
										<a class="btn green" href="#addUserLevel" data-toggle="modal">
										添加用户等级 <i class="fa fa-plus"></i>
										</a>
									</div>
								</div>
							</div>
							<#if userLevelList??&&userLevelList?size gt 0>
							<div class="table-scrollable">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>#</th>
										<th>等级名称</th>
										<th>订单金额</th>
										<th>用户折扣</th>
										<th>操作</th>
						            </tr>
								</thead>
								<tbody>
								<#list userLevelList as userLevel>
									<tr class="odd gradeX">
										<td>
											<span class="uni"><input type="checkbox"></span>
										</td>
										<td>
											<input name="levelName_${userLevel.id}" value="${userLevel.levelName}" class="form-control input-medium"/>
										</td>
										<td>
											<input name="orderAmount_${userLevel.id}" value="${userLevel.orderAmount}" class="form-control input-medium"/>
										</td>
										<td>
											<input name="orderAmount_${userLevel.id}" value="${userLevel.orderAmount}" class="form-control input-medium"/>
										</td>
										<td class="center">
											<input name="levelDiscount_${userLevel.id}" value="${userLevel.levelDiscount}" class="form-control input-medium"/>
										</td>
										<td>
											<a class="btn default btn-xs purple" href="javascript:;" onclick="saveUserLevel(${userLevel.id});"><i class="fa fa-edit"></i> Save </a>
										</td>
									</tr>
								</#list>
								</tbody>
							</table>
							</div>
							<#else>
								<div class="row">
									<div class="col-md-12">
									 	<div class="alert alert-warning" style="margin-top:10px;">暂无用户等级设置，请先添加用户等级</div>
									</div>
								</div>
							</#if>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>

			<#--modal start-->
			<div aria-hidden="true" role="basic" tabindex="-1" id="addUserLevel" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
							<h4 class="modal-title">添加新游戏</h4>
						</div>
						<div class="modal-body">
							 <div class="portlet-body form">
							<form role="form" class="form-horizontal" action="/backend/user/doAddUserLevel" id="addGameForm" method="post">
								<div class="form-body">
									<div class="form-group">
										<label class="col-sm-4 control-label">等级名称</label>
										<div class="col-sm-8">
											<input type="text" placeholder="等级名称" class="form-control input-medium" name="gameName">
											<span class="help-block">例如：Normal,Seliver,Gold </span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">订单金额</label>
										<div class="col-sm-8">
											<input type="text" placeholder="订单金额" class="form-control input-inline input-medium" name="iconImage">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">用户折扣</label>
										<div class="col-sm-8">
											<input type="text" placeholder="用户折扣" class="form-control input-inline input-medium" name="displayImage">
											<span class="help-inline">例如：98折输入98</span>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn default" type="button">关闭</button>
							<button class="btn blue" type="button" onclick="submitAddUserLevel();">添加</button>
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
<script src="/static/js/backend/user.js"></script>

<script>
jQuery(document).ready(function() {       
   	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	TableManaged.init();
   	FormSamples.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
