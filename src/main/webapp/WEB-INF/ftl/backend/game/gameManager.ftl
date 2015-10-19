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
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/jquery-file-upload/css/jquery.fileupload.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/jquery-file-upload/css/jquery.fileupload-ui.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/icheck/skins/all.css" rel="stylesheet">

<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<@layout menuId="1">
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
						<a href="#">游戏管理</a>
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
								<i class="fa fa-star"></i>游戏列表
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<a class="btn green" href="#addNewGameModal" data-toggle="modal">
											添加新游戏 <i class="fa fa-plus"></i>
											</a>
										</div>
									</div>
									<div class="col-md-6">
										<div class="btn-group pull-right">
											<button class="btn dropdown-toggle green" data-toggle="dropdown">操作 <i class="fa fa-angle-down"></i>
											</button>
											<ul class="dropdown-menu pull-right">
												<li>
													<a href="#"><i class="fa fa-trash-o"></i>
													修改 </a>
												</li>
												<li>
													<a href="#"><i class="fa fa-times"></i>
													删除 </a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<#if gameList??&&gameList?size gt 0>
							<table class="table table-striped table-bordered table-hover" id="sample_2">
							<thead>
							<tr>
								<th class="table-checkbox">
									<input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes"/>
								</th>
								<th> 游戏名称</th>
								<th> 游戏小图标</th>
								<th> 游戏显示图片</th>
								<th> 游戏banner图</th>
								<th> 是否推荐</th>
								<th>游戏状态</th>
							</tr>
							</thead>
							<tbody>
							<#list gameList as game>
							<tr class="odd gradeX">
								<td>
									<input type="checkbox" class="checkboxes" value="1"/>
								</td>
								<td>
									 ${game.gameName}
								</td>
								<td>
									<img src="${game.iconImage}" width="35" height=35">
								</td>
								<td>
									<img src="${game.displayImage}" width="100" height="50">
								</td>
								<td class="center">
									 <img src="${game.bannerImage}" width="150" height="50">
								</td>
								<td class="center">
									 <#if game.isRecommended><span class="label label-sm label-success">是</span><#else><span class="label label-sm label-danger">否</span></#if>
								</td>
								<td>
									<#if game.status><span class="label label-sm label-success">Active</span><#else><span class="label label-sm label-danger">Stoped</span></#if>
								</td>
							</tr>
							</#list>
							</tbody>
							</table>
							<#else>
								<div class="row">
									<div class="col-md-12">
									 	<div class="alert alert-warning" style="margin-top:10px;">暂无游戏，请先添加游戏</div>
									</div>
								</div>
							</#if>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>

			<div aria-hidden="true" role="basic" tabindex="-1" id="addNewGameModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
							<h4 class="modal-title">添加新游戏</h4>
						</div>
						<div class="modal-body">
							 <div class="portlet-body form">
							<form role="form" class="form-horizontal" action="/backend/game/doAddGame" id="addGameForm" method="post">
								<div class="form-body">
									<div class="form-group">
										<label class="col-sm-4 control-label">游戏名称</label>
										<div class="col-sm-8">
											<input type="text" placeholder="游戏名称" class="form-control input-medium" name="gameName" id="gameName">
											<span class="help-block">例如：World of Warcraft US </span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">游戏小图标</label>
										<div class="col-sm-8 fileupload-buttonbar">
											<img id="iconImagePriview" width="30px;" height="30px;"/>
											<input type="hidden" name="iconImage" id="iconImage">
											<span class="btn blue start fileinput-button">
												<i class="fa fa-upload"></i>
												<span>游戏小图标 </span>
												<input type="file" id="iconImageFile" name="iconImageFile">
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">展示图片</label>
										<div class="col-sm-8 fileupload-buttonbar">
											<img id="displayImagePriview" width="30px;" height="30px;"/>
											<input type="hidden" name="displayImage" id="displayImage">
											<span class="btn blue start fileinput-button">
												<i class="fa fa-upload"></i>
												<span>展示图片 </span>
												<input type="file" id="displayImageFile" name="displayImageFile">
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">广告图片</label>
										<div class="col-sm-8 fileupload-buttonbar">
											<img id="bannerImagePriview" width="30px;" height="30px;"/>
											<input type="hidden" name="bannerImage" id="bannerImage">
											<span class="btn blue start fileinput-button">
												<i class="fa fa-upload"></i>
												<span>广告图片 </span>
												<input type="file" id="bannerImageFile" name="bannerImageFile">
											</span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 control-label">是否推荐</label>
										<div class="col-sm-8 input-group">
											<div class="icheck-inline">
												<label><input type="checkbox" class="icheck" data-checkbox="icheckbox_square-blue" id="isRecommended" name="isRecommended"> 设为推荐游戏 </label>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn default" type="button">关闭</button>
							<button class="btn blue" type="button" onclick="submitAddGame();">添加</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
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
<script src="/static/assets/global/plugins/ajaxfileupload.js"></script>
<script src="/static/assets/global/plugins/icheck/icheck.min.js"></script>
<script src="/static/assets/admin/pages/scripts/form-icheck.js"></script>
<script src="/static/js/backend/game.js"></script>

<script>
jQuery(document).ready(function() {       
   Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	TableManaged.init();
	FormiCheck.init(); // init icheck	
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
