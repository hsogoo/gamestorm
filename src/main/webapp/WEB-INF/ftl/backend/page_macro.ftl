<#macro page title='' keywords=title description=keywords type="base" pageCss="" pageJs="" menuId="1">
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>${title}</title> 
  <meta name="${keywords}" />
  <meta name="${description}" />
  <!-- Stylesheets -->

  <!-- Font awesome icon -->
  <link rel="stylesheet" href="/static/style/font-awesome.css"> 
  <link rel="stylesheet" href="/static/style/font-awesome.min.css">
  <link rel="stylesheet" href="/static/style/components.css"> 
  <link rel="stylesheet" href="/static/style/bootstrap.css">
  <link rel="stylesheet" href="/static/style/plugins.css"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="/static/style/jquery-ui.css"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="/static/style/fullcalendar.css">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="/static/style/prettyPhoto.css">  
  <!-- Star rating -->
  <link rel="stylesheet" href="/static/style/rateit.css">
  <!-- Date picker -->
  <link rel="stylesheet" href="/static/style/bootstrap-datepicker3.min.css">
  <link rel="stylesheet" href="/static/style/bootstrap-datetimepicker.min.css">
  <!-- CLEditor -->
  <link rel="stylesheet" href="/static/style/jquery.cleditor.css"> 
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="/static/style/bootstrap-switch.css">
  <!-- Main stylesheet -->
  <link rel="stylesheet" href="/static/style/style.css">
  <!-- Widgets stylesheet -->
  <link rel="stylesheet" href="/static/style/widgets.css">  
  <link rel="stylesheet" href="${pageCss}" > 
  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="/static/js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="/static/img/favicon/favicon.png">
</head>

<body>

 <!--header start-->
<header>
    <div class="container">
      <div class="row">

        <!-- Logo section -->
        <div class="col-md-4">
          <!-- Logo. -->
           <div class="logo">
            <h1><a href="#">GameStorm<span class="bold"></span></a></h1>
            <p class="meta">国际网络游戏后台管理系统 V1.0</p>
          </div>
          <!-- Logo ends -->
        </div>

        <!-- Button section -->
        

        <!-- Data section -->

        <div class="col-md-4">
          <div class="header-data">

            <!-- Traffic data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with red background -->
                <i class="icon-signal bred"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">7000</a> <em>visits</em></p>
              </div>
              <div class="clearfix"></div>
            </div>

            <!-- Members data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with blue background -->
                <i class="icon-user bblue"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">3000</a> <em>users</em></p>
              </div>
              <div class="clearfix"></div>
            </div>

            <!-- revenue data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with green background -->
                <i class="icon-money bgreen"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">5000</a><em>orders</em></p>
              </div>
              <div class="clearfix"></div>
            </div>                        

          </div>
        </div>
      </div>
    </div>
  </header>
   <!--header end-->
   
	<div class="content">
	
	  	<!-- Sidebar -->
	    <div class="sidebar">
	        <!--- Sidebar navigation -->
	        <!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
	        <ul id="nav" style="">
	          <!-- Main menu with font awesome icon -->
	          <li><a <#if menuId=="1">class="open"</#if> href="index.html"><i class="icon-home"></i> 控制台</a>
	          </li>
	          <li class="has_sub"><a <#if menuId=="2">class="open"</#if> href="#"><i class="icon-list-alt"></i> 游戏设置<span class="pull-right"><i class="icon-chevron-right"></i></span></a>
	            <ul>
	              <li><a href="/backend/game/manage">游戏管理</a></li>
	              <li><a href="/backend/category">类别管理</a></li>
	              <li><a href="widgets3.html">游戏类别管理</a></li>
	            </ul>
	          </li>  
	          <li ><a <#if menuId=="3">class="open"</#if> href="#"><i class="icon-file-alt"></i> 商品管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
	          </li> 
	          <li ><a <#if menuId=="4">class="open"</#if> href="/backend/order"><i class="icon-file-alt"></i> 订单管理  <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
	          </li>                             
	          <li><a <#if menuId=="5">class="open"</#if> href="charts.html"><i class="icon-bar-chart"></i> 用户管理</a></li> 
	          <li><a <#if menuId=="6">class="open"</#if> href="tables.html"><i class="icon-table"></i> 帮助中心</a></li>
	          <li><a <#if menuId=="7">class="open"</#if> href="forms.html"><i class="icon-tasks"></i> 新闻管理</a></li>
	        </ul>
	    </div>
	
	    <!-- Sidebar ends -->
	
	  	<!-- Mainbar start -->
	  	<div class="mainbar">
		  <!--content start-->
		   <#nested>
		  <!--content end-->	
	    </div>
	   <!-- Mainbar ends -->	    	
	   <div class="clearfix"></div>
	
	</div>
	
	<!-- Footer starts -->
	<footer>
	  <div class="container">
	    <div class="row">
	      <div class="col-md-12">
	            <!-- Copyright info -->
	            <p class="copy">Copyright &copy; 2012 | <a href="#">Your Site</a> Author:hsogoo </p>
	      </div>
	    </div>
	  </div>
	</footer> 	

<!-- Footer ends -->

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 


<!-- JS -->
<script src="/static/js/jquery.js"></script> <!-- jQuery -->
<script src="/static/js/bootstrap.js"></script> <!-- Bootstrap -->
<script src="/static/js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->
<script src="/static/js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="/static/js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->
<script src="/static/js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->

<script src="/static/js/sparklines.js"></script> <!-- Sparklines -->
<script src="/static/js/jquery.cleditor.min.js"></script> <!-- CLEditor -->
<script src="/static/js/bootstrap-datepicker.min.js"></script> <!-- Date picker -->
<script src="/static/js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->
<script src="/static/js/components-pickers.js"></script> <!-- Date picker -->
<script src="/static/js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->
<script src="/static/js/filter.js"></script> <!-- Filter for support page -->
<script src="/static/js/charts.js"></script> <!-- Charts & Graphs -->
<script src="/static/js/custom.js"></script> <!-- Custom codes -->
<script src="${pageJs}"></script>
</body>
</html>
</#macro>