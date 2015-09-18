@macro pagination
//totalPage 总页数
//currentPage 当前页
//ajax调用的函数名

<@macro pagination totalPage="1" currentPage="1" function="">
	<#assign startPage=0 />
    <#assign endPage = 0 />
    <#assign sideNum = 2 />

    <#if totalPage <= sideNum >
    	<#assign endPage= totalPage >
    <#else>
        <#if sideNum+currentPage >=totalPage >
            <#assign endPage = totalPage >
        <#else>
        	<#assign endPage = sideNum + currentPage >
            <#if sideNum + currentPage <= (2*sideNum+1)>
                <#if (2*sideNum+1) >= totalPage >
                    <#assign endPage = totalPage >
                <#else>
                	<#assign endPage = 2*sideNum+1 >
                </#if>
            <#else>
            	<#assign endPage = sideNum + currentPage >
            </#if>
        <#/if>
    </#if>

    <#if currentPage <= sideNum >
        <#assign startPage = 1>
    <#else>
        <#if (currentPage+sideNum) >= totalPage >
            <#if (2*sideNum+1) >= totalPage>
                <#if (totalPage - 2*sideNum) >=1 >
                    <#assign startPage = totalPage - 2*sideNum >
                <#else>
                    <#assign startPage = 1>
                </#if>
            <#else>
                <#assign startPage = totalPage - 2*sideNum>
            </#if>
        <#else>
            <#if (currentPage-sideNum) >= 1 >
                <#assign startPage = currentPage - sideNum>
            <#else>
                <#assign startPage = 1>
            </#if>
        </#if>
    </#if>

	<ul class="pagination">
		<#if startPage > 1>
			<li><a href="javascript:void(0);" onclick="${function}"({startPage-1})>Prev</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}"(1)>Prev</a></li>
		</#if>
		<#list startPage..endPage as i>
		  <li <#if currentPage?number == 1>class="active"</#if>><a href="#">1</a></li>
	 	</#list>
	 	<#if endPage < totalPage>
			<li><a href="javascript:void(0);" onclick="${function}"({endPage+1})>Prev</a></li>
		<#else>
			<li class="disabled"><a href="javascript:void(0);" onclick="${function}"({totalPage}})>Prev</a></li>
		</#if>
	</ul>
</@macro>
