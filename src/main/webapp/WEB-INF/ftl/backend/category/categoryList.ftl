<#include "../macro_pagination.ftl">
<#if categoryList??&&categoryList?size gt 0>

<div class="row">
	
	<#-- strat-->
	
	<div class="col-md-12">
	    <div class="widget">
	    <div class="widget-head">
	      <div class="pull-left">分类列表</div>
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
	              <th>分类名称</th>
	              <th>状态</th>
	              <th>操作</th>
	            </tr>
	          </thead>
	          <tbody>
	          <#list categoryList as category>
	            <tr>
	              <td>${category_index+1}</td>
	              <td><input name="${category.id}_category.categoryName" value="${category.categoryName}"/></td>
	              <td> <input type="radio" name="${category.id}_category.status" value="1" <#if category.status>checked="checked"</#if>/>&nbsp;&nbsp;<span class="label label-sm label-success">Active</span></td>
                  <td> <input type="radio" name="${category.id}_category.status" value="0" <#if !category.status>checked="checked"</#if>/>&nbsp;&nbsp;<span class="label label-sm label-danger">Stoped</span></td>
	              <td><a class="btn default btn-xs purple" href="javascript:;" onclick="saveCategory(${category.id});"><i class="fa fa-edit"></i> Save </a></td>
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
	 	<div class="alert alert-warning" style="margin-top:10px;">暂无分类，请先添加分类</div>
	</div>
</#if>	
	</div>
