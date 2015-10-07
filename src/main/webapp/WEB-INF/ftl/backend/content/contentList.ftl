<#include "../macro_pagination.ftl">
<input type="hidden" id="searchTypeName" value="${typeName}">
<input type="hidden" id="searchTypeId" value="${typeId}">
<#if contentList??&&contentList?size gt 0>
	<#-- strat-->
	<div class="portlet">
		<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-bordered table-hover">
				<thead>
		            <tr>
		              <th>#</th>
		              <th>标题</th>
		              <th>内容类型</th>
		              <th>创建时间</th>
		              <th>操作</th>
		            </tr>
		          </thead>
		          <tbody>
		          <#list contentList as content>
		            <tr>
		              <td>
		              <span class="uni"><input type="checkbox"></span>
		              </td>
		              <td>${content.title}</td>
		              <td>${content.typeName}</td>
		              <td>${content.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		              <td>
		              	<a class="btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i> 修改 </a>
		              	<a class="btn default btn-xs purple" href="javascript:;"><i class="fa fa-edit"></i> 删除 </a>
		              </td>
		            </tr>
		          </#list>
		          </tbody>
	        	</table>
			</div>
			<#-- page start-->
        	<div class="widget-foot">
        		<@pagination totalPage="${totalPage}" currentPage="${currentPage}" function="queryForContent"></@pagination>
          		<div class="clearfix"></div> 
        	</div>
        	<#-- page end-->
		</div>
	</div>
	<#--end-->
<#else>
	<div class="row">
		<div class="col-md-12">
		 	<div class="alert alert-warning" style="margin-top:10px;">暂无内容，请先添加内容</div>
		</div>
	</div>
</#if>	
</div>
	
	
	
