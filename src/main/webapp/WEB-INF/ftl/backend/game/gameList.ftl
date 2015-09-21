<#include "macro_pagination.ftl">
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
	            <tr>
	              <td>1</td>
	              <td>Ashok</td>
	              <td>India</td>
	              <td>23</td>
	              <td>B.Tech</td>
	            </tr>
	            <tr>
	              <td>2</td>
	              <td>Kumarasamy</td>
	              <td>USA</td>
	              <td>22</td>
	              <td>BE</td>
	            </tr>
	            <tr>
	              <td>3</td>
	              <td>Babura</td>
	              <td>UK</td>
	              <td>43</td>
	              <td>PhD</td>
	            </tr>
	            <tr>
	              <td>4</td>
	              <td>Ravi Kumar</td>
	              <td>China</td>
	              <td>73</td>
	              <td>PUC</td>
	            </tr>
	            <tr>
	              <td>5</td>
	              <td>Santhosh</td>
	              <td>Japan</td>
	              <td>43</td>
	              <td>M.Tech</td>
	            </tr>                                                                        
	          </tbody>
	        </table>
	        <div class="widget-foot">
	        	<@pagination totalPage="10" currentPage="3" function="queryForUser"></@pagination>
	          <div class="clearfix"></div> 
	        </div>
	      </div>
	    </div>
	  </div>
	<#--end-->
	
	</div>