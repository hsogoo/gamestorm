<#include "../macro_pagination.ftl">
<#if newsList??&&newsList?size gt 0>
	<#-- strat-->
	<div class="portlet">
		<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-bordered table-hover">
				<thead>
		            <tr>
		              <th>#</th>
		              <th>新闻标题</th>
		              <th>创建时间</th>
		              <th>新闻状态</th>
		              <th>操作</th>
		            </tr>
		          </thead>
		          <tbody>
		          <#list newsList as news>
		            <tr>
		              <td>
		              <span class="uni"><input type="checkbox"></span>
		              </td>
		              <td><a href="#" title="${news.newsTitle}" data-container="body" data-toggle="popover" data-placement="right" data-content='${news.newsContent}'>${news.newsTitle}</a></td>
		              <td>${news.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		              <td>
		              	<#if news.status>
		              		<span class="label label-sm label-success">Active</span>
		              	<#else>
		              		<span class="label label-sm label-danger">Stoped</span>
	              		</#if>
              		  </td>
		              <td>
		              <#if news.status>
		              	<a class="btn default btn-xs purple" href="javascript:;"><i class="fa fa-edit"></i> 删除 </a>
		              <#else>
		              	<a class="btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i> 恢复 </a>
		              </#if>
		              </td>
		            </tr>
		          </#list>
		          </tbody>
	        	</table>
			</div>
			<#-- page start-->
        	<div class="widget-foot">
        		<@pagination totalPage="${totalPage}" currentPage="${currentPage}" function="queryForNews"></@pagination>
          		<div class="clearfix"></div> 
        	</div>
        	<#-- page end-->
		</div>
	</div>
	<#--end-->
<#else>
	<div class="row">
		<div class="col-md-12">
		 	<div class="alert alert-warning" style="margin-top:10px;">暂无新闻，请先添加新闻</div>
		</div>
	</div>
</#if>	
</div>
	
	
	
