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
		<div class="col-md-8 ">
			<!-- BEGIN SAMPLE FORM PORTLET-->
			<div class="portlet box green">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-gift"></i> 添加新游戏
					</div>
				</div>
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
			<!-- END SAMPLE FORM PORTLET-->
		</div>
	</div>
</div>

</@page>
