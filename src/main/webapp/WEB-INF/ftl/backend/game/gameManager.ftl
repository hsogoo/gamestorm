<#include "../page_macro.ftl">
<@page title="游戏管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/game.js" menuId="2">

<div class="page-head">
    <h2 class="pull-left"><i class="icon-table"></i> 游戏管理</h2>
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
				<a href="#addNewGameModal" data-toggle="modal" class="btn green">添加游戏 <i class="fa fa-plus"></i></a>
			</div>
			<div class="btn-group">
				<button class="btn purple" id="addNewGame" onclick="addGame();">
					游戏类别管理  <i class="fa fa-plus"></i>
				</button>
			</div>
			<div class="btn-group">
				<button class="btn blue-madison" id="addNewGame" onclick="addGame();">
					游戏服务器管理  <i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
	</div>
	<div id="gameList"></div>
	
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
								<label class="col-md-4 control-label">游戏名称</label>
								<div class="col-md-6">
									<input type="text" placeholder="游戏名称" class="form-control input-medium" name="gameName">
									<span class="help-block">例如：World of Warcraft US </span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label col-sm-2">游戏小图标</label>
								<div class="col-md-6">
									<input type="text" placeholder="游戏小图标的地址" class="form-control input-inline input-medium" name="iconImage">
									<span class="help-inline">暂时先输入图片地址，后续改成图片上传</span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">展示图片</label>
								<div class="col-md-6">
									<input type="text" placeholder="游戏展示图片的地址" class="form-control input-inline input-medium" name="displayImage">
									<span class="help-inline">暂时先输入图片地址，后续改成图片上传</span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">广告图片</label>
								<div class="col-md-9">
									<input type="text" placeholder="游戏广告图片的地址" class="form-control input-inline input-medium" name="bannerImage">
									<span class="help-inline">暂时先输入图片地址，后续改成图片上传</span>
								</div>
							</div>
						</div>
						<div class="form-actions">
							<div class="row">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn green" type="submit" onclick="submitAddGame();">添加</button>
									<button class="btn default" type="button" onclick="cancelAddGame();">取消</button>
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
	
</div>

</@page>
