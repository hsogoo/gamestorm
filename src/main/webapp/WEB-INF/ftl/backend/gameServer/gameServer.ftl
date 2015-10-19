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
			
			<div class="alert alert-success"><strong>模块功能说明： </strong>此模块用来添加游戏的服务器，可以进行批量添加，各服务器之间用英文字母的,分割，可以设置各服务器的价格差，默认为0，即各个服务器价格一样。</div>
			
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet box blue-chambray">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-star"></i>游戏服务器列表
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-toolbar">
								<form role="form" class="form-inline">
                                    <a class="btn green" href="#addNewGameServerModal" data-toggle="modal">
                                        添加新游戏服务器 <i class="fa fa-plus"></i>
                                    </a>
								</form>
							</div>
								<#if gameServerList??&&gameServerList?size gt 0>
									<table class="table table-striped table-bordered table-hover" id="sample_2">
										<thead>
											<tr>
												<th class="table-checkbox">
													<input type="checkbox" class="group-checkable" data-set="#sample_2 .checkboxes"/>
												</th>
												<th>游戏名称</th>
												<th>服务器名称</th>
												<th>价格调整</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<#list gameServerList as gameServer>
												<tr class="odd gradeX">
													<td>
														<input type="checkbox" class="checkboxes" value="1"/>
													</td>
													<td>${gameServer.gameName}</td>
													<td>${gameServer.serverName}</td>
													<td>
														<input name="gameServer_${gameServer.id}" value="${gameServer.priceExt}" class="form-control input-medium"/>
													</td>
													<td class="center">
													 	<a onclick="saveGameServer(${gameServer.id});" href="javascript:;" class="btn default btn-xs green"><i class="fa fa-edit"></i> 修改 </a>
													 	<a onclick="deleteGameServer(${gameServer.id});" href="javascript:;" class="btn default btn-xs red-intense"><i class="fa fa-times"></i> 删除 </a>
													</td>
												</tr>
											</#list>
										</tbody>
									</table>
								<#else>
									<div class="row">
										<div class="col-md-12">
										 	<div class="alert alert-warning" style="margin-top:10px;">暂无游戏服务器，请先添加游戏服务器</div>
										</div>
									</div>
								</#if>
						</div>

                        <div aria-hidden="true" role="basic" tabindex="-1" id="addNewGameServerModal" class="modal fade bs-modal-lg in">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
                                        <h4 class="modal-title">添加新游戏服务器</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="portlet-body form">
                                            <form role="form" class="form-horizontal" action="/backend/gameServer/doAddGameServer" id="addGameServerForm" method="post">
                                                <div class="form-body">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">选择游戏</label>
                                                        <div class="col-sm-8">
                                                            <select class="select2_category form-control input-medium" data-placeholder="选择游戏" tabindex="1" name="gameId" id="gameId">
                                                                <option value="">选择游戏</option>
																<#if gameList??&&gameList?size gt 0>
																	<#list gameList as game>
                                                                        <option value="${game.id}">${game.gameName}</option>
																	</#list>
																</#if>
                                                            </select>
                                                        </div>
                                                        <input type="hidden" name="gameName" id="gameName">
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">服务器名称</label>
                                                        <div class="col-sm-8">
                                                            <textarea placeholder="服务器名称用逗号分割，不要超过1400个字" rows="5" class="form-control" id="serverName" style="width: 650px; height: 200px;" name="serverName"></textarea>
                                                        </div>
                                                    </div>

                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button data-dismiss="modal" class="btn default" type="button">关闭</button>
                                        <button class="btn blue" type="button" onclick="submitAddGameServer();">添加</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
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
<script src="/static/js/backend/gameServer.js"></script>

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
