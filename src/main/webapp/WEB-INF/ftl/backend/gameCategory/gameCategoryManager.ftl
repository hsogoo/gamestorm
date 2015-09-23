<#include "../page_macro.ftl">
<@page title="游戏管理" keywords="keywords" description="description" type="base" pageCss="/static/style/backend/login.css" pageJs="/static/js/backend/gameCategory.js" menuId="2">

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
				<a href="#addGameCategoryModal" data-toggle="modal" class="btn green">关联游戏和类目 <i class="fa fa-plus"></i></a>
			</div>
			<#--<div class="btn-group">
				<a href="#addCategoryGameModal" data-toggle="modal" class="btn green">添加类目所属的游戏 <i class="fa fa-plus"></i></a>
			</div>-->
		</div>
	</div>
	<div id="gameCategoryList"></div>
	
	<#---添加游戏的类目-->
	<div aria-hidden="true" role="basic" tabindex="-1" id="addGameCategoryModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
					<h4 class="modal-title">添加游戏的类目</h4>
				</div>
				<div class="modal-body">
					 <div class="portlet-body form">
					<form role="form" class="form-horizontal" action="/backend/gameCategory/doAddGameCategory" id="addGameCategoryForm" method="post">
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-md-3">选择游戏</label>
								<div class="col-md-4">
									<div class="select2-container form-control input-medium select2me" id="s2id_autogen1"><a tabindex="-1" class="select2-choice select2-default" href="javascript:void(0)">   <span class="select2-chosen" id="select2-chosen-2">Select...</span><abbr class="select2-search-choice-close"></abbr>   <span role="presentation" class="select2-arrow"><b role="presentation"></b></span></a><label class="select2-offscreen" for="s2id_autogen2"></label><input type="text" role="button" aria-haspopup="true" class="select2-focusser select2-offscreen" aria-labelledby="select2-chosen-2" id="s2id_autogen2"></div><select data-placeholder="Select..." class="form-control input-xlarge select2me select2-offscreen" tabindex="-1" title="">
										<option value=""></option>
										<option value="AL">Alabama</option>
										<option value="WY">Wyoming</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">选择类别</label>
								<div class="col-md-4">
									<div class="select2-container form-control input-medium select2me" id="s2id_autogen3"><a tabindex="-1" class="select2-choice select2-default" href="javascript:void(0)">   <span class="select2-chosen" id="select2-chosen-4">Select...</span><abbr class="select2-search-choice-close"></abbr>   <span role="presentation" class="select2-arrow"><b role="presentation"></b></span></a><label class="select2-offscreen" for="s2id_autogen4"></label><input type="text" role="button" aria-haspopup="true" class="select2-focusser select2-offscreen" aria-labelledby="select2-chosen-4" id="s2id_autogen4"></div><select data-placeholder="Select..." class="form-control input-large select2me select2-offscreen" tabindex="-1" title="">
										<option value=""></option>
										<option value="AL">Alabama</option>
										<option value="WY">Wyoming</option>
									</select>
								</div>
							</div>
						</div>
					</form>
				</div>
				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn default" type="button">关闭</button>
					<button class="btn blue" type="button" onclick="submitAddGameCategory();">添加</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</div>

</@page>
