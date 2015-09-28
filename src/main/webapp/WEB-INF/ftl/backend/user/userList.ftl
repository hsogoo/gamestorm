<#include "../macro_pagination.ftl">
<#if userList??&&userList?size gt 0>
	<#-- strat-->
	<div class="portlet">
		<div class="portlet-body">
			<div class="table-scrollable">
				<table class="table table-striped table-bordered table-hover">
				<thead>
		            <tr>
		              <th>#</th>
		              <th>用户名</th>
		              <th>注册邮件</th>
		              <th>会员等级</th>
		              <th>会员类型</th>
		              <th>注册时间</th>
		              <th>用户状态</th>
		              <th>操作</th>
		            </tr>
		          </thead>
		          <tbody>
		          <#list userList as user>
		            <tr>
		              <td>
		              <span class="uni"><input type="checkbox"></span>
		              </td>
		              <td>${user.userName}</td>
		              <td>${user.userEmail}</td>
		              <td>${user.userLevelName}</td>
		              <td><#if user.userType == 1>管理员<#else>注册用户</#if></td>
		              <td>${user.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		              <td><#if user.status><span class="label label-sm label-success">Active</span><#else><span class="label label-sm label-danger">Stoped</span></#if></td>
		              <td>
		              <#if user.status>
		              	<a class="btn default btn-xs purple" href="javascript:;"><i class="fa fa-edit"></i> 冻结 </a>
		              <#else>
		              	<a class="btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i> 解冻 </a>
		              </#if>
		              </td>
		            </tr>
		          </#list>
		          </tbody>
	        	</table>
			</div>
			<#-- page start-->
        	<div class="widget-foot">
        		<@pagination totalPage="${totalPage}" currentPage="${currentPage}" function="queryForUser"></@pagination>
          		<div class="clearfix"></div> 
        	</div>
        	<#-- page end-->
		</div>
	</div>
	<#--end-->
<#else>
	<div class="row">
		<div class="col-md-12">
		 	<div class="alert alert-warning" style="margin-top:10px;">暂无注册用户</div>
		</div>
	</div>
</#if>	
</div>
	
	
	
