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
<link rel="stylesheet" type="text/css" href="/static/assets/global/plugins/select2/select2.css"/>
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
			
			<div class="alert alert-success"><strong>模块功能说明： </strong>此模块用来添加指定的游戏的等级代练的价格模版。比如：魔兽世界1-10级价格，2-20级价格。点击+号可以增加一行，点击-可以删除当前行</div>
			<!-- END PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-chambray">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>添加等级代练的价格
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<form role="form" class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-md-1">选择游戏</label>
										<div class="col-md-2">
											<select class="select2_category form-control input-samll" data-placeholder="选择游戏" tabindex="1" name="gameId" id="gameId">
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
										<label class="col-md-1 control-label">模版名称</label>
										<div class="col-md-4">
											<input type="text" placeholder="模版名称" class="form-control input-medium" name="attrValue" id="attrValue">
										</div>
									</div>
									<div class="portlet-body">
										<div class="portlet">
											<div class="portlet-body">
												<div class="table-scrollable">
													<table class="table table-striped table-bordered table-hover" id="levelPriceTable">
													<thead>
											            <tr>
															<th width="5%">#</th>
															<th width="25%">开始等级</th>
															<th width="25%">结束等级</th>
															<th width="25%">代练价格</th>
															<th width="20%">操作</th>
											            </tr>
											          </thead>
											          <tbody>
											            <tr>
															<td><span class="uni"><input type="checkbox"></span></td>
															<td><input type="text" class="form-control input-medium" name="startLevel" id="startLevel"></td>
															<td><input type="text" class="form-control input-medium" name="endLevel" id="endLevel"></td>
															<td><input type="text" class="form-control input-medium" name="levelPrice" id="levelPrice"></td>
															<td>
												              	<a class="btn btn-icon-only green" href="javascript:void(0);" onclick="addRow(this);"><i class="fa fa-plus"></i></a> 
												              	<a class="btn btn-icon-only blue-hoki" href="javascript:void(0);" onclick="deleteRow(this);"><i class="fa fa-times"></i></a>
											              	</td>
											            </tr>
											          </tbody>
										        	</table>
												</div>
									
									        	</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-md-6">
												<a data-toggle="modal" href="javaScript:void(0);" class="btn blue" onclick="doAddLevelPrices();">
												添加代练价格模版  <i class="fa fa-plus"></i>
												</a>
											</div>
										</div>
									</div>

								</form>
							</div>
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
<script type="text/javascript" src="/static/assets/global/plugins/select2/select2.min.js"></script>
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="/static/assets/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="/static/assets/admin/pages/scripts/form-samples.js"></script>
<script src="/static/js/backend/product.js"></script>

<script>
jQuery(document).ready(function() {       
   	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	QuickSidebar.init(); // init quick sidebar
	Demo.init(); // init demo features
	FormSamples.init();
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
