<#macro page title='' keywords=title description=keywords type="base" pageCss="" pageJs="">
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
  <link href="/static/style/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="/static/style/font-awesome.css">
  <link href="/static/style/style.css" rel="stylesheet">
  <link href="${pageCss}" rel="stylesheet">
  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="/static/img/favicon/favicon.png">
</head>

<body>

  <!--content start-->
   <#nested>
  <!--content end-->	

<!-- JS -->
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="${pageCss}"></script>
</body>
</html>
</#macro>