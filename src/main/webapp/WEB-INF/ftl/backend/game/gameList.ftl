<#include "../macro_pagination.ftl">
<#if gameList??&&gameList?size gt 0>
<div class="row">
	
	<#-- strat-->
	
	<div class="col-md-12">
	    <div class="widget">
	    <div class="widget-head">
	      <div class="pull-left">游戏列表</div>
	      <div class="widget-icons pull-right">
	        <a class="wminimize" href="#"><i class="icon-chevron-up"></i></a> 
	        <a class="wclose" href="#"><i class="icon-remove"></i></a>
	      </div>  
	      <div class="clearfix"></div>
	    </div>
	      <div class="widget-content">
	        <table class="table table-striped table-bordered table-hover">
	          <thead>
	            <tr>
	              <th>#</th>
	              <th>游戏名称</th>
	              <th>游戏小图标</th>
	              <th>游戏推荐图片</th>
	              <th>游戏banner图片</th>
	              <th>状态</th>
	              <th>操作</th>
	            </tr>
	          </thead>
	          <tbody>
	          <#list gameList as game>
	            <tr>
	              <td>${game_index}</td>
	              <td>${game.gameName}</td>
	              <td><img src="${game.iconImage}" width="50" height="50"></td>
	              <td><img src="${game.displayImage}" width="50" height="50"></td>
	              <td><img src="${game.bannerImage}" width="50" height="50"></td>
	              <td><#if game.status><span class="label label-sm label-success">Active</span><#else><span class="label label-sm label-danger">Stoped</span></#if></td>
	              <td><a class="btn default btn-xs purple" href="javascript:;"><i class="fa fa-edit"></i> Edit </a></td>
	            </tr>
	          </#list>
	          </tbody>
	        </table>
	        <div class="widget-foot">
	        	<@pagination totalPage="${totalPage}" currentPage="${currentPage}" function="queryForUser"></@pagination>
	          <div class="clearfix"></div> 
	        </div>
	      </div>
	    </div>
	  </div>
	<#--end-->
<#else>
	<div class="col-md-12">
	 	<div class="alert alert-warning" style="margin-top:10px;">暂无游戏，请先添加游戏</div>
	</div>
</#if>	
	</div>