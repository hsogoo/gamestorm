<#macro layout menuId="0">
<body class="page-header-fixed page-quick-sidebar-over-content">
	<#include "header.ftl">
	<div class="page-container">
		<#include "menu.ftl">
		<div class="page-content-wrapper">
			<!--content start-->
				<#nested>
			<!--content end-->
		</div>
	</div>
	<#include "footer.ftl">
</div>
</#macro>